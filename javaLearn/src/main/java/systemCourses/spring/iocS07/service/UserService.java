package systemCourses.spring.iocS07.service;

import org.springframework.stereotype.Service;
import systemCourses.spring.iocS07.dao.IUserDao;

import javax.annotation.Resource;

@Service
public class UserService {
    public UserService() {
        System.out.println("正在创建UserService:" + this);
    }

    //Spring IoC容器会自动通过反射技术将属性private修饰符自动改为public,直接进行赋值
    //不再执行set方法
//    @Autowired
    @Resource(name = "userOracleDao")   //想用哪个，可以用name指定好
    private IUserDao udao;

    public IUserDao getUdao() {
        System.out.println("UserService-class setUdao:" + udao);
        return udao;
    }

    //@Autowired
    //如果装配注解放在set方法上,则自动按类型/名称对set方法参数进行注入
    public void setUdao(IUserDao udao) {
        System.out.println("UserService-class setUdao:" + udao);
        this.udao = udao;
    }
}
