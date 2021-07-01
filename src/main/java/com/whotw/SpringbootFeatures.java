package com.whotw;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;

/**
 * 项目初始化入口
 */
@RestController
@EnableAutoConfiguration
public class SpringbootFeatures {

    @RequestMapping("/")
    String home() {
        StringBuffer sb = new StringBuffer();
        BufferedReader reader = null;
        try {
            String absolutePath = System.getProperty("user.dir");
            String filePath = "/doc/project.adoc";
            reader = new BufferedReader(new FileReader(absolutePath + filePath));
            String tempString = null;
            int line = 1;
            while ((tempString = reader.readLine()) != null) {
                sb.append(tempString);
                sb.append("</br>");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ignored) {
                }
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootFeatures.class, args);
    }
}