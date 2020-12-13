package com.example.java;

import com.example.java.four.IssueCalculator;
import java.io.IOException;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaApplication {

  public static void main(String[] args) throws IOException {



    IssueCalculator issueCalculator = new IssueCalculator();
    issueCalculator.start();
//    SpringApplication.run(JavaApplication.class, args);
  }

}
