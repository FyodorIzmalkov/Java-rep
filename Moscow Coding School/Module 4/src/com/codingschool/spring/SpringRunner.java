package com.codingschool.spring;
import com.codingschool.spring.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringRunner {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
    Person vasya = applicationContext.getBean("vasya", Person.class);
    System.out.println(vasya.getName());
}
