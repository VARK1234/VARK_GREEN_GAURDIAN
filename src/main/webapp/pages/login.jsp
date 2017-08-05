<jsp:directive.include
	file="header.jspf" />
	
	<body id="myPage" data-spy="scroll" data-target=".navbar"
	data-offset="60">

	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header" style="float:left">

			<a class="navbar-brand" href="${pageContext.request.contextPath}/pages/RaiseConcern.jsp">Green Guardian</a>
		</div>

		<div class="navbar-header" style="float:right">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/pages/login.jsp">login</a>
		</div>
		
		
	</div>
	</nav>
	
	
	


<br>
<br>

<br>

<div align="center">
<form action="${pageContext.request.contextPath}/logincontroller" method="POST">

<div class="form-group">
  <label for="usr">UserName:</label>
  <div class="input-group">
  <input type="text" class="form-control" name="username" required="required">
  </div>
</div>
<div class="form-group">
  <label for="pwd">Password:</label>
  <div class="input-group">
  <input type="password" class="form-control" name="password" required="required">
  </div>
</div>


	<input type="hidden" value="login" name="action"/>
<div class="input-group-btn">		
<input type="submit" class="btn btn-danger" value="login"
				/>
</div>
</form>
</div>


	<%-- <form action="${pageContext.request.contextPath}/logincontroller" method="POST">
	
		Enter Username: <input type="text" name="username"/>
		
		Enter password: <input type="password" name="password"/>
		
		<input type="hidden" value="login" name="action"/>
		
		<input type="submit" value="login"></input>
		
	</form> --%>
	
	<%-- <c:if test="${requestScope.invalidLogin}">
		<h1>Invalid Login</h1>
	</c:if>
	 --%>

</body>
</html>