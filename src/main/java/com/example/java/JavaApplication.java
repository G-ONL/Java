package com.example.java;

import java.io.IOException;
import java.util.HashMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaApplication {

  public static void main(String[] args) throws IOException {
    IssueCalculator issueCalculator = new IssueCalculator();
    issueCalculator.start();
//    SpringApplication.run(JavaApplication.class, args);
  }

}
