package com.future.consumer.controller;

import com.future.consumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: ZhouZhiWei
 * @Description:
 * @Date: Created in 21:05 2018/8/14
 */
@RestController
public class ConsumerController {


    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.userServicePath}")
    private String userServicePath;

    @GetMapping("/req/{id}")
    public User findById(@PathVariable Long id) {
        System.out.println("========" + this.userServicePath + id);
        return this.restTemplate.getForObject(this.userServicePath + id, User.class);
    }
}
