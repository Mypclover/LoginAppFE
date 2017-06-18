<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.xgoogleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><img class="responsive-img" style="width: 150px;" src="http://www.niitstudent.com/images/ns_logo.png" /></a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
 
    </ul>
    <div class="collapse navbar-collapse" id="navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<c:if test="${isUserLoggedIn=='true'}"> 
						<!--<c:url var="Logout" value="/j_spring_security_Logout"/>--> 
						<li><a href="secure_logout"><i class="fa fa-sign-out" aria-hidden="true"></i> Sign Out </a></li>

					</c:if>
					<c:if test="${isAdmin=='true'}">
						<li><a href="<c:url value="secure_logout" />"><i class="fa fa-sign-out" aria-hidden="true"></i> Sign Out </a></li>

					</c:if>
					<c:if test="${!isUserLoggedIn=='true' && !isAdmin =='true'}">
						<li><a href="RegistrationPage"><i class="fa fa-user-plus" aria-hidden="true"></i> SignUp </a></li>
						<li><a href="Login"><i class="fa fa-sign-in" aria-hidden="true"></i> Login </a></li>
					</c:if>


				</ul>

  </div>
  </div>
</nav>
  

</body>
</html>
