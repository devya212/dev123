function validateDetails()
{
	//alert("empty");
	var MyForm=document.forms[0];
	
	
	var customerCode=MyForm.code;
	if(customerCode.value.length==0 || customerCode=="" || customerCode==null)
	{
		alert("Please enter the customer Code");
		customerCode.focus();
		return false;
      }
	var customerName=MyForm.cname;
	if(customerName.value.length==0 || customerName=="" || customerName==null)
	{
		alert("Please enter the customer name");
		customerName.focus();
		return false;
     }
	
	
	var address=MyForm.caddress1;
	if(address.value.length==0 || address=="" || address==null)
	{
		alert("Please enter the address");
		address.focus();
		return false;
	}
	
	
	var pin=MyForm.pin;
	if(pin.value.length==0 || pin=="" || pin==null || pin.value.length!=6)
	{
		alert("Please enter the correct pincode of correct length");
		pin.focus();
		return false;
	}
	
	var pinnum=/[0-9]/;
	if(!pin.value.match(pinnum))
	{
		alert("Please enter only numbers in pincode");
		pin.focus();
		return false;
	}
	
	
	var email=MyForm.email;
	if(email.value.length==0 || email=="" || email==null)
	{
		alert("Please enter the email");
		email.focus();
		return false;
	}
	
	var emailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
	if(!email.value.match(emailformat))  
	{  
		alert("You have entered an invalid email address!");  
		email.focus();  
		return false;  
	}  
		
	var pno=MyForm.contactno;
	if(pno.value.length==0 || pno=="" || pno==null)
	{
		alert("Please enter the contact number");
		pno.focus();
		return false;
	}
	
	var pnonum=/[0-9]/;
	if(!pno.value.match(pnonum))
	{
		alert("Please enter only numbers in phone number");
		pno.focus();
		return false;
	}
		
	else
		return true;
  }


