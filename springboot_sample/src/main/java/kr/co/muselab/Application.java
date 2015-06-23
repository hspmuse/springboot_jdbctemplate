package kr.co.muselab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 1002428 on 15. 6. 23..
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(value = "kr.co.muselab")
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
