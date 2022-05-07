package com.lwc.mhh.service;

import com.lwc.mhh.dao.BillDAO;
import com.lwc.mhh.domain.Bill;

import java.util.List;
import java.util.UUID;

/**
 * @author 刘文长
 * @version 1.0
 * 处理和账单相关的业务逻辑
 */
public class BillService {
    //定义BillDAO属性
    private BillDAO billDAO = new BillDAO();
    //定义MenuService属性
    private MenuService menuService = new MenuService();
    //定义DiningTableService属性
    private DiningTableService diningTableService = new DiningTableService();
    public boolean orderMenu(int menuId,int nums,int diningTableId){
        //生成一个账单号,UUID
        String billID = UUID.randomUUID().toString();

        //将账单生成到bill表
        int update = billDAO.update("insert into bill values(null,?,?,?,?,?,now(),'未结账')",
                billID, menuId, nums, menuService.getMenuById(menuId).getPrice() * nums, diningTableId);
        if (update <= 0){
            return false;
        }
        //需要更新对应餐桌的状态
        return diningTableService.updateDiningTableState(diningTableId,"就餐中");

    }
    //返回所有的账单，提供给View调用
    public List<Bill> list(){
        return billDAO.queryMulti("select * from bill", Bill.class);
    }
}
