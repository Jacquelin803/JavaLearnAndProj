package systemCourses.spring.springJDBC.s03.service;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import systemCourses.spring.springJDBC.s03.dao.EmployeeDao;
import systemCourses.spring.springJDBC.s03.entity.Employee;

import javax.annotation.Resource;
import java.util.Date;

@Service
//声明式事务核心注解
//放在类上,将声明式事务配置应用于当前类所有方法,默认事务传播为 REQUIRED
@Transactional
public class EmployeeService {
    @Resource
    private EmployeeDao employeeDao;
    @Resource
    private DataSourceTransactionManager transactionManager;

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public DataSourceTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(DataSourceTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    // 批量导入
    @Transactional(propagation = Propagation.REQUIRED)
    public void batchImport() {
            for (int i = 1; i <= 10; i++) {
//                if(i==3){
//                    throw new RuntimeException("意料之外的异常");
//                }
                Employee employee = new Employee();
                employee.setEno(2000 + i);
                employee.setEname("emp" + i);
                employee.setSalary(4500f);
                employee.setDname("市场部");
                employee.setHiredate(new Date());
                employeeDao.insert(employee);
            }

    }
}
