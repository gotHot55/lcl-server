package com.micro.lcl.sleb.service.rabbitmq;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.micro.lcl.sleb.model.UserModel;
import com.micro.lcl.sleb.util.MailUtil;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 通过实现 ReturnCallback 接口，
 * 启动消息失败返回，比如路由不到队列时触发回调
 *消息机制用于处理一个不可路由的消息。在某些情况下，如果我们在发送消息的时候，
 * 当前的 exchange 不存在或者指定路由 key 路由不到，这个时候我们需要监听这种不可达的消息
 * 就需要这种return机制
 *
 * @author Administrator
 * @date 2021/1/1116:25
 */
@Service
public class LclReturnCallback extends RetryTemplate implements RabbitTemplate.ReturnCallback {
    @Autowired
    private MailUtil mailUtil;
    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        String jsonStr = new String(message.getBody());
        UserModel userModel = JSONUtil.toBean(jsonStr, UserModel.class);
        logger.error("id：" + userModel.getId()
                +"用户名："+userModel.getUsername()
                +"消息发送失败,未发送到指定队列(消息不可达):\n"
                + "返回时间: " + DateUtil.formatLocalDateTime(LocalDateTime.now())
                + ",Message: " + jsonStr
                + ",replyCode: " + i
                + ",replyText: " + s  //错误原因
                + ",exchange: " + s1
                + ",routingKey: " + s2);//queue名称
        mailUtil.sendMail("消息生产者发送消息失败（消息不可达）","id：" + userModel.getId()
                +"用户名："+userModel.getUsername()
                +"【消息发送失败,未发送到指定队列】:\n"
                + "【返回时间】: " + DateUtil.formatLocalDateTime(LocalDateTime.now())
                + ",【消息体】: " + jsonStr
                + ",【错误原因】: " + s
                + ",【交换机】: " + s1);
        //进行生产者消息回滚或转为批处理之类的业务操作
    }
}
