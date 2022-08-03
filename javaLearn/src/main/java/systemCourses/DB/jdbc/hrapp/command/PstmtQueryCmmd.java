package systemCourses.DB.jdbc.hrapp.command;

import java.sql.*;
import java.util.Scanner;

/**
 * PreparedStatement对象使用方法
 */

public class PstmtQueryCmmd implements Command {
    @Override
    public void execute() {

        System.out.print("请输入部门名称：");
        Scanner in = new Scanner(System.in);
        String pdname = in.nextLine();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            //1. 加载并注册JDBC驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. 创建数据库连接
            conn = DriverManager.getConnection("jdbc:mysql://192.168.0.114:3306/tmp?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true",
                    "root", "123456");
            //3. 创建PreparedStatement对象
            String sql = "select * from employee where dname=?";
            pstmt = conn.prepareStatement(sql);   // prepareStatement预防sql注入风险，导致界面对信息数据一览无余
            pstmt.setString(1, pdname);   // 对第一个参数赋值
            //结果集
            rs = pstmt.executeQuery();
            //4. 遍历查询结果
            //rs.next()返回布尔值，代表是否存在下一条记录
            //如果有，返回true,同时结果集提取下一条记录
            //如果没有，返回false，循环就会停止
            while (rs.next()) {
                Integer eno = rs.getInt(1);
                String ename = rs.getString("ename");
                Float salary = rs.getFloat("salary");
                String dname = rs.getString("dname");
                System.out.println(dname + "-" + eno + "-" + ename + "-" + salary);
            }
        } catch (ClassNotFoundException e) {  // 说明依赖没引入
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5. 关闭连接,释放资源
            try {
                if (conn != null & !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
