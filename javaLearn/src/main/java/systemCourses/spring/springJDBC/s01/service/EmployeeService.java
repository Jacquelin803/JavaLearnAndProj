package systemCourses.spring.springJDBC.s01.service;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import systemCourses.spring.springJDBC.s01.dao.EmployeeDao;
import systemCourses.spring.springJDBC.s01.entity.Employee;

import java.util.Date;


public class EmployeeService {
    private EmployeeDao employeeDao;
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
    public void batchImport() {
        //定义了事务默认的标准配置
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        //开始一个事务,返回事务状态,事务状态说明当前事务的执行阶段
        TransactionStatus status = transactionManager.getTransaction(definition);

        try {
            for (int i = 1; i <= 10; i++) {
                Employee employee = new Employee();
                employee.setEno(8000 + i);
                employee.setEname("emp" + i);
                employee.setSalary(4500f);
                employee.setDname("市场部");
                employee.setHiredate(new Date());
                employeeDao.insert(employee);
            }
            //提交事务
            transactionManager.commit(status);
        } catch (RuntimeException e) {
            transactionManager.rollback(status);
            throw e;
        }

    }
}
