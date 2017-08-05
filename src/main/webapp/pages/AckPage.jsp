
<jsp:directive.include file="header.jspf" />
<div class="jumbotron text-center">
	<h1>Hello Citizen</h1>
	<p>Your ${requestScope.type} has been assigned with request number ${requestScope.reqNo}
		The concerned authority is as follows.<br>
	</p>
	
	<h4>Type: ${requestScope.authority.type}</h4>
	
	
	<h4>Location: ${requestScope.authority.location}</h4>
	
	</div>

</body>
</html>