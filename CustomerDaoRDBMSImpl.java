package com.nucleus.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nucleus.connection.ConnectionClass;
import com.nucleus.model.Customer;

public class CustomerDaoRDBMSImpl implements ICustomerDao{

    ConnectionClass con1=new ConnectionClass();
	Connection con=con1.getDbConnection();
	PreparedStatement pstmt=null;
	@Override
	public boolean insert(Customer customer) {
		try {
			pstmt=con.prepareStatement("insert into customer0101(customer_code,customer_name,cust_address1,cust_address2,pin,email,contactno,contact_person,record_status,flag,create_date,created_by) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, customer.getCustomerCode());
			pstmt.setString(2, customer.getCustomerName());
			pstmt.setString(3, customer.getCustomerAddress1());
            pstmt.setString(4, customer.getCustomerAddress2());
            pstmt.setString(5, customer.getCustomerPinCode());
            pstmt.setString(6, customer.getEmail());
            pstmt.setString(7, customer.getContactNo());
            pstmt.setString(8, customer.getPrimaryContactPerson());
            pstmt.setString(9, customer.getRecordStatus());
            pstmt.setString(10, customer.getFlag());
            pstmt.setDate(11, new java.sql.Date(customer.getCreateDate().getTime()));
            pstmt.setString(12, customer.getCreatedBy());
            pstmt.executeUpdate();
            return true;
            
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
		}
		
	}
	public boolean delete(String customerCode)
	{
		try {
			pstmt=con.prepareStatement("delete from customer0101 where customer_code=?");
			
		   pstmt.setString(1, customerCode);
			pstmt.executeUpdate();
            return true;
            
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
		}
	}
	public boolean update(Customer customer,String customerCode)
	{
		try {
			pstmt=con.prepareStatement("update customer0101 set customer_code=?,customer_name=?,cust_address1=?,cust_address2=?,pin=?,email=?,contactno=?,contact_person=?,record_status=?,flag=?,modified_date=?,modified_by=? where customer_code=?");
			pstmt.setString(1, customer.getCustomerCode());
			pstmt.setString(2, customer.getCustomerName());
			pstmt.setString(3, customer.getCustomerAddress1());
            pstmt.setString(4, customer.getCustomerAddress2());
            pstmt.setString(5, customer.getCustomerPinCode());
            pstmt.setString(6, customer.getEmail());
            pstmt.setString(7, customer.getContactNo());
            pstmt.setString(8, customer.getPrimaryContactPerson());
            pstmt.setString(9, customer.getRecordStatus());
            pstmt.setString(10, customer.getFlag());
            pstmt.setDate(11, new java.sql.Date(customer.getModifiedDate().getTime()));
            pstmt.setString(12, customer.getModifiedBy());
            pstmt.setString(13, customerCode);
            pstmt.executeUpdate();
            return true;
            
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
		}
	}
	public Customer getCustomerDetailsById(String id)
	{
		Customer customer=new Customer();
		try {
			pstmt=con.prepareStatement("select customer_code,customer_name,cust_address1,cust_address2,pin,email,contactno,contact_person,record_status,flag,create_date,created_by from customer0101 where customer_code=?");
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				customer.setCustomerCode(rs.getString(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerAddress1(rs.getString(3));
				customer.setCustomerAddress2(rs.getString(4));
				customer.setCustomerPinCode(String.valueOf(rs.getInt(5)));
				customer.setEmail(rs.getString(6));
				customer.setContactNo(String.valueOf(rs.getLong(7)));
				customer.setPrimaryContactPerson(rs.getString(8));
				customer.setRecordStatus(rs.getString(9));
				customer.setFlag(rs.getString(10));
				customer.setCreateDate(rs.getDate(11));
				customer.setCreatedBy(rs.getString(12));
				
				
			}
			
            
		} catch (SQLException e) {
			e.printStackTrace();
			
			
		}
		
		
		return customer;
		
	}
	@Override
	public List<Customer> viewCustomerDetailsById(String customerCode) {
		
		List<Customer> list=new ArrayList<>();
		try {
			pstmt=con.prepareStatement("select customer_code,customer_name,cust_address1,cust_address2,pin,email,contactno,contact_person,record_status,flag,create_date,created_by,modified_date,modified_by,authorized_date,authorized_by from customer0101 where customer_code=?");
			pstmt.setString(1, customerCode);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				Customer customer=new Customer();
				list.add(customer);
				customer.setCustomerCode(rs.getString(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerAddress1(rs.getString(3));
				customer.setCustomerAddress2(rs.getString(4));
				customer.setCustomerPinCode(String.valueOf(rs.getInt(5)));
				customer.setEmail(rs.getString(6));
				customer.setContactNo(String.valueOf(rs.getLong(7)));
				customer.setPrimaryContactPerson(rs.getString(8));
				customer.setRecordStatus(rs.getString(9));
				customer.setFlag(rs.getString(10));
				customer.setCreateDate(rs.getDate(11));
				customer.setCreatedBy(rs.getString(12));
				customer.setModifiedDate(rs.getDate(13));
				customer.setModifiedBy(rs.getString(14));
				customer.setAuthorizedDate(rs.getDate(15));
				customer.setAuthorizedBy(rs.getString(16));
				
				
			}
			
            
		} 
		catch (SQLException e) {
			e.printStackTrace();
			
			
		}
		
		
		return list;
	
	
	}
	@Override
	public List<Customer> viewCustomerDetailsByName(String customerName) {
		
		List<Customer> list=new ArrayList<>();
		try {
			pstmt=con.prepareStatement("select customer_code,customer_name,cust_address1,cust_address2,pin,email,contactno,contact_person,record_status,flag,create_date,created_by,modified_date,modified_by,authorized_date,authorized_by from customer0101 where customer_name like ?");
			pstmt.setString(1, customerName+'%');
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				Customer customer=new Customer();
				list.add(customer);
				customer.setCustomerCode(rs.getString(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerAddress1(rs.getString(3));
				customer.setCustomerAddress2(rs.getString(4));
				customer.setCustomerPinCode(String.valueOf(rs.getInt(5)));
				customer.setEmail(rs.getString(6));
				customer.setContactNo(String.valueOf(rs.getLong(7)));
				customer.setPrimaryContactPerson(rs.getString(8));
				customer.setRecordStatus(rs.getString(9));
				customer.setFlag(rs.getString(10));
				customer.setCreateDate(rs.getDate(11));
				customer.setCreatedBy(rs.getString(12));
				customer.setModifiedDate(rs.getDate(13));
				customer.setModifiedBy(rs.getString(14));
				customer.setAuthorizedDate(rs.getDate(15));
				customer.setAuthorizedBy(rs.getString(16));
				
				
			}
			
            
		} 
		catch (SQLException e) {
			e.printStackTrace();
			
			
		}
		
		
		return list;
	
	
	}
	@Override
	public List<Customer> viewAllCustomerDetails() {
		List<Customer> list=new ArrayList<>();
		try {
			pstmt=con.prepareStatement("select customer_code,customer_name,cust_address1,cust_address2,pin,email,contactno,contact_person,record_status,flag,create_date,created_by,modified_date,modified_by,authorized_date,authorized_by from customer0101");
		
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				Customer customer=new Customer();
				list.add(customer);
				customer.setCustomerCode(rs.getString(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerAddress1(rs.getString(3));
				customer.setCustomerAddress2(rs.getString(4));
				customer.setCustomerPinCode(String.valueOf(rs.getInt(5)));
				customer.setEmail(rs.getString(6));
				customer.setContactNo(String.valueOf(rs.getLong(7)));
				customer.setPrimaryContactPerson(rs.getString(8));
				customer.setRecordStatus(rs.getString(9));
				customer.setFlag(rs.getString(10));
				customer.setCreateDate(rs.getDate(11));
				customer.setCreatedBy(rs.getString(12));
				customer.setModifiedDate(rs.getDate(13));
				customer.setModifiedBy(rs.getString(14));
				customer.setAuthorizedDate(rs.getDate(15));
				customer.setAuthorizedBy(rs.getString(16));		
				
			}
			
            
		} 
		catch (SQLException e) {
			e.printStackTrace();
			
			
		}
		
		
		return list;
	
		
	}
	
}
