<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html long="en">
<head>
<!-- required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">

<!-- CSS link -->
<link rel="stylesheet" href="/Rental_Booking_System/URLRESOURCE/css/style.css">
<title>Rental-Parking App</title>
<style>
.selector-for-some-widget {
	box-sizing: content-box;
}
</style>
<style>
.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	background-color: black;
	text-align: center;
	height: 5%;
	font-size: 14px;
}
</style>
<script>
function enableSubmit(){
	console.log("enableSubmit() logged-in");
let inputs = document.getElementsByClassName('required'); // Enter your class name for a required field, this should also be reflected within your form fields.
let btn = document.querySelector('button[type="submit"]');
let isValid = true;
console.log("inputs.length: "+inputs.length);
for (var i = 0; i < inputs.length; i++){
let input = inputs[i];
console.log("input.value:"+input.value);
if (input.value.trim() === "" || input.value === null){
isValid = false;
break;
}
}
btn.disabled = !isValid;
console.log("btn.disabled: "+btn.disabled);
}
</script>
<script>
	function vehicleNoAjax() {
		console.log("vehicleNoAjax logged-in");
		var vehicleNo = document.getElementById("vehicleNo").value;
		var url = "http://localhost:8080/Rental_Booking_System/validateVehicleNo/"
				+ vehicleNo;
		//	console.log(url);
		const xmlHttp = new XMLHttpRequest();
		xmlHttp.open("GET", url);
		xmlHttp.send();
		xmlHttp.onload = function() {
			console.log(this.responseText);
			document.getElementById('display').innerHTML = this.responseText;
		}
	}
</script>
<script>
	function ajaxWithObj() {
		console.log("ajaxWithObj logged-in");
		var location = document.getElementById("location").value;
		var vehicleType = document.getElementById("vehicleType").value;
		var engineType = document.getElementById("engineType").value;
		var classification = document.getElementById("classification").value;
		var term = document.getElementById("term").value;

		var url = "http://localhost:8080/Rental_Booking_System/getPriceAndDiscount/"
				+ location
				+ "/"
				+ vehicleType
				+ "/"
				+ engineType
				+ "/"
				+ classification + "/" + term;
	//	console.log(url);
		const xmlHttp = new XMLHttpRequest();
		xmlHttp.open("GET", url);
		xmlHttp.send();
		xmlHttp.onload = function() {

			console.log(this.responseText);
			var obj = JSON.parse(this.responseText);
	//		console.log(obj.price);
	//		console.log(obj.discount);
			document.getElementById("price").value = obj.price;
			document.getElementById("discount").value = obj.discount;
			var totalAmount = obj.price - ((obj.price * obj.discount) / 100);
			document.getElementById("totalAmount").value = totalAmount;
		}
	}
</script>
<script>
function updateDatails() {
console.log("updateDatails logged-in");
document.getElementById("vehicleNo").value="${upDto.vehicleNo}";
document.getElementById("location").value="${upDto.location}";
document.getElementById("vehicleType").value="${upDto.vehicleType}";
document.getElementById("engineType").value="${upDto.engineType}";
document.getElementById("classification").value="${upDto.classification}";
document.getElementById("term").value="${upDto.term}";
document.getElementById("price").value="${upDto.price}"; 
document.getElementById("discount").value="${upDto.discount}"; 
document.getElementById("totalAmount").value="${upDto.totalAmount}"; 
}
</script>
</head>
<body style="background-color: white;margin-bottom: 10%;margin-top: 15%" onload="updateDatails();enableSubmit()">
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
	<nav class="navbar fixed-top navbar-dark bg-dark" style="height: 50px;">
		<div class="container-fluid">
			<div class="navbar-header">
				<img src="/Rental_Booking_System/URLRESOURCE/img/Parking Space.jpeg" class="w3-bar w3-border" width="85"
					height="40" style="margin-top: -20px">
			</div>
			<div class="w3-bar w3-border"
				style="margin-left: 780px; margin-top: -20px;">
				<a href="duePayment?email=${userDto.email}" class="btn btn-sm"
					style="background-color: turquoise;">Home</a>
			</div>
			<div class="navbar-left" class="w3-bar w3-border">
			<p class="navbar-text" style="color: white;font-size: 15px;">Welcome, ${userDto.name}</p>
			</div>
		</div>
	</nav>
<div class="wrapper rounded bg-white">
			<span style="color: green;">${success}</span>
			<span style="color: red;" id="display">${error}</span>
	
				<div class="card shadow" style="margin-top:auto;margin-bottom: auto;">
					<div class="card-title text-center border-bottom"
						style="background-color: turquoise;">
						<h3 class="p-2" style="font-size: 25px;">Slot Booking Form</h3>
					</div>
					<div class="card-body">
						<form action="parkingInfo" method="post" enctype="multipart/form-data" >
						
				<div class="row">
							<div class="col-md-6 mt-md-0 mt-3">
								<input type="text" id="vehicleNo" name="vehicleNo"
									placeholder="Enter vehicle No." class="form-control shadow" style="background-color: ghostwhite;" readonly/> 
							</div>						
				</div>
				<br/>
				<div class="row">
							<div class="col-md-6 mt-md-0 mt-3">
							<select name="location"
									id="location" class="form-select shadow required" onclick="enableSubmit()" onchange="ajaxWithObj()" aria-label="Default select example">
									<option value="">Location</option>
									<option value="RajajiNagar">RajajiNagar</option>
									<option value="E.city">E.city</option>
									<option value="VijayaNagar">VijayaNagar</option>
									<option value="BTM">BTM</option>
								</select>
							</div>		
					
					<div class="col-md-6 mt-md-0 mt-3">
							<select name="vehicleType" id="vehicleType" class="form-select shadow required" onclick="enableSubmit()" onchange="ajaxWithObj()" aria-label="Default select example">
										<option value="">Vehicle Type</option>
										<option value="2_Wheeler">2-wheeler</option>
										<option value="4_Wheeler">4-wheeler</option>
							</select>
					</div>																					
				</div>
				<br/>
				<div class="row">
						<div class="col-md-6 mt-md-0 mt-3">
							<select name="engineType" id="engineType" class="form-select shadow required" onclick="enableSubmit()" onchange="ajaxWithObj()" aria-label="Default select example">
										<option value="">Engine Type</option>
										<option value="Normal">Normal</option>
										<option value="Electrical">Electrical</option>
							</select>
						</div>
						<div class="col-md-6 mt-md-0 mt-3">
						<select name="classification" id="classification" class="form-select shadow required" onclick="enableSubmit()" onchange="ajaxWithObj()" aria-label="Default select example">
									<option value="">Classification</option>
									<optgroup label="Bike">
										<option value="Bike">Bike</option>
									</optgroup>
									<optgroup label="Cars">
										<option value="BMW">BMW</option>
										<option value="Renault">Renault</option>
										<option value="Skoda">Skoda</option>
										<option value="Kia">Kia</option>
										<option value="Toyata">Toyata</option>
									</optgroup>
								</select>
							</div>																			
				</div>
				<br/>
				<div class="row">
							<div class="col-md-6 mt-md-0 mt-3">
								<label for="term">Term:</label>
								<select name="term" id="term"
									onchange="ajaxWithObj()" class="form-select shadow required" onclick="enableSubmit()" aria-label="Default select example">
									<option value="">select</option>
									<option value="1_day">1 Day</option>
									<option value="7_days">7 Days</option>
									<option value="15_days">15 Days</option>
									<option value="30_days">30 Days</option>
									<option value="90_days">90 Days</option>
									<option value="180_days">180 Days</option>
									<option value="360_days">360 Days</option>
								</select>
							</div>
							
							<div class="col-md-6 mt-md-0 mt-3">
								<label for="price">Price:</label> 
								<input type="text" id="price" 
									name="price" class="form-control shadow" style="background-color: ghostwhite;" readonly/> 
							</div>
				</div>
				<br/>
				<div class="row">
							<div class="col-md-6 mt-md-0 mt-3">
								<label for="discount">Discount(%):</label> <input type="text"
									id="discount" name="discount" class="form-control shadow" style="background-color: ghostwhite;" readonly/>
							</div>
							<div class="col-md-6 mt-md-0 mt-3">
								<label for="totalAmount">Total Amount:</label>  
								<input type="text" id="totalAmount" name="totalAmount" class="form-control shadow" style="background-color: ghostwhite;" readonly/>
							</div>
				</div>
				<br/>
				<div class="row"> 
					<div class="col-md-3 mt-md-0 mt-3">
						<label for="file" style="font-size: 14px;">uploaded</label>
						<img src="showFile?fileName=${upDto.fileName}&contentType=${upDto.contentType}" width="60" height="50"></a>
					</div>				
					<div class="col-md-8 mt-md-0 mt-3">
						<label for="file">want to change?</label>
						<input type="file" name="file" id="file" class="form-control shadow" value="hello" style="background-color: ghostwhite;"> 
					</div>	
				</div>
				<br/>				
		<div class="row" style="margin-left: 25%;">
			<div class="col-md-12 mt-md-0 mt-10">
				<button type="submit" id="smtBtn" class="btn w-30 shadow" style="background-color: turquoise;color:black; text-align: center;" disabled>
						Update
						</button>&ensp;&ensp;&ensp;
						<button type="Reset" class="btn w-30 shadow" style="background-color: turquoise;color:black;;text-align: center;">
						Reset
						</button>	
			</div>
	</div>
					</form>
					</div>
				</div>
			</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	<div class="footer">
		<small style="color:white;">&copy; Created by: Priyanka B S,</small><small style="color:white;">&ensp;bspriya9912@gmail.com</small>&ensp;|<small style="color:lightgreen;">&ensp;Last login time: ${userDto.updatedDate}</small>
	</div>
</body>
</html>