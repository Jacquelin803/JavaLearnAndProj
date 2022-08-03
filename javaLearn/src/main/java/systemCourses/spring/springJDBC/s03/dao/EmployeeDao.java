package systemCourses.spring.springJDBC.s03.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import systemCourses.spring.springJDBC.s03.entity.Employee;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository //持久化层annotation

public class EmployeeDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //查询单条数据
    public Employee findById(Integer eno) {
        String sql = "select * from employee where eno=?";
        Employee employee = jdbcTemplate.queryForObject(sql, new Object[]{eno},
                new BeanPropertyRowMapper<Employee>(Employee.class));
        return employee;
    }

    //查询复合数据
    public List<Employee> findByDname(String dname) {
        String sql = "select * from employee where dname=?";
        List<Employee> list = jdbcTemplate.query(sql, new Object[]{dname},
                new BeanPropertyRowMapper<Employee>(Employee.class));
        return list;
    }

    //将查询结果作为Map进行封装
    public List<Map<String, Object>> findMapByDname(String dname) {
        String sql = "select * from employee where dname=?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, new Object[]{dname});
        return maps;
    }

    //利用update方法实现数据写入操作
    public void insert(Employee employee) {
        String sql = "insert into employee(eno,ename,salary,dname,hiredate) values(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{
                employee.getEno(), employee.getEname(), employee.getSalary(), employee.getDname(), employee.getHiredate()
        });
    }

    // update
    public int update(Employee employee) {
        String sql = "UPDATE employee SET ename = ?, salary = ?, dname = ?, hiredate = ? WHERE eno = ?";
        int num = jdbcTemplate.update(sql, new Object[]{
                employee.getEname(), employee.getSalary(), employee.getDname(),
                employee.getHiredate(), employee.getEno()
        });

        return num;
    }

    // delete
    public int delete(Integer eno) {
        String sql = "delete from employee where eno = ?";
        return jdbcTemplate.update(sql, new Object[]{eno});
    }

}
