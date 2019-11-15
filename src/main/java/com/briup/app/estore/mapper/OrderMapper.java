package com.briup.app.estore.mapper;

import com.briup.app.estore.bean.Order;
import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    Order selectByPrimaryKey(Integer id);
    
    List<Order> selectByCustomerId(Integer id);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);
}