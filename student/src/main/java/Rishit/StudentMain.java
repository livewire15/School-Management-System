package Rishit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan
@SpringBootApplication
class StudentMain {
    public static void main(String args[])
    {
        SpringApplication.run(StudentMain.class,args);
    }
}
