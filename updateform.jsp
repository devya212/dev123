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
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Sign in</h1>
            <div class="account-wall">
               <!--  <img class="profile-img" src="imgg1234.png" align="center" alt=""> -->
                <form class="form-signin" method="post" action="CustomerController">
                 <label for="uid">ENTER CUSTOMER CODE FOR DETAILS UPDATION:</label>
                <input type="text" class="form-control" id="code" name="code1" placeholder="Customer Code" required autofocus>
                 <br>
                <button class="btn btn-lg btn-primary btn-block" type="submit" name="b1" value="update">SUBMIT</button>
                   </div>
</div>

</body>
</html>
