package systemCourses.spring.iocS04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import systemCourses.spring.iocS04.entity.Company;

public class SpringApplication {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-0.xml");
        Company company = context.getBean("company", Company.class);
        System.out.println(company);
    }
}
