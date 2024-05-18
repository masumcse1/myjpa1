package com.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
     return  args -> {


         Student masum = new Student("gulam","samdani","samdani@gmail.com",12);
         Student mamun = new Student("mazhar","islam","mamun@gmail.com",40);

         studentRepository.saveAll(Arrays.asList(mamun,masum));
         System.out.println("------------save-----------");

         System.out.print("Number of students: ");
         System.out.println(studentRepository.count());
         System.out.print("------find student-------");
         studentRepository
                 .findById(2L)
                 .ifPresentOrElse(
                         System.out::println,
                         () -> System.out.println("Student with ID 2 not found"));



         studentRepository.findById(1l).ifPresentOrElse(System.out::println,()-> System.out.println("2 not found "));

         studentRepository.findById(1l).ifPresentOrElse(System.out::println,()-> System.out.println("3 not found "));


         System.out.println("Select all students");

         List<Student> students = studentRepository.findAll();
         students.forEach(System.out::println);

         System.out.println("delete by student");


        // studentRepository.deleteById(1l);



         System.out.println("find by email : ");


         Optional<Student> student3 = studentRepository.xx("mamun@gmail.com");
         System.out.println("info ----------$$$$$$$$$$:    ---"+student3);

         List<Student> studentList = studentRepository.abc("mazhar", 40);

         System.out.println("uuuuuuuuuuuuuu"+studentList);


         List<Student> studentlistss = studentRepository.selectStudentWhereFirstNameAndAgeGreaterOrEqualNative("mazhar", 40);
         System.out.println("naive : :   ---"+studentlistss);

         int i = studentRepository.deleteStudentById(2l);
         System.out.println("delete "+i);

         System.out.println("Select all students");
         List<Student> students1 = studentRepository.findAll();
         students1.forEach(System.out::println);


     };



    }

}
