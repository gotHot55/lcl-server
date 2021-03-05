package com.micro.lcl.sleb.config.mail;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/1/814:17
 */
@Configuration
@ConfigurationProperties(prefix = "mail-config")
@Data
public class MailConfig {
    private String environmental;
    private String from;
    private String[] recipient = null;

    /*@Bean
    public JavaMailSenderImpl mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setProtocol("SMTP");
        mailSender.setHost("smtp.qq.com");
        mailSender.setPort(465);
        return mailSender;
    }*/
}
