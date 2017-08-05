<jsp:directive.include
	file="header.jspf" />

	<%-- <c:if test="${sessionScope.isLoggedOn!=null}">
		<c:redirect url="${pageContext.request.contextPath}/flowcontroller"></c:redirect>
	</c:if> --%>


<br>
<br>

<br>

<div align="center">
<form action="${pageContext.request.contextPath}/logincontroller" method="POST">

<div class="form-group">
  <label for="usr">UserName:</label>
  <div class="input-group">
  <input type="text" class="form-control" name="username">
  </div>
</div>
<div class="form-group">
  <label for="pwd">Password:</label>
  <div class="input-group">
  <input type="password" class="form-control" name="password">
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