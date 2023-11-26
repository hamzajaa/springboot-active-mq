package com.example.springboot_active_mq.config;

import jakarta.jms.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@Configuration
@EnableJms // enable jms features and configurations like creating the message listener container
public class JmsConfig {

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory) { // CachingConnectionFactory by default
        DefaultJmsListenerContainerFactory jmsListenerContainerFactory =
                new DefaultJmsListenerContainerFactory();

        jmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        jmsListenerContainerFactory.setConcurrency("5-10"); // init 5 consumers and maximum 10 consumer if necessary

        return jmsListenerContainerFactory;
    }

}
