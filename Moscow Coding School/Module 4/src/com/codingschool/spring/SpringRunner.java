package com.codingschool.spring;
import com.codingschool.spring.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringRunner {
<<<<<<< HEAD
    public static void main(String args[]) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Person vasya = applicationContext.getBean("vasya", Person.class);
        System.out.println(vasya.getName());
    }
}
=======
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
    Person vasya = ApplicationContext.getBean("vasya", Person.class);
    System.out.println(vasya.getName());
}
>>>>>>> 28792a8bd33660a15d664109a6c5a0f4ec0ee070
