package main.java.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.*;

/**
 * Created by yuchen on 1/18/2017.
 */

@Configuration
@ComponentScan
public class Application {

    @Bean
    MessageService mockMessageService(){
        return new MessageService() {
            @Override
            public String getMessage() {
                return "Hello World";
            }
        };
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        try {
            MessagePrinter printer = context.getBean(MessagePrinter.class);
            printer.printMessage();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
