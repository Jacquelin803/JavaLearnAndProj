package systemCourses.spring.iocS07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import systemCourses.spring.iocS07.service.DepartmentService;
import systemCourses.spring.iocS07.service.UserService;

public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService.getUdao());

        DepartmentService departmentService = context.getBean("departmentService", DepartmentService.class);
        departmentService.JoinDepartment();

        System.out.println("=================================");
        String[] ids = context.getBeanDefinitionNames();
        for(String id :ids){
            System.out.println(id+":"+context.getBean(id));
        }
    }
}
