
<jsp:directive.include file="header.jspf" />

<body id="myPage" data-spy="scroll" data-target=".navbar"
	data-offset="60">

	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">

			<a class="navbar-brand" href="#">Green Guardian</a>
		</div>
		<div class="navbar-header" style="float:right">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/logincontroller?action=logout&method=post">Logout</a>
		</div>
	</div>
	</nav>


<div class="jumbotron text-center">
	<h1>Welcome ${sessionScope.username}</h1>
	<p>Below are the items that get your attention:<br>
	</p>
	
	
	
	
	</div>


	<h1>You have logged in successfully</h1>
</body>
</html>