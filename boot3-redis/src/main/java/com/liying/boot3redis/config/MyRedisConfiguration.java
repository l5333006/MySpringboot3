package com.liying.boot3redis.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

@Configuration
public class MyRedisConfiguration {
    //Redis 自动配置连接工厂
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        //自己定义个一个RedisTemplate对象
        RedisTemplate<Object, Object> template = new RedisTemplate();
        //设置Redis连接工厂
        template.setConnectionFactory(redisConnectionFactory);
        //使用Redis默认的序列化器将对象转换为json字符串
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());

        return template;
    }

}
