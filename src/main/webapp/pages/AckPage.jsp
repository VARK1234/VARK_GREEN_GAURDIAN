
<jsp:directive.include file="header.jspf" />

<body id="myPage" data-spy="scroll" data-target=".navbar"
	data-offset="60">

	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">

			<a class="navbar-brand" href="${pageContext.request.contextPath}/pages/RaiseConcern.jsp">Green Guardian</a>
		</div>
	</div>
	</nav>


<div class="jumbotron text-center">
	<h1>Hello Citizen</h1>
	<p>Your ${requestScope.evt.eventType} has been logged with request number ${requestScope.evt.id} and has 
	been assigned to the concerned ${requestScope.authority.type} authority of ${requestScope.authority.location.city}<br>
	</p>
	</div>

</body>
</html>