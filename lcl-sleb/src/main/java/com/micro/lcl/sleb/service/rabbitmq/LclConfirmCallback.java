package com.micro.lcl.sleb.service.rabbitmq;

import cn.hutool.core.date.DateUtil;
import com.micro.lcl.sleb.util.MailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 如果消息没有到exchange,则confirm回调,ack=false
 * 如果消息到达exchange,则confirm回调,ack=true
 *
 *通过实现 ConfirmCallback 接口，
 * 消息发送到 Broker 后触发回调，确认消息是否到达 Broker 服务器，
 * 也就是只确认是否正确到达 Exchange 中
 * @author Administrator
 * @date 2021/1/1116:28
 */
@Service
@Slf4j
public class LclConfirmCallback implements RabbitTemplate.ConfirmCallback {
    @Autowired
    private MailUtil mailUtil;
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if (b) {
            log.info("消息发送成功:\n"
                    + "返回时间: " + DateUtil.formatLocalDateTime(LocalDateTime.now())
                    + ",发送消息: " + correlationData.getReturnedMessage());
        }else {
            log.info("消息发送失败，未路由到交换机:\n"
                    + "返回时间: " + DateUtil.formatLocalDateTime(LocalDateTime.now())
                    + ",发送消息: " + correlationData.getReturnedMessage()
                    +"失败原因："+s);
            mailUtil.sendMail("消息生产者发送消息失败","消息发送失败，未路由到交换机:\n"
                    + "返回时间: " + DateUtil.formatLocalDateTime(LocalDateTime.now())
                    + ",发送消息: " + correlationData.getReturnedMessage()
                    +"失败原因："+s);
            //业务逻辑处理，回滚等工作
        }
    }
}
