package com.lwc.mhh.service;

import com.lwc.mhh.dao.MenuDAO;
import com.lwc.mhh.domain.Menu;

import java.util.List;

/**
 * @author 刘文长
 * @version 1.0
 * 完成对menu表的各种操作(通过调用MenuDAO)
 */
public class MenuService {
    //定义MenuDAO属性
    private MenuDAO menuDAO = new MenuDAO();

    //返回所有菜品，返回给界面
    public List<Menu> list(){
        return menuDAO.queryMulti("select * from menu",Menu.class);
    }
    //根据id,返回一个Menu对象
    public Menu getMenuById(int id) {
        return menuDAO.querySingle("select * from menu where id = ?",Menu.class,id);
    }
}
