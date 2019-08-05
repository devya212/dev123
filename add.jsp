<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="sty.css">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/CustomerDetailsValidate.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Customer Details</h1>
            <div class="account-wall">
              
                <form class="form-signin" method="post" action="CustomerController">
                <label for="code">CUSTOMER CODE</label>
                <input type="text" name="code" class="form-control" id="code" placeholder="Customer Code" required autofocus>
                <label for="name">NAME</label>
                <input type="text" name="cname" class="form-control" id="cname" placeholder="Customer Name" required autofocus>
               
                <label for="caddress1">ADDRESS 1</label>
                 <textarea class="form-control" rows="5" id="caddress1" name="caddress1" required autofocus></textarea>
                
                
                 <label for="caddress2">ADDRESS 2</label>
                 <textarea class="form-control" rows="5" id="caddress2" name="caddress2"></textarea>
               <label for="pin">PIN</label>
                <input type="text" name="pin" class="form-control"  id="pin" placeholder="pin" required autofocus>
                 <label for="email">EMAIL</label>
                <input type="text" name="email" class="form-control" id="email" pattern='\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*' placeholder="Email" required autofocus>
                 <label for="contactno">CONTACT NUMBER:</label>
                <input type="text" name="contactno" class="form-control" id="contactno" pattern='[7-9]{1}[0-9]{9}' placeholder="Contact no" required autofocus>
                 <label for="cperson">PRIMARY CONTACT PERSON</label>
                <input type="text" name="cperson" class="form-control" id="cperson" placeholder="Contact person" required autofocus>
                 <label for="flag">FLAG</label>
                <select class="form-control" name="flag" id="flag" required autofocus>
                 <option value=""></option>
                 
                 <option value="A" >Active Flag</option>
                   <option value="I" >Inactive Flag</option>
                         
                    </select>
                   
              <br>
       
                <button class="btn btn-lg btn-primary btn-block" type="submit" name="b1" value="add" onclick="return validateDetails()">ADD DETAILS</button>
                </form>
               </div>
</div>
</div>
</div>

</body>
</html>