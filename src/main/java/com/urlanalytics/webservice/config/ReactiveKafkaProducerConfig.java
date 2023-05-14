package com.urlanalytics.webservice.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.mustache.MustacheProperties.Reactive;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;

import reactor.kafka.sender.SenderOptions;

@Configuration
public class ReactiveKafkaProducerConfig {
        private String bootstrapServers;

        @Bean
        public Map<String, Object> producerConfigs() {
                Map<String, Object> props = new HashMap<>();
                props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                                bootstrapServers);
                props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                                StringSerializer.class);
                props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                                StringSerializer.class);
                return props;
        }

        @Bean
        public ReactiveKafkaProducerTemplate<String, String> reactiveKafkaProducerTemplate() {
                return new ReactiveKafkaProducerTemplate<String, String>(SenderOptions.create(producerConfigs()));
        }

}
