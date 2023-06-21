package com.example.my_diary_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MyDiaryProjectApplication {

  public static void main(String[] args) {
    SpringApplication.run(MyDiaryProjectApplication.class, args);
  }

}
