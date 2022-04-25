package ukim.finki.mk.lab2emt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class Lab2EmtApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab2EmtApplication.class, args);
    }

}
