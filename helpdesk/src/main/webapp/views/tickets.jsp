
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>BCJ-HelpDesk</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon"
	href="<c:url value="/resources/theme1/css/icon3.png" />" type="image">
<link href="<c:url value="/resources/theme1/css/BCJhelpDesk.css" />" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
h1, h3, h4 {
	color: white;
	text-shadow: 3px 2px gray;
	font-family: FreeMono, monospace;
}

h2{
	color: gray;
	text-shadow: 4px 2px white;
	font-family: "Helvetic Neue", Helvetica, Arial, sans-serif;   
}
label{
	color: white;
}
</style>
</head>
<body class="bg3">
	<div class="container-fluid row">
		<div class="col-sm-4">
			<img src="<c:url value="/resources/theme1/css/icon11.png"/>"
				alt="icon11.png" height="140px" />
		</div>
		<div class="col-sm-4" align="center">
				<h1>Boot Camp Java</h1>
				<h3>How can we help you today?</h3>
		</div>
	</div>

	<nav class="navbar navbar-inverse" data-spy="affix"
		data-offset-top="197" style="background: linear-gradient(to bottom, #080808 45%, #989898 99%);">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand " href="#"><b>BCJ-HelpDesk</b></a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="returntologin">Home</a></li>
				
				<li><a href="studentTickets">My Tickets</a></li>
				<li data-toggle="tab" data-target="#contact"><a href="#"><span
						class="glyphicon glyphicon-phone-alt"></span>Contact</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li data-toggle="tab" data-target="#myProfile"><a id="Profile"
					href="#"><span class="glyphicon glyphicon-user"></span>
						My Profile</a></li>

				<li><a href="logout"><span
						class="glyphicon glyphicon glyphicon-off"></span> Logout</a></li>

			</ul>
		</div>
	</nav>

<div class = "jumbotron container" style="background: rgba(153, 51, 0, 0.5)">
	<form action="createTicket" method=POST>
		<!-- style='background-image: url("icon1.jpg")'-->
		<h2>
			<b>Create Tickets</b>
		</h2>
		<div class="container">
		<div class="form-group row">
		<div class="col-xs-4">
			<label for="ticketId">Ticket ID:</label> 
			<input type="text" class="form-control" placeholder="${ticketId}" value = "${ticketId}" name = "ticketNumber" readonly>
		</div>
		</div>
		<div class="form-group row">
		<div class ="col-xs-4">
			<label for="category">Category: </label>
			<div>
				<select id="category" class="form-control" name="category">
					<c:forEach var="item" items="${category}">
						<option value="${item}">${item}</option>
					</c:forEach>
				</select>
			</div>
			</div>
		</div>
		<div class="form-group row">
		<div class="col-xs-4">
			<label for="subcategory">Sub-category: </label>
			<div>
				<select id="subcategory" class="form-control" name="subcategory">
					
				</select>
			</div>
			</div>
		</div>
		<div class="form-group row">
		<div class="col-xs-4">
			<label for="issue/description">Issue/Description: (enter upto
				255 characters)</label><br>
			<textarea  class="form-control" row="3" maxlength="255" name="description" id="description"></textarea>
			</div>
		</div>
</div>
		<div>
			<button class="btn btn-info active" type="submit">submit</button>
		</div>

	</form>
	</div>
	<div class="tab-content">
	<div id="contact" class="container jumbotron tab-pane fade"
			style="background: rgba(153, 235, 255, 0.5)">
			<h3 align="center">Contact Details</h3><hr>
			<p>
			<pre>
			Ektha Solution is very much responsive to queries and questions through email. 
			Please send us your business inquiries through the contact form or send an email or mail on the address below. 
			We are open to phone calls on business days during business hours.
			</pre>
			</p><hr>
			<p>
			<pre>
			<b>
			Office: USA
			</b>
			
			<b>Address:</b>
			3050 Regent BLVD, STE 150 Irving, TX 75063
			
			<b>Email:</b>
			info@ekthasol.com
			
			<b>Phone:</b>
			+1 214 550 0232
			</pre>
			</p>
		</div>
		</div>
	<div>

	</div>
	<script>
	$("#category").change(function(){
		var category = $("#category").find(":selected").val();
		$.ajax({
			url: "loadSubCat",
			method: "POST",
			data: category,
			contentType: "text/plain",
			dataType: "text",
			success: function(response){
				$("#subcategory").html(response);
			}
		});
	})
		
	</script>
</body>
</html>