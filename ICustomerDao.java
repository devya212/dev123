package com.nucleus.dao;

import java.util.List;

import com.nucleus.model.Customer;

public interface ICustomerDao {

	public boolean insert(Customer customer);
	public boolean delete(String customerCode);
	public boolean update(Customer customer,String customerCode);
	public Customer getCustomerDetailsById(String id);
	public List<Customer> viewCustomerDetailsById(String customerCode);
	public List<Customer> viewCustomerDetailsByName(String customerName);
	public List<Customer> viewAllCustomerDetails();
	
}
