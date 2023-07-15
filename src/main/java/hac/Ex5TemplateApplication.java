package hac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class Ex5TemplateApplication {
    public static void main(String[] args) {
        SpringApplication.run(Ex5TemplateApplication.class, args);
    }
}



