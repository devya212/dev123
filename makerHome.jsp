<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/css/bootstrap.css">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<div class="container-fluid">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" class="active" href="#"><span class="glyphicon glyphicon-user"></span>WELCOME <%=(String)session.getAttribute("uid")%> </a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="add.jsp" target="_parent">Add Details<span class="glyphicon glyphicon-plus"></span> <span class="sr-only">(current)</span></a></li>
        <li><a href="delete.jsp">Delete Details<span class="glyphicon glyphicon-trash"></span></a></li>
        <li><a href="updateform.jsp">Edit Details<span class="glyphicon glyphicon-edit"></span></a></li>
        <li class="active"><a href="CustomerController?b1=1">View All<span class="glyphicon glyphicon-list"></span></a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Sort By <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Ascending Order</a></li>
            <li><a href="#">Descending Order</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left" action="CustomerController" method="post">
        <div class="form-group">
          <input type="text" class="form-control" name="code" placeholder="View By Id">
        </div>
        <button type="submit" class="btn btn-default" name="b1" value="vid">Search</button>
      </form>
      <form class="navbar-form navbar-left" action="CustomerController" method="post">
        <div class="form-group">
          <input type="text" class="form-control" name="cname" placeholder="View By Name">
        </div>
        <button type="submit" class="btn btn-default" name="b1" value="vname">Search</button>
      </form>
      
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
      </ul>
    </div> 
  </div>
</nav>
 <c:if test="${not empty requestScope.addmsg}">
   <script type="text/javascript"> alert("${requestScope.addmsg}");</script>
    </c:if>
    <c:if test="${not empty requestScope.delmsg}">
   <script type="text/javascript"> alert("${requestScope.delmsg}");</script>
    </c:if>
 
 <c:if test="${not empty requestScope.updatemsg}">
   <script type="text/javascript"> alert("${requestScope.updatemsg}");</script>
    </c:if>
 
   
<img src="vg1.jpg" style="background-size:cover;height:100%;width:100%">
</body>
</html>
