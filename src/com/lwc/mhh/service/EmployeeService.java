package com.lwc.mhh.service;

import com.lwc.mhh.dao.EmployeeDAO;
import com.lwc.mhh.domain.Employee;

/**
 * @author 刘文长
 * @version 1.0
 * 该类完成对employee表的各种操作(通过调用EmployeeDAO对象完成)
 */
public class EmployeeService {
    //定义一个EmployeeDAO属性
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    //方法，根据empId 和 pwd 返回一个 Employee对象
    //如果查询不到就返回一个null
    public Employee getEmployeeByIdAndPwd(String empId, String pwd) {
        return employeeDAO.querySingle("select * from employee where empId=? and pwd=md5(?)", Employee.class, empId, pwd);
    }
}
