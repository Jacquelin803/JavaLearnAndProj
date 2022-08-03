package systemCourses.spring.iocS07.dao;


import org.springframework.stereotype.Repository;

//组件类型注解默认beanId为类名首字母小写
//beadId = userDao
// 持久化层注解->Repository,根据名称注入
@Repository
public class UserDao implements IUserDao{
    public UserDao() {
        System.out.println("正在创建UserDao:" + this);
    }
}
