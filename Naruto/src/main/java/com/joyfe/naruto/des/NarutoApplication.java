package com.joyfe.naruto.des;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.joyfe.naruto.des.util.JksProperties;

@SpringBootApplication
@EnableConfigurationProperties(JksProperties.class)
@ComponentScan("com.joyfe.naruto.des")
@EntityScan(basePackages = "com.joyfe.naruto.des.entity")
public class NarutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NarutoApplication.class, args);
	}
}
