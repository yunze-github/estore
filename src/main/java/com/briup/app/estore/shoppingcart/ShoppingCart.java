package com.briup.app.estore.shoppingcart;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.briup.app.estore.bean.Orderline;

//购物车类，可以保存用户当前挑选的书籍信息
public class ShoppingCart {
	
	// key 商品id value 订单项（订单项中包含商品信息，数量）
	private Map<Integer, Orderline> map;
	
	public ShoppingCart() {
		map = new HashMap<Integer, Orderline>();
	}

	//向购物车中添加产品
	//先判断购物车中有没有该产品的订单项目，如果有，在数量上做改变，
	//如果没有向map中添加
	public void add(Orderline line){
		if(map.containsKey(line.getBook().getId())){
			Orderline oldline = map.get(line.getBook().getId());
			oldline.setNum(oldline.getNum()+1);
		}else{
			line.setNum(1);
			map.put(line.getBook().getId(), line);
		}
	}
	
	//删除订单项
	public void delete(Integer bookId){
		map.remove(bookId);
	}
	//获取总价钱
	public double getCost(){
		Set<Integer> keySet = map.keySet();
		Iterator<Integer> iter = keySet.iterator();
		double cost = 0.0;
		while(iter.hasNext()){
			Integer key = iter.next();
			Orderline value = map.get(key);
			Integer num = value.getNum();
			double price = value.getBook().getPrice();
			double lineCost = num*price;
			cost += lineCost;
		}
		return cost;
	}
	//获取购物车中所有订单明细
	public Map<Integer, Orderline> getLines(){
		return map;
	}
	//清空购物车
	public void clear(){
		map.clear();
	}
	
	//修改指定line中的数量
	public void update(int key,int num){
		Orderline line = map.get(key);
		if(line!=null){
			line.setNum(num);
		}
	}
	
}
