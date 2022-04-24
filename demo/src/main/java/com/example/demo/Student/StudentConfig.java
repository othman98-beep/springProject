package com.example.demo.Student;

import com.example.demo.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student othman = new Student(
                 "Othmane Hssaini",
                 "othmane.hssaini@uir.ac.ma",
                 LocalDate.of(1998, Month.JULY,14)
            );
            Student saad = new Student(
                    "Benghanem Saad",
                    "benSaadf@gmail.com",
                    LocalDate.of(1997, Month.OCTOBER,17)
            );
            Student nadir = new Student(
                    "Ammor Nadir",
                    "nadir.ammor@uir.ac.ma",
                    LocalDate.of(2000, Month.MAY,24)
            );
            repository.saveAll(
                    List.of(othman,saad,nadir)
            );
        };
    }
}
