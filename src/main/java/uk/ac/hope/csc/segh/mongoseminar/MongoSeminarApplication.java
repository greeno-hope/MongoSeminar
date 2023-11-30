package uk.ac.hope.csc.segh.mongoseminar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class MongoSeminarApplication {


    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(MongoSeminarApplication.class, args);

        // Debugging to try and work out why yaml fiels are not being picked up in IntelliJ
        // I'll fix this before the new year.
        String[] activeProfiles = context.getEnvironment().getActiveProfiles();
        System.out.println("Active Profiles: " + Arrays.toString(activeProfiles));
    }

}
