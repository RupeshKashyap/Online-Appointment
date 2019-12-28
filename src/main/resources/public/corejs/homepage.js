
 var baseurl ="http://localhost:8082/availinfo/"

 jQuery(document).ready(function(event) {
    $('#mobileno_inputbox').keyup(function () { 
        console.log("calling ")
        this.value = this.value.replace(/[^1-9\.]/g,'');
        let number = this.value;
        console.log(number.length);
        console.log(number.length>=10);
        if(number.length>=10){
            document.getElementById("getotpbtn").disabled=false;
        }
        else{
            document.getElementById("getotpbtn").disabled=true;
        }
    });


    $('#otp_inputbox').keyup(function(){
        this.value = this.value.replace(/[^0-9\.]/g,'');
        let otp = this.value;
        console.log("otp validating")
        if(otp.length>=4){
            verifyOTP(otp);
        }
    })
});

function verifyOTP(otp) {

    let mobileNumber = document.getElementById("mobileno_inputbox").value;
    let arr = {"mobileNumber":mobileNumber,
    "otp":otp};
    console.log(arr);
    
   let  xhttp = new XMLHttpRequest();
   xhttp.onreadystatechange = function(){
       if(this.readyState == 4 && this.status == 200){
        console.log(xhttp.responseText);
       }
   }
   xhttp.open("POST", baseurl+"/otpverify", true);
   console.log("OTP ",otp);
   xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
   xhttp.send(JSON.stringify(arr));
//    xhttp.send(otp);

}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
// add otp input box
function getOTP() {
    // searchjson = {};
    // var addotpbox = "<br><input type='text' class='otpbox' placeholder='verify OTP' required>";

    var mNumber = document.getElementById("mobileno_inputbox").value;
    // searchjson.mNumber=mNumber;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
          if (this.readyState == 4 && this.status == 200) {
           console.log("otp gerated");  
           console.log(xhttp.status);
           console.log(xhttp.responseText);
        //    $(".mobileno_inputbox").after(addotpbox);
          }
        };
        xhttp.open("POST", baseurl+"/getotp", true);
        console.log("mNumber",mNumber);
        xhttp.send(mNumber);
    }
