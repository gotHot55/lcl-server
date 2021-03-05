package com.micro.lcl.sleb.config.mq;

import com.micro.lcl.sleb.service.rabbitmq.LclConfirmCallback;
import com.micro.lcl.sleb.service.rabbitmq.LclReturnCallback;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息队列配置
 *
 * @author Administrator
 * @date 2021/1/815:46
 */
@Configuration
public class RabbitConfig {

    private final LclConfirmCallback lclConfirmCallback;
    private final LclReturnCallback lclReturnCallback;

    public RabbitConfig(LclConfirmCallback lclConfirmCallback, LclReturnCallback lclReturnCallback) {
        this.lclConfirmCallback = lclConfirmCallback;
        this.lclReturnCallback = lclReturnCallback;
    }
    //路由键
    @Value("${routing:routing_key_dev}")
    private String routing;
    //队列
    @Value("${queue:queue_key_dev}")
    private String queue;
    /**
     * 交换机名字
     */
    public static final String EXCHANGE_LCL = "exchange_lcl";
    /**
     * 死信交换机
     */
    private static final String DLX_EXCHANGE_LCL = "dlx_exchange_lcl";

    /**
     * 死信队列
     */
    private static final String DLX_QUEUE_LCL = "dlx_queue_lcl";

    /**
     * 消息交换机
     * @return
     */
    @Bean("lclExchange")
    public DirectExchange lclExchange() {
        return ExchangeBuilder.directExchange(EXCHANGE_LCL).durable(true).build();
    }

    /**
     * 消息队列
     * @return
     */
    @Bean("lclQueue")
    public Queue lclQueue() {
        return QueueBuilder.durable(queue).build();
    }

    /**
     * 交换机、队列、绑定
     * @param queue
     * @param directExchange
     * @return
     */
    @Bean("bindingLclExchange")
    public Binding bindingLclExchange(@Qualifier("lclQueue") Queue queue ,
                                        @Qualifier("lclExchange") DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with(routing);
    }

    /**
     * 死信交换机
     * @return
     */
    @Bean("dlxLclExchange")
    public DirectExchange dlxLclExchange() {
        return ExchangeBuilder.directExchange(DLX_EXCHANGE_LCL).durable(true).build();
    }

    /**
     * 死信队列
     * @return
     */
    @Bean("dlxLclQueue")
    public Queue dlxLclQueue() {
        return QueueBuilder.durable(DLX_QUEUE_LCL).build();
    }

    /**
     * 死信交换机、队列、绑定
     */
    @Bean("bindingDlxLclExchange")
    public Binding bindingDlxLclExchange(@Qualifier("dlxLclQueue") Queue queue,
                                         @Qualifier("dlxLclExchange") DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with(routing);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setConfirmCallback(lclConfirmCallback);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setRetryTemplate(lclReturnCallback);
        //使用单独的发送连接，避免生产者由于各种原因阻塞而导致消费者同样阻塞
        rabbitTemplate.setUsePublisherConnection(true);
        return rabbitTemplate;
    }
}
