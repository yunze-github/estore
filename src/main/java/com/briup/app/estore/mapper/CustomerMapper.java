package com.briup.app.estore.mapper;

import com.briup.app.estore.bean.Customer;
import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    Customer selectByPrimaryKey(Integer id);
    
    Customer selectByName(String name);

    List<Customer> selectAll();

    int updateByPrimaryKey(Customer record);
}