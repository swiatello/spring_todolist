package pl.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ToDoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ToDoApplication.class, args);
    }
}
