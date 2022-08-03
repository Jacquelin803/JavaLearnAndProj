package spring;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//如果使用编程式事务，将s03改为s01,s03为注解式事务
import systemCourses.spring.springJDBC.s03.dao.EmployeeDao;
import systemCourses.spring.springJDBC.s03.entity.Employee;
import systemCourses.spring.springJDBC.s03.service.EmployeeService;
//=============================================

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-springJdbc03.xml"})

public class SpringJdbcTest {
    @Resource  // 在IOC容器中找到employeeDao
    private EmployeeDao employeeDao;
    @Resource  // 在IOC容器中找到employeeService
    private EmployeeService employeeService;

    @Test
    public void testFindById() {
        Employee employee = employeeDao.findById(3420);
        System.out.println(employee);
    }

    @Test
    public void testFindByDname() {
        List<Employee> list = employeeDao.findByDname("市场部");
        System.out.println(list);
    }

    @Test
    public void testFindMapByDname() {
        System.out.println(employeeDao.findMapByDname("市场部"));
    }

    @Test
    public void testInsert() {
        Employee employee = new Employee();
        employee.setEno(8889);
        employee.setEname("赵六");
        employee.setSalary(6666f);
        employee.setDname("研发部");
        employee.setHiredate(new Date());
        employeeDao.insert(employee);
    }

    @Test
    public void testUpdate() {
        Employee employee = employeeDao.findById(8888);
        employee.setSalary(employee.getSalary() + 3000);
        int cnt = employeeDao.update(employee);
        System.out.println(cnt);
    }

    @Test
    public void BatchImport(){
        employeeService.batchImport();
    }


}
