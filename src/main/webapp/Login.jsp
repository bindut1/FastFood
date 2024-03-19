<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<link href="css/login.css" rel="stylesheet" type="text/css" />
<title>Login Form</title>
</head>
<body>
	<jsp:include page="Menu.jsp"></jsp:include>

	<div id="logreg-forms">
		<c:if test="${error!=null }">
			<div class="alert alert-danger" role="alert">${error}</div>
		</c:if>
		<c:if test="${mess!=null }">
			<div class="alert alert-success" role="alert">${mess}</div>
		</c:if>
		<form class="form-signin" action="login" method="post">
			<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">
				Sign in</h1>
			<h2 style="color: red"><%=request.getAttribute("msgregister") != null ? request.getAttribute("msgregister") : " "%></h2>
			<input name="user" type="text" id="inputEmail" class="form-control"
				placeholder="Username" required="" autofocus=""> <input
				name="pass" type="password" id="inputPassword" class="form-control"
				placeholder="Password" required="">

			<div class="form-group form-check">
				<input name="remember" value="1" type="checkbox"
					class="form-check-input" id="exampleCheck1"> <label
					class="form-check-label" for="exampleCheck1">Remember me</label>
			</div>

			<button class="btn btn-success btn-block" type="submit">
				<i class="fas fa-sign-in-alt"></i> Sign in
			</button>
			<hr>
			<button class="btn btn-primary btn-block" type="button"
				id="btn-signup">
				<i class="fas fa-user-plus"></i> Sign up New Account
			</button>
		</form>

		<form action="signup" method="post" class="form-signup" onsubmit="Signup(event)">
			<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">
				Sign up</h1>
			<input name="user" type="text" id="user-name" class="form-control"
				placeholder="Username" required="" autofocus=""> <input
				name="pass" type="password" id="user-pass" class="form-control"
				placeholder="Password" required autofocus="">
			<p id="invalidrepass"></p>
			<input name="repass" type="password" id="user-repeatpass"
				onkeyup="Signup()" class="form-control"
				placeholder="Repeat Password" required autofocus=""> <input
				name="fullname" type="text" id="user-fullname" class="form-control"
				placeholder="Full Name" required="" autofocus=""> <input
				name="email" type="email" id="email" class="form-control"
				placeholder="Email" required="" autofocus=""> <input
				name="address" type="text" id="address" class="form-control"
				placeholder="Address" required="" autofocus=""> <input
				name="phonenumber" type="text" id="phonenumber" class="form-control"
				placeholder="Phone Number" required="" autofocus="">
			<button class="btn btn-primary btn-block" type="submit">
				<i class="fas fa-user-plus"></i> Sign Up
			</button>

			<a href="#" id="cancel_signup"><i class="fas fa-angle-left"></i>
				Back</a>
		</form>
		<br>

	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script>
	function Signup(event) {
	    var pass = document.getElementById("user-pass").value;
	    var repass = document.getElementById("user-repeatpass").value;
	    var invalidRepass = document.getElementById("invalidrepass");
	    
	    if (repass !== pass) {
	        invalidRepass.innerHTML = "Passwords do not match. Please enter again!";
	        event.preventDefault(); 
	    } else {
	        invalidRepass.innerHTML = "";
	    }
	}
	
            function toggleResetPswd(e) {
                e.preventDefault();
                $('#logreg-forms .form-signin').toggle() // display:block or none
                $('#logreg-forms .form-reset').toggle() // display:block or none
            }

            function toggleSignUp(e) {
                e.preventDefault();
                $('#logreg-forms .form-signin').toggle(); // display:block or none
                $('#logreg-forms .form-signup').toggle(); // display:block or none
            }

            $(() => {
                // Login Register Form
                $('#logreg-forms #forgot_pswd').click(toggleResetPswd);
                $('#logreg-forms #cancel_reset').click(toggleResetPswd);
                $('#logreg-forms #btn-signup').click(toggleSignUp);
                $('#logreg-forms #cancel_signup').click(toggleSignUp);
            })
            
            window.addEventListener("load",function loadAmountCart(){
                        	 $.ajax({
                                 url: "/WebsiteThoiTrang/loadAllAmountCart",
                                 type: "get", //send it through get method
                                 data: {
                                     
                                 },
                                 success: function (responseData) {
                                     document.getElementById("amountCart").innerHTML = responseData;
                                 }
                             });
                        },false);       
        </script>
</body>
</html>