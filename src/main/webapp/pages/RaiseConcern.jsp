
<jsp:directive.include file="header.jspf" />
<body id="myPage" data-spy="scroll" data-target=".navbar"
	data-offset="60" onload="init()">

	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">

			<a class="navbar-brand" href="${pageContext.request.contextPath}/pages/RaiseConcern.jsp">Green Guardian</a>
		</div>
		<div class="navbar-header" style="float:right">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/pages/login.jsp">login</a>
		</div>
	</div>
	</nav>
	
	
	
	
<div class="jumbotron text-center">
	<h1>Hello Citizen</h1>
	<p>Please state your threat/concern</p>
	<form action="${pageContext.request.contextPath}/flowcontroller" method="POST">

		<table class="table">
			<div class="input-group">
				<tr>
					<input type="text" class="form-control" size="50"
						placeholder="Your Concern" name="desc" required />
				</tr>
			</div>
			<tr>
				<td>
					<div class="radio">
						<label><input type="radio" name="type" value="threat">Threat</label>
					</div>
				</td>
				<td>
					<div class="radio">
						<label><input type="radio" name="type" value="concern">Concern</label>
					</div>
				</td>
			</tr>

			
			<input type="hidden" value="" name="lat" id="lat"/>
			<input type="hidden" value="" name="lng" id="lng"/>
			


		</table>
		<div class="input-group-btn">
			<input type="submit" class="btn btn-danger" value="raiseconcern"
				name="action" />
		</div>





		<!-- Add Maps here  -->





	</form>
</div>











<!-- Container (About Section) -->
<div id="about" class="container-fluid bg-grey">
	<div class="text-center">
			<h2 class="text-center">Green Guardian</h2>
			<h4>
				Green Guardian is an effort to help the concerned citizen to raise
				it's voice and help the world be green and beautiful <br />Our app
				helps you to send your concern/threat to the nearest concerned
				authority as soon as you report it to have appropriate action be
				taken on it.
			</h4>
			<!-- <br><button class="btn btn-default btn-lg">Get in Touch</button>-->
		
	</div>
</div>

<!--   
	  <h2>What our customers say</h2>
	  <div id="myCarousel" class="carousel slide text-center" data-ride="carousel">
	     Indicators 
	    <ol class="carousel-indicators">
	      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	      <li data-target="#myCarousel" data-slide-to="1"></li>
	      <li data-target="#myCarousel" data-slide-to="2"></li>
	    </ol>
	
	    Wrapper for slides
	    <div class="carousel-inner" role="listbox">
	      <div class="item active">
	        <h4>"This company is the best. I am so happy with the result!"<br><span>Michael Roe, Vice President, Comment Box</span></h4>
	      </div>
	      <div class="item">
	        <h4>"One word... WOW!!"<br><span>John Doe, Salesman, Rep Inc</span></h4>
	      </div>
	      <div class="item">
	        <h4>"Could I... BE any more happy with this company?"<br><span>Chandler Bing, Actor, FriendsAlot</span></h4>
	      </div>
	    </div>
	
	    Left and right controls 
	    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
	      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	      <span class="sr-only">Previous</span>
	    </a>
	    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
	      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	      <span class="sr-only">Next</span>
	    </a>
	  </div>
	</div>
	-->


<!-- Container (Contact Section) -->
<div id="contact" class="container-fluid bg-grey">
	<h2 class="text-center">CONTACT</h2>
	<div class="row">
		<div class="col-sm-5">
			<p>Contact us and we'll get back to you as soon as possible.</p>
			<p>
				<span class="glyphicon glyphicon-map-marker"></span> HQ Pune,
				Maharashtra, India
			</p>
			<p>
				<span class="glyphicon glyphicon-phone"></span> +91 89378888888
			</p>
			<p>
				<span class="glyphicon glyphicon-envelope"></span>
				vark123@infosys.com
			</p>
		</div>

		<!-- Add Google Maps -->
		<div id="googleMap" style="height: 400px; width: 100%;"></div>
		<script type="text/javascript">
			function myMap() {
				var myCenter = new google.maps.LatLng(41.878114, -87.629798);
				var mapProp = {
					center : myCenter,
					zoom : 12,
					scrollwheel : true,
					draggable : true,
					mapTypeId : google.maps.MapTypeId.ROADMAP
				};
				var map = new google.maps.Map(document
						.getElementById("googleMap"), mapProp);
				var marker = new google.maps.Marker({
					position : myCenter
				});
				marker.setMap(map);
			}
		</script>
		

		

		<script type="text/javascript">
			$(document).ready(
					function() {
						// Add smooth scrolling to all links in navbar + footer link
						$(".navbar a, footer a[href='#myPage']").on('click',
								function(event) {
									// Make sure this.hash has a value before overriding default behavior
									if (this.hash !== "") {
										// Prevent default anchor click behavior
										event.preventDefault();

										// Store hash
										var hash = this.hash;

										// Using jQuery's animate() method to add smooth page scroll
										// The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
										$('html, body').animate({
											scrollTop : $(hash).offset().top
										}, 900, function() {

											// Add hash (#) to URL when done scrolling (default click behavior)
											window.location.hash = hash;
										});
									} // End if
								});

						$(window).scroll(function() {
							$(".slideanim").each(function() {
								var pos = $(this).offset().top;

								var winTop = $(window).scrollTop();
								if (pos < winTop + 600) {
									$(this).addClass("slide");
								}
							});
						});
					})
					
					
					
		</script>

<script>
function init(){

if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(function(position) {
            var pos = {
              lat: position.coords.latitude,
              lng: position.coords.longitude
            };
            document.getElementById("lat").value=pos.lat;
            document.getElementById("lng").value=pos.lng;
          }, function() {
            handleLocationError(true, infoWindow, map.getCenter());
          });
        } else {
		alert("In else");
          // Browser doesn't support Geolocation
          handleLocationError(false, infoWindow, map.getCenter());
        }
		

}
</script>

	</div>
</div>
</body>
</html>
