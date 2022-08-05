package com.example.activate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import javax.management.Query;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class ActivateApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivateApplication.class, args);
    }
@Bean
    CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate){
        return args -> {
            String email = "larry4christ@gmail.com";
            Address address = new Address("England", "London", "NE9");
            Students students =new Students("Jamila", "Ahmed",email, Gender.MALE, address, List.of("cs"), BigDecimal.TEN, LocalDateTime.now());

            var query1 = new org.springframework.data.mongodb.core.query.Query();
            query1.addCriteria(Criteria.where("email").is(email));
           List<Students> students1=  mongoTemplate.find(query1, Students.class);

            if(students1.size()>1){
                throw new IllegalStateException(
                        "found many students with email "+ email
                        );
            }

            if(students1.isEmpty()){
                System.out.println("Inserting Student "+students);
                repository.save(students);
            }
            else {
                System.out.println("student with the email "+email+" already exist");
            }

        } ;

        //Students st = new Students()
}


}
