
<jsp:directive.include file="header.jspf" />

<body id="myPage" data-spy="scroll" data-target=".navbar"
	data-offset="60" onload="toggleButtonState()">

	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">

				<a class="navbar-brand" href="#">Green Guardian</a>
			</div>
			<div class="navbar-header" style="float: right">
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/logincontroller?action=logout&method=post">Logout</a>
			</div>
		</div>
	</nav>


	<div class="jumbotron text-center">
		<h1>Welcome ${sessionScope.username}</h1>

		<h3>
			Below are the items that get your attention:<br>
		</h3>


	</div>


	<c:forEach var="item" items="${sessionScope.events }">
	
	
				<div id="pricing" class="container-fluid" >
					<div class="panel-heading">
						<h1>Event Id : ${item.id }</h1>
					</div>
					<div class="panel-body">
						<p>
							<strong>Desc: </strong>${item.description}</p>
						<hr />
						<p>
							<strong>Status: </strong> ${item.status }
						</p>
						<hr />
						<p>
							<strong>LoggedOn: </strong> ${item.time }
						</p>
						<hr />
						<p>
							<strong>EventType: </strong> ${item.eventType }
						</p>
						<hr/>
						<button class="btn btn-info btn-lg" onclick="myMap(${item.latitude}, ${item.longitude})">Show on Map</button>
						
						<form action="${pageContext.request.contextPath}/statuscontroller" method="post">
						
						
						<input type="submit" class="btn btn-info btn-lg" name="action" id="ACKNOWLEDGE"  value="ACKNOWLEDGE" />
						
						<input type="submit" class="btn btn-info btn-lg" name="action" id="DECLINE" value="DECLINE"/>
						
						<input type="submit" class="btn btn-info btn-lg" name="action" id="COMPLETE" value="COMPLETE"  />
						
						
						
						<input type="hidden" value="${item.id }" name="eventid"/>
						
						
						</form>
						
						
						
						<hr/>

					</div>
				</div>
	
				<div id="googleMap" style="height: 300px; width:50%"></div> 
				</div> 


	

	</c:forEach>
<script>
	function myMap(lat,lng) {
var myCenter = new google.maps.LatLng(lat, lng);
	var mapProp = {center:myCenter, zoom:12, scrollwheel:true, draggable:true, mapTypeId:google.maps.MapTypeId.ROADMAP};
	var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
	var marker = new google.maps.Marker({position:myCenter});
	marker.setMap(map);
	}
	
	
</script> <script
					src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA8XqAhxBghVIugE3TqNfHkBzPdYY6D6vM&callback=myMap"></script>




</body>
</html>