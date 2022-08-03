package systemCourses.DB.jdbc.hrapp.command;

import systemCourses.DB.jdbc.common.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 新增员工数据
 */
public class InsertCommand implements Command {
    @Override
    public void execute() {

        Scanner in =new Scanner(System.in);
        System.out.print("请输入员工编号:");
        int eno=in.nextInt();
        System.out.print("请输入员工姓名:");
        String ename=in.next();
        System.out.print("请输入员工薪资:");
        float salary =in.nextFloat();
        System.out.print("请输入隶属部门:");
        String dname=in.next();
//        System.out.print("请输入入职日期：");
//        String strHireDate=
        Connection conn=null;
        PreparedStatement pstmt = null;

        try {
            conn= DbUtils.getConnection();
            String sql="insert into employee(eno,ename,salary,dname) values(?,?,?,?)";
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,eno);
            pstmt.setString(2,ename);
            pstmt.setFloat(3,salary);
            pstmt.setString(4,dname);
            int cnt=pstmt.executeUpdate(); //所有写操作都使用executeUpdate
            System.out.println("cnt: "+cnt);
            System.out.println(ename + "员工入职手续已办理");
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            DbUtils.closeConnection(null,pstmt,conn);
        }
    }
}
