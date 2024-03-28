package com.liying.boot3redis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.*;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.UUID;

@SpringBootTest
class Boot3RedisApplicationTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
        //Stirng字符串
        stringRedisTemplate.opsForValue().set("haha", UUID.randomUUID().toString());
        String v = stringRedisTemplate.opsForValue().get("haha");
        System.out.println(v);
    }

    @Test
    void testList() {
        //集合
        String name = "listName";
        stringRedisTemplate.opsForList().leftPush(name, "1");
        stringRedisTemplate.opsForList().leftPush(name, "2");
        stringRedisTemplate.opsForList().leftPush(name, "3");

        String pop = stringRedisTemplate.opsForList().leftPop(name);
        Assertions.assertEquals("3", pop);
    }

    @Test
    void TestSet() {
        //set集合
        String name = "setTest";
        //給集合中加入元素
        stringRedisTemplate.opsForSet().add(name, "1", "2", "3", "4", "5", "6");
        //判斷集合中是否存在某個元素
        boolean b = stringRedisTemplate.opsForSet().isMember(name, "2");
        System.out.println(b);

        boolean b2 = stringRedisTemplate.opsForSet().isMember(name, "8");
        System.out.println(b2);
    }

    @Test
    void Testzset() {
        //有序的set集合
        String name = "myset";
        stringRedisTemplate.opsForZSet().add(name, "劉德華", 9);
        stringRedisTemplate.opsForZSet().add(name, "張學友", 10);
        stringRedisTemplate.opsForZSet().add(name, "李小龍", 2);
        stringRedisTemplate.opsForZSet().add(name, "黎明", 7);
        stringRedisTemplate.opsForZSet().add(name, "周杰倫", 4);
        ZSetOperations.TypedTuple<String> popMax = stringRedisTemplate.opsForZSet().popMax(name);
        String value = popMax.getValue();
        Double c = popMax.getScore();
        System.out.println(value + "---->" + c);

    }

    @Test
    void TestHash() {
        //map集合
        String name = "myHashMap";
        stringRedisTemplate.opsForHash().put(name, "name", "張三");
        stringRedisTemplate.opsForHash().put(name, "age", "18");
        System.out.println(stringRedisTemplate.opsForHash().get(name, "name"));

    }
}
