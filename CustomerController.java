package com.nucleus.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nucleus.model.Customer;
import com.nucleus.model.Validation;
import com.nucleus.service.CustomerServiceImpl;
import com.nucleus.service.ICustomerService;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//request.setAttribute("b1",request.getParameter("b1"));
		//PrintWriter out=response.getWriter();
		//out.print(i);
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		boolean check;
		Customer customer=new Customer();
		Validation validation=new Validation();
		HttpSession session=request.getSession(); 
		PrintWriter out=response.getWriter();
		DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
		Date dateobj = new Date();
		System.out.println(df.format(dateobj));
        ICustomerService ics=new CustomerServiceImpl();
        RequestDispatcher rd=null;
        Customer c1;
        
       
		
		if(request.getParameter("b1").equals("add"))
        {
			 customer.setCustomerCode(request.getParameter("code"));
				customer.setCustomerName(request.getParameter("cname"));
				customer.setCustomerAddress1(request.getParameter("caddress1"));
				customer.setCustomerAddress2(request.getParameter("caddress2"));
				customer.setCustomerPinCode(request.getParameter("pin"));
				customer.setEmail(request.getParameter("email"));
				customer.setContactNo(request.getParameter("contactno"));
				customer.setPrimaryContactPerson(request.getParameter("cperson"));
				customer.setFlag(request.getParameter("flag"));
        customer.setRecordStatus("N");
		customer.setCreateDate(dateobj);
		customer.setCreatedBy((String)session.getAttribute("uid"));
		
		 check=validation.validationFunction(customer);
		out.print(check);
		if(check==true)
		{
			boolean c=ics.insert(customer);
			if(c)
			{
				request.setAttribute("addmsg","customer details added successfully");
                rd=request.getRequestDispatcher("/makerHome.jsp");
                rd.forward(request,response);

			}
			else
			{
				request.setAttribute("addmsg","customer details not  added successfully");
                rd=request.getRequestDispatcher("/makerHome.jsp");
                rd.forward(request,response);

			}
		}
		else
		{
			
		}
        }
        if(request.getParameter("b1").equals("update"))
        {
        	
        	c1=ics.getCustomerDetailsById(request.getParameter("code1"));
        	request.setAttribute("customer", c1);
        	rd=request.getRequestDispatcher("/update.jsp");
        	rd.forward(request, response);
        	
        }
        if(request.getParameter("b1").equals("delete"))
        {
        	boolean ck=ics.delete(request.getParameter("code"));
        	if(ck==true)
        	{
        		request.setAttribute("delmsg","customer details deleted successfully");
                rd=request.getRequestDispatcher("/makerHome.jsp");
                
                rd.forward(request,response);

        	}
        	else
        	{
        		request.setAttribute("delmsg","customer details not deleted successfully");
                rd=request.getRequestDispatcher("/makerHome.jsp");
                
                rd.forward(request,response);

        		
        	}
        	
        }
        if(request.getParameter("b1").equals("toupdate"))
        {
        	customer.setCustomerCode(request.getParameter("code"));
     		customer.setCustomerName(request.getParameter("cname"));
     		customer.setCustomerAddress1(request.getParameter("caddress1"));
     		customer.setCustomerAddress2(request.getParameter("caddress2"));
     		customer.setCustomerPinCode(request.getParameter("pin"));
     		customer.setEmail(request.getParameter("email"));
     		customer.setContactNo(request.getParameter("contactno"));
     		customer.setPrimaryContactPerson(request.getParameter("cperson"));
     		customer.setFlag(request.getParameter("flag"));
        	customer.setRecordStatus("M");
        	customer.setModifiedDate(dateobj);
        	customer.setModifiedBy((String)session.getAttribute("uid"));
        	DateFormat df1=new SimpleDateFormat("yyyy-mm-dd");
        	Date date;
			try {
				date = df1.parse(request.getParameter("createdate"));
				customer.setCreateDate(date);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
        	
        	customer.setCreatedBy(request.getParameter("createdby"));
        	check=validation.validationFunction(customer);
        	if(check==true)
        	{
        		boolean c=ics.update(customer,request.getParameter("code1"));
        		if(c)
        		{
        		request.setAttribute("updatemsg","customer details updated successfully");
                rd=request.getRequestDispatcher("/makerHome.jsp");
                
               rd.forward(request,response);
        		}
        		else
        		{
        			request.setAttribute("updatemsg","customer details not updated successfully");
                    rd=request.getRequestDispatcher("/makerHome.jsp");
                    
                   rd.forward(request,response);
        		}

        	}
        	else
        	{
        		
        	}
        }
        if(request.getParameter("b1").equals("vid"))
        {
        	List<Customer> list1=ics.viewCustomerDetailsById(request.getParameter("code"));
        	request.setAttribute("list",list1);
        	rd=request.getRequestDispatcher("/view1.jsp");
        	rd.forward(request, response);
        	
        }
        if(request.getParameter("b1").equals("vname"))
        {
        	List<Customer> list1=ics.viewCustomerDetailsByName(request.getParameter("cname"));
        	request.setAttribute("list",list1);
        	rd=request.getRequestDispatcher("/view1.jsp");
        	rd.forward(request, response);
        }
        if(request.getParameter("b1").equals("1"))
        {
        	List<Customer> list1=ics.viewAllCustomerDetails();
        	request.setAttribute("list",list1);
        	rd=request.getRequestDispatcher("/view1.jsp");
        	rd.forward(request, response);
        }
        	
		
	}

}
