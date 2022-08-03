package systemCourses.DB.jdbc.hrapp;


import systemCourses.DB.jdbc.hrapp.command.*;

import java.util.Scanner;

public class HumanResourceApp {

    public static void main(String[] args) {

        System.out.println("1-查询部门员工");
        System.out.println("2-办理员工入职");
        System.out.println("3-调整薪资");
        System.out.println("4-员工离职");
        System.out.println("5-分页查询员工数据");
        System.out.println("请选择功能:");

        Scanner in = new Scanner(System.in);
        Integer frontCmd = in.nextInt();
        Command cmmd = null;

        switch (frontCmd) {
            case 1:
                cmmd = new PstmtQueryCmmd();
                cmmd.execute();
                break;
            case 2:
                cmmd=new InsertCommand();
                cmmd.execute();
                break;
            case 3:
                cmmd=new UpdateCommand();
                cmmd.execute();
                break;
            case 4:
                cmmd=new DeleteCommand();
                cmmd.execute();
                break;
        }
    }
}

