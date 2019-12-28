<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
<!-- Bootstrap 3.3.5 -->
<!-- Font Awesome -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">        
<meta charset="ISO-8859-1">
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<!-- <script type="text/javascript" src="webjars/jquery/3.2.0/jquery.min.js"></script> -->
<link rel="stylesheet" href="css/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="corejs/homepage.js"></script>
<!-- <script src="jquery-3.4.1.min.js"></script> -->
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"rel="stylesheet">
<title>AvailInfo</title>
</head>
<body >
        <!-- <div class="loader">Loading...</div> -->
        <!-- <div class="navbar-header">
                <a class="navbar-brand" href="index"><img
                    src="img/avail-info-icon.png"></a>
         </div> -->

         <div class="topnav">
                <div class="login-container">
                    <button class="singupbtn" type="submit" onclick="">Singn up</button>
                    <button class="loginbtn" type="submit" onclick="document.getElementById('modal').style.display='block'" style="width:auto;">Log in</button>

                </div>
              </div>

              <div id="modal" class="modal">
  
                        <form class="modal-content animate" action="/" method="post">
                          <div class="imgcontainer">
                            <span onclick="document.getElementById('modal').style.display='none'" class="close" title="Close Modal">&times;</span>
                            <img src="img/avail-info-icon.png" alt="Avatar" class="avatar">
                          </div>
                      
                          <div class="container">
                            <label class="username_label" for="uname"><b>Username</b></label>
                            <input type="text" placeholder="Enter Username" name="uname" required>
                            <br>
                            <label class="dob_label" for="psw"><b>Date of birth</b></label>
                            <input type="date" placeholder="Enter Password" name="psw" required>
                             <br> 
                             <label>
                              <input type="checkbox" checked="checked" name="remember"> Remember me
                            </label>
                            <br>
                            <button type="submit">Login</button>
                            <button type="button" onclick="document.getElementById('modal').style.display='none'" class="cancelbtn">Cancel</button>
                            <span class="psw">Forgot <a href="#">password?</a></span>
                          </div>  
                        </form>
                      </div>    


        <div class="body-container" style="overflow-y: auto;" >
          <div class="singnup_box">
                <label>Mobile Number</label>
                <br>
                <div class = singupbody>
                <input type="text" class="mobileno_inputbox" id="mobileno_inputbox" placeholder="Mobile number" maxlength="10">
                <br>
                <input type="text" class="otp_inputbox" id="otp_inputbox" placeholder="Enter OTP" maxlength="4">
                </div>
                <button  type="button" id="getotpbtn" disabled class="btn getotpbtn" onclick="getOTP()"> Send </button>
            </div>
        </div>
        <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body >
</html>