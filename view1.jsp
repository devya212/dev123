<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<center><h3 style="color:red">CUSTOMER DETAILS</h3></center>
<div class="container-fluid">
<table class="table table-striped table-bordered table-hover">
                  <thead  class="thead-dark">
							<tr>
								
								<th>Customer Code</th>
								<th>Customer Name</th>
								<th>Address1</th>
								<th>Address2</th>
								<th>Pin Code</th>
								<th>Email</th>
								<th>Contact No</th>
								<th>Primary Contact Person</th>
								<th>Record Status</th>
								<th>Flag Status</th>
								<th>Create Date</th>
								<th>Created By</th>
								<th>Modified date</th>
								<th>Modified by</th>
								<th>Authorized date</th>
								<th>Authorized by</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="u1" items="${requestScope.list}">
							<tr>
								<td>${u1.customerCode}</td>
								<td>${u1.customerName}</td>
								<td>${u1.customerAddress1}</td>
								<td>${u1.customerAddress2}</td>
								<td>${u1.customerPinCode}</td>
								<td>${u1.email}</td>
								<td>${u1.contactNo}</td>
								<td>${u1.primaryContactPerson}</td>
								<td>${u1.recordStatus}</td>
								<td>${u1.flag}</td>
								<td>${u1.createDate}</td>
								<td>${u1.createdBy}</td>
								<td>${u1.modifiedDate}</td>
								<td>${u1.modifiedBy}</td>
								<td>${u1.authorizedDate}</td>
								<td>${u1.authorizedBy}</td>
								
							</tr>
							</c:forEach>
						</tbody>

</table>
</div>

</body>
</html>