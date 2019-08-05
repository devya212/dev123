package com.nucleus.service;

import java.util.ArrayList;
import java.util.List;

import com.nucleus.dao.CustomerDaoRDBMSImpl;
import com.nucleus.dao.ICustomerDao;
import com.nucleus.model.Customer;

public class CustomerServiceImpl implements ICustomerService {
	ICustomerDao icdao=new CustomerDaoRDBMSImpl();
	boolean check;
	List<Customer> list;
	public boolean insert(Customer customer)
	{
		check=icdao.insert(customer);
		return check;
		
	}
	public boolean delete(String customerCode)
	{
	     check=icdao.delete(customerCode);
		return check;
	}
	public boolean update(Customer customer,String customerCode)
	{
	       check=icdao.update(customer,customerCode);
		return check;
		
	}
	public Customer getCustomerDetailsById(String id)
	{
		Customer customer=icdao.getCustomerDetailsById(id);
		return customer;
	}
	@Override
	public List<Customer> viewCustomerDetailsById(String customerCode) {
        list=icdao.viewCustomerDetailsById(customerCode);
		return list;
	}
	@Override
	public List<Customer> viewAllCustomerDetails() {
		 list=icdao.viewAllCustomerDetails();
		return list;
	}
	@Override
	public List<Customer> viewCustomerDetailsByName(String customerName) {
		
		 list=icdao.viewCustomerDetailsByName(customerName);
		return list;
	}
	
}
