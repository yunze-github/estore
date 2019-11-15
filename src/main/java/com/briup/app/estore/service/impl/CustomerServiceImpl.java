package com.briup.app.estore.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.mapper.CustomerMapper;
import com.briup.app.estore.service.ICustomerService;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

public class CustomerServiceImpl implements ICustomerService {

	@Override
	public void register(Customer customer) throws Exception {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();

		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		Customer customerFromDB = mapper.selectByName(customer.getName());

		if (customerFromDB != null) {
			throw new Exception(customerFromDB.getName() + ",用户名已存在!");
		}

		mapper.insert(customer);

		sqlSession.commit();

	}

	@Override
	public void login(Customer customer) throws Exception {

		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();

		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		Customer customerFromDB = mapper.selectByName(customer.getName());

		if (customerFromDB == null) {
			throw new Exception(customer.getName() + ":用户不存在，请先注册!");
		}

		if (!customer.getPassword().equals(customerFromDB.getPassword())) {
			throw new Exception(customerFromDB.getName() + ":用户密码错误，请重新登录!");
		}

	}

	@Override
	public Customer findCustomer(Customer customr) {

		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();

		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);

		return mapper.selectByName(customr.getName());
	}

	@Override
	public void UpdateCustomer(Customer customer) {

		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();

		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);

		mapper.updateByPrimaryKey(customer);
		
		sqlSession.commit();

	}

}
