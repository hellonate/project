package com.cmos.project.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;


@Configuration
@EnableKafka
public class KafkaConfig {

    private static final Logger log = LoggerFactory.getLogger(KafkaConfig.class);
    @Value("${spring.kafka.producer.bootstrap-servers}")
    private String BOOTSTRAP_SERVERS_CONFIG;

    @Value("${spring.kafka.producer.retries}")
    private String RETRIES_CONFIG;

    @Value("${spring.kafka.producer.batch-size}")
    private String BATCH_SIZE_CONFIG;

    @Value("${spring.kakfa.producer.linger-ms}")
    private String LINGER_MS_CONFIG;

    @Value("${spring.kafka.producer.buffer-memory}")
    private String BUFFER_MEMORY_CONFIG;


    @Value("${spring.kafka.producer.properties.max.requst.size}")
    private String MAX_REQUEST_SIZE_CONFIG;

    @Value("${spring.kafka.producer.key-serializer}")
    private String KEY_SERIALIZER_CLASS_CONFIG;

    @Value("${spring.kafka.producer.value-serializer}")
    private String VALUE_SERIALIZER_CLASS_CONFIG;

    @Value("${spring.kafka.name}")
    private String KafkaName;


    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        //props.put(ProducerConfig.ACKS_CONFIG, "all");
        log.info("加载配置文件信息");
        log.info(KafkaName + "," + BOOTSTRAP_SERVERS_CONFIG + "," + RETRIES_CONFIG + "," + BATCH_SIZE_CONFIG + "," + LINGER_MS_CONFIG + "," + BUFFER_MEMORY_CONFIG + "," + MAX_REQUEST_SIZE_CONFIG + "," + KEY_SERIALIZER_CLASS_CONFIG + "," + VALUE_SERIALIZER_CLASS_CONFIG);
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_CONFIG);
        props.put(ProducerConfig.RETRIES_CONFIG, RETRIES_CONFIG);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, BATCH_SIZE_CONFIG);
        props.put(ProducerConfig.LINGER_MS_CONFIG, LINGER_MS_CONFIG);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, BUFFER_MEMORY_CONFIG);
        props.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, MAX_REQUEST_SIZE_CONFIG);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KEY_SERIALIZER_CLASS_CONFIG);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, VALUE_SERIALIZER_CLASS_CONFIG);
        return props;
    }

    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    /******************consumer configuration**********************/

//    @Bean
//    public Map<String, Object> consumerConfigs(){
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.22.241.162:9092,172.22.241.163:9092,172.22.241.164:9092");
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test");
//        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
//        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
//        return props;
//    }
//
//    @Bean
//    public ConsumerFactory<String, Object> consumerFactory(){
//        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
//    }
//
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory(){
//        ConcurrentKafkaListenerContainerFactory<String,Object> factory = new ConcurrentKafkaListenerContainerFactory<String, Object>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }
//
//    //实际执行消费的类
//
//    @Bean
//    public MyKafkaMessageListener myMessageListener() {
//        return new MyKafkaMessageListener();
//    }
//
//    //消费者容器配置信息
//    @Bean
//    public ContainerProperties containerProperties() {
//        //Pattern topicPattern = Pattern.compile(".*[tT]opic.*"); //匹配满足正则的topic   activityLog
//        Pattern topicPattern = Pattern.compile(KafkaName);
//        log.info("kafkaName:"+KafkaName);
//        ContainerProperties containerProperties = new ContainerProperties(topicPattern);//订阅满足正则表达式的topic
//        containerProperties.setMessageListener(myMessageListener());//订阅的topic的消息用myMessageListener去处理
//        return containerProperties;
//    }
//
//    @Bean
//    public KafkaMessageListenerContainer<String, Object> kafkaMessageListenerContainer(){
//
//        return new KafkaMessageListenerContainer<String, Object>(consumerFactory(), containerProperties());
//    }
    /* --------------kafka template configuration-----------------**/
    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        KafkaTemplate<String, Object> kafkaTemplate = new KafkaTemplate<String, Object>(producerFactory());
        kafkaTemplate.setDefaultTopic("defaultTopic");
        return kafkaTemplate;
    }

}
