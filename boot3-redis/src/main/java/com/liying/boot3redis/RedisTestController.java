package com.liying.boot3redis;

import com.liying.boot3redis.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class RedisTestController {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @GetMapping("/count")
    public String count() {
        long hello = stringRedisTemplate.opsForValue().increment("hello");

        return "用戶訪問了【" + hello + "】次";
    }

    @GetMapping("/person/save")
    public String savePerson() {
        Person person = new Person(1L, "张三 ", 22, "男", "万科新都会一期");
        Person person2 = new Person(2L, "李四 ", 24, "男", "万科新都会一期");
        Person person3 = new Person(3L, "王五 ", 30, "男", "万科新都会一期");
        Person person4 = new Person(4L, "赵六 ", 40, "男", "万科新都会一期");

        redisTemplate.opsForValue().set("Person", person);
        redisTemplate.opsForValue().set("Person", person2);
        redisTemplate.opsForValue().set("Person", person3);
        redisTemplate.opsForValue().set("Person", person4);

        return "ok";
    }

    @GetMapping("/person/get")
    public Person getPerson() {
        Person person = (Person) redisTemplate.opsForValue().get("Person");
        return person;
    }
}
