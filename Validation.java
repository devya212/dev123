package com.nucleus.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nucleus.connection.ConnectionClass;
import com.nucleus.model.Customer;


public class Validation {
	
	public boolean dataLength(String s,int l)
	{
		if(s.length()<=l)
			return true;
		else
			return false;
	}
		public boolean isNumeric(String s)
	{
		String name ="^[0-9]+$";
		 Pattern p= Pattern.compile(name);
		 Matcher matcher=p.matcher(s);
		if(matcher.matches())
		return true;
		else
			return false;
		
	}

	public boolean checkCode(String CustomerCode)
	{
		if(!CustomerCode.isEmpty() && dataLength(CustomerCode,10))
		{
			return true;
		}
		else
			return false;
				
	}
	
	public boolean checkName(String CustomerName)
	{
		
		if(!CustomerName.isEmpty() && dataLength(CustomerName, 30))
		{
			String name ="^[a-zA-Z0-9 ]+$";
			 Pattern p= Pattern.compile(name);
			 Matcher matcher=p.matcher(CustomerName);
			if(matcher.matches())
			return true;
			else
				return false;
			/*if(CustomerName!=null && dataLength(CustomerName, 30))
			return true;
			else
				return false;*/
		}
	   else if(CustomerName.isEmpty())
		return false;
	   else
		 return false;
	}
	
	public boolean checkAddress1(String CustomerAddress1)
	{
		if(!CustomerAddress1.isEmpty() && dataLength(CustomerAddress1, 100))
		{
			return true;
		}
		else
			return false;
				
	}
	public boolean checkAddress2(String CustomerAddress2)
	{
		if(!CustomerAddress2.isEmpty() && dataLength(CustomerAddress2, 100))
		{
			return true;
		}
		else if(CustomerAddress2.isEmpty())
			return true;
		else
			return false;
				
	}
	public boolean checkprimarycontactperson(String PrimaryContactPerson)
	{
		if(!PrimaryContactPerson.isEmpty())
		{
			return true;
		}
		else
			return false;
				
	}
	public boolean checkContactNumber(String contactno)
	{
		if(!contactno.isEmpty() && dataLength(contactno,20) && isNumeric(contactno))
			return true;
		else if(contactno.isEmpty())
			return true;
		else
			return false;
	}
	
	public boolean checkcreatedate(Date CreateDate)
	{
		if(CreateDate!=null)
		{
			
			return true;
		}
		else
			return false;
				
	}
	public boolean checkcreatedby(String CreatedBy)
	{
		if(!CreatedBy.isEmpty())
		{
			return true;
		}
		else
			return false;
				
	}
	
	public boolean checkEmailId(String email)
	{
		String emailRegex ="^[_a-zA-Z0-9-\\+]+(\\.[_a-zA-Z0-9-]+)*@[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9]+)*(\\.[a-zA-Z]{2,})$";
		 Pattern p= Pattern.compile(emailRegex);
		 Matcher matcher=p.matcher(email);
		 if(matcher.matches())
		 {
			 return true;
		 }
		 
		else if (email.isEmpty())
		{
			return false;
		}
		else
		return false;
		
	}
	public boolean checkPinCode(String CustomerPinCode)
	{
		
		if(!CustomerPinCode.isEmpty() && CustomerPinCode.length()==6 && isNumeric(CustomerPinCode))
		{
			return true;
		}
		else if(CustomerPinCode.isEmpty())
		{
		return false;
		}
		else
		return false;
	}
	public boolean checkRecordStatus(String RecordStatus)
	{
		
		if(!RecordStatus.isEmpty() && RecordStatus.length()==1 && (RecordStatus.equals("N")|| RecordStatus.equals("M")|| RecordStatus.equals("D")||
				RecordStatus.equals("A")|| RecordStatus.equals("R")))
		{
			return true;
		}
		else if(RecordStatus.isEmpty())
		{
			
		 return false;
		
		}
		else
		 return false;
	}

	public boolean checkFlag(String ActiveInactiveFlag)
	{
		
		if(!ActiveInactiveFlag.isEmpty() && ActiveInactiveFlag.length()==1 && (ActiveInactiveFlag.equals("A")||ActiveInactiveFlag.equals("I")))
		{
			return true;
		}
		else if(ActiveInactiveFlag.isEmpty())
		{
		 return false;
		}
		else
		return false;
	}
	/*public boolean checkModifiedDate(Date modifiedDate)
	{
		if(modifiedDate==null || modifiedDate!=null)
		{
			
			return true;
		}
		else
			return false;
				
	}
	public boolean checkModifiedBy(String modifiedBy)
	{
		if(modifiedBy.isEmpty() || modifiedBy.isEmpty()==false)
		{
			return true;
		}
		else
			return false;
				
	}
	public boolean checkAuthorizedDate(Date authorizedDate)
	{
		if(authorizedDate==null || authorizedDate!=null)
		{
			
			return true;
		}
		else
			return false;
				
	}
	public boolean checkAuthorizedBy(String authorizedBy)
	{
		if(authorizedBy.isEmpty() || authorizedBy.isEmpty()==false)
		{
			return true;
		}
		else
			return false;
				
	}*/
	/*public boolean primarykeyValidation(String customerCode,List<Customer> list)
	{
		int c=0;
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getCustomerCode().equals(customerCode))
			{
				c=c+1;
			}
		}
		if(c==1)
		return true;
		else
			return false;
	}*/
	public boolean primaryKeyValidation(String customerCode)
	{
		int flag=0;
		ConnectionClass con1=new ConnectionClass();
		Connection con=con1.getDbConnection();
		PreparedStatement pstmt=null;
		try
		{
			pstmt=con.prepareStatement("select customer_code from customer0101 where customer_code=?");
			pstmt.setString(1, customerCode);
			ResultSet rs=pstmt.executeQuery();
		
			while(rs.next())
			{
				flag=1;
				break;
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(flag==1)
			return false;
		else
			return true;
	}
	public String errorType(Customer customer)
	{
		String s1="",s2="",s3="",s4="",s5="",s6="",s7="",s8="",s9="",s10="",s11="",s12="",s13 ="",s14="",s15="",s16="",s17="";
		boolean check1=checkCode(customer.getCustomerCode());
		boolean check2=checkName(customer.getCustomerName());
		boolean check3=checkAddress1(customer.getCustomerAddress1());
		boolean check4=checkAddress2(customer.getCustomerAddress2());
		boolean check5=checkPinCode(customer.getCustomerPinCode());
		boolean check6=checkEmailId(customer.getEmail());
		boolean check7=checkContactNumber(customer.getContactNo());
		boolean check8=checkprimarycontactperson(customer.getPrimaryContactPerson());
		boolean check9=checkRecordStatus(customer.getRecordStatus());
		boolean check10=checkFlag(customer.getFlag());
		boolean check11=checkcreatedate(customer.getCreateDate());
		boolean check12=checkcreatedby(customer.getCreatedBy());
		/*boolean check13=checkModifiedDate(customer.getModifiedDate());
		boolean check14=checkModifiedBy(customer.getModifiedBy());
		boolean check15=checkAuthorizedDate(customer.getAuthorizedDate());
		boolean check16=checkAuthorizedBy(customer.getAuthorizedBy());
	*/
		if(check1==false)
		    s1 = " customer code field length exceeds or can't be null ";
			if(check2==false)
			s2=" customer name contains special characters ";
				if(check3==false)
		     s3=" customer address not proper";
			if(check4==false)
			 s4=" customer address not proper";
			if(check5==false)
			 s5=" pincode length not 6 ";
				if(check6==false)
			 s6=" email address not proper";
				if(check7==false)
			 s7=" contact number not proper";
				if(check8==false)
		      s8=" primary contact person name not proper";
					if(check9==false)
				s9=" record status can be only N,M,R,D,A";
						if(check10==false)
				 s10=" flag can be only A,I";
					if(check11==false)
			 s11=" create date is mandatory ";
				if(check12==false)
			    s12=" created by is mandatory ";
				/*if(check13==false)
					 s13=" modified date not proper ";
				if(check14==false)
				 s14=" modified by not proper ";
	         if(check15==false)
					s15=" authorized date  not proper";
					if(check16==false)
				 s16=" authorized by not proper";
				*/	s17=s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11+s12;/*+s13+s14+s15+s16*/
			return s17;
		
		
	}
	public boolean validationFunction(Customer customer)
	{
			boolean check1=checkCode(customer.getCustomerCode());
			boolean check2=checkName(customer.getCustomerName());
			boolean check3=checkAddress1(customer.getCustomerAddress1());
			boolean check4=checkAddress2(customer.getCustomerAddress2());
			boolean check5=checkPinCode(customer.getCustomerPinCode());
			boolean check6=checkEmailId(customer.getEmail());
			boolean check7=checkContactNumber(customer.getContactNo());
			boolean check8=checkprimarycontactperson(customer.getPrimaryContactPerson());
			boolean check9=checkRecordStatus(customer.getRecordStatus());
			boolean check10=checkFlag(customer.getFlag());
			boolean check11=checkcreatedate(customer.getCreateDate());
			boolean check12=checkcreatedby(customer.getCreatedBy());
			boolean check13=primaryKeyValidation(customer.getCustomerCode());
			System.out.println(check1);
			System.out.println(check2);
			System.out.println(check3);
			System.out.println(check4);
			System.out.println(check5);
			System.out.println(check6);
			System.out.println(check7);
			System.out.println(check8);
			System.out.println(check9);
			System.out.println(check10);
			System.out.println(check11);
			System.out.println(check12);
			System.out.println(check13);
			
	
			/*boolean check13=checkModifiedDate(customer.getModifiedDate());
			boolean check14=checkModifiedBy(customer.getModifiedBy());
			boolean check15=checkAuthorizedDate(customer.getAuthorizedDate());
			boolean check16=checkAuthorizedBy(customer.getAuthorizedBy());*/
			
			if(check1==false || check2==false || check3==false || check4==false || check5==false || check6==false || check7==false || check8==false ||check9==false
					||check10==false ||check11==false||check12==false||check13==false)/*||check13==false||check14==false||check15==false || check16==false)*/
			{
				return false;
			}
			else
				return true;
		
	}
}
