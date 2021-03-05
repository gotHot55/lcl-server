package com.micro.lcl.sleb.util;

import com.micro.lcl.sleb.config.mail.MailConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/1/1116:49
 */
@Component
@Slf4j
public class MailUtil {
    private final MailSender mailSender;
    private final MailConfig mailConfig;

    public MailUtil(MailSender mailSender, MailConfig mailConfig) {
        this.mailSender = mailSender;
        this.mailConfig = mailConfig;
    }

    public void sendMail(String subject, String content) {
        // new 一个简单邮件消息对象
        SimpleMailMessage message = new SimpleMailMessage();
        // 和配置文件中的的username相同，相当于发送方
        message.setFrom(mailConfig.getFrom());
        // 收件人邮箱
        message.setCc(mailConfig.getRecipient());
        message.setSubject("服务【环境"+mailConfig.getEnvironmental()+"】"+subject);//标题
        //正文
        message.setText(content);
        try {
            mailSender.send(message);
        } catch (MailException e) {
            // 服务不可用了
            e.printStackTrace();
            log.error("发送邮件异常，异常信息为：" + e.getMessage());
        }

    }
}
