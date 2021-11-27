package com.whotw;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

/**
 * 项目初始化入口
 */
@RestController
@EnableAutoConfiguration
public class TemplateApplication {

    @RequestMapping("/")
    String home() {

        return "success";

    }

    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class, args);
    }
}