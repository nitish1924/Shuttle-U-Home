/////////////////////////////////////////////////////////////////////////////
//  FormValidation.js- For form field validation                           //
//  version 3.0  (Date - 04/16/2018)                                       //
//  Language:    Javascript                                                //
//  Platform:    Windows 10 Pro                                            //
//  Application: Shuttle U Home CSE686 - Internet Programming              //
//  Author:      Nitish Kumar/Shweta Shukla, Syracuse University           //
/////////////////////////////////////////////////////////////////////////////
/*
 *   Purpose
 *   ------------------
 *   This javascript file performs the form validation for wrong or empty fields.
 *   This file prevents Jsp to send wrong or inavlid fields in DB
 *   in case of any error alert function is used to notify user
 */

function Validations()
{
	// All fields are mandatory for student registartion
	if (document.getElementById("studentName").value == ''
		|| document.getElementById("studentName").value == null
		|| document.getElementById("eid").value == ''
		|| document.getElementById("eid").value == null
		|| document.getElementById("pwd").value == ''
		|| document.getElementById("pwd").value == null
		|| document.getElementById("cpwd").value == ''
		|| document.getElementById("cpwd").value == null
		|| document.getElementById("add").value == ''
		|| document.getElementById("add").value == null
		|| document.getElementById("phone").value == ''
		|| document.getElementById("phone").value == null)
	{
	alert("All fields are mandatory!!!");
	return false;
	}
	//gender
	var g=document.getElementById("Male").checked||document.getElementById("Female").checked;
	if(g==0)
		{
			alert("Please Select Gender");
			return false;
		}
	
	
	
	//Email Id should have @ and . 
	
	var email=document.getElementById("eid").value;
	var etest=/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
	if(etest.test(email)==false)
	{
		alert("Not a valid email id....please enter a valid email id");
		return false;
	}
	
	
	
	//Password should contain atleast one number from a-z
	 re = /[a-z]/;
	 var pwd=document.getElementById("pwd").value;
     if(!re.test(pwd))
     {
       alert("Error: password must contain at least one lowercase letter (a-z)!");
       return false;
     }
	//Password should contain atleast one number from 0-9
	re = /[0-9]/;
	var pwd=document.getElementById("pwd").value;
    if(!re.test(pwd)) 
    {
      alert("Error: password must contain at least one number (0-9)!");
      return false;
    }
    
    //Password should contain atleast 6 characters
    var pwd=document.getElementById("pwd").value;
	var cpwd=document.getElementById("cpwd").value;
	 if(pwd != "" && pwd == cpwd) 
	 {
	      if(pwd.length < 6) 
	      {
	        alert("Error: Password must contain at least six characters!");
	        return false;
	      }
	 }  
    
	//Password and ConfirmPassWord should match
	var pwd=document.getElementById("pwd").value;
	var cpwd=document.getElementById("cpwd").value;
	if(pwd!=cpwd)
		{
			alert("Passwords are not matching");
			return false;
		}
	
	
	
	
	// Only 10 no's are allowed in mobile no
	var m=document.getElementById("phone").value;
	if (m.length == 0)
	{
		alert("Please enter Mobile no");
		return false;
	}
	var mobileno=document.getElementById("phone").value;
	var no=/[0-9]/;                   // only numbers are allowed in phone number                     
	if(no.test(mobileno)==false)
		{
			alert("Only numbers are allowed in Phone no");
			return false;
		}
	var m=document.getElementById("phone").value;
	if (m.length != 10) {                  // phone number should have 10 digit
		alert("Please enter 10 digits phone number");
		return false;
	}

}
function Validate()    // login form validation
 {
	 if ( document.getElementById("seid").value == ''
			|| document.getElementById("seid").value == null
			|| document.getElementById("spwd").value == ''
			|| document.getElementById("spwd").value == null)
		{
		alert("All fields are mandatory!!!");
		return false;
		}
		//checking if identity either student or employee is checked
		var z=document.getElementById("Student").checked||document.getElementById("Employee").checked;
		if(z==0)
			{
				alert("Please Select Identity");
				return false;
			}
 }
function otpValidate(){ // validating that otp field should not be empty
	 if ( document.getElementById("otp").value == ''
			|| document.getElementById("otp").value == null
			)
		{
		alert("Please enter OTP!!!");
		return false;
		}
	
}

function bookValidate(){ // in booking form address cannot be empty
	if ( document.getElementById("address").value == ''
		|| document.getElementById("address").value == null
		)
	{
	alert("Address cannot be empty!!!");
	return false;
	}
}

function emailValidate(){ // email id on forget password screen cannot be empty
	if ( document.getElementById("eid").value == ''
		|| document.getElementById("eid").value == null
		)
	{
	alert("Email cannot be empty!!!");
	return false;
	}
	// correct email format is checked
	var email=document.getElementById("eid").value;
	var etest=/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
	if(etest.test(email)==false)
	{
		alert("Not a valid email id....please enter a valid email id");
		return false;
	}
	
}
function pwdValidations(){
	//Password should contain atleast one number from a-z
	 re = /[a-z]/;
	 var pwd=document.getElementById("pwd").value;
    if(!re.test(pwd))
    {
      alert("Error: password must contain at least one lowercase letter (a-z)!");
      return false;
    }
	//Password should contain atleast one number from 0-9
	re = /[0-9]/;
	var pwd=document.getElementById("pwd").value;
    if(!re.test(pwd)) 
    {
      alert("Error: password must contain at least one number (0-9)!");
      return false;
    }
    
    //Password should contain atleast 6 characters
    var pwd=document.getElementById("pwd").value;
	var cpwd=document.getElementById("cpwd").value;
	 if(pwd != "" && pwd == cpwd) 
	 {
	      if(pwd.length < 6) 
	      {
	        alert("Error: Password must contain at least six characters!");
	        return false;
	      }
	 }  
    
	//Password and ConfirmPassWord should match
	var pwd=document.getElementById("pwd").value;
	var cpwd=document.getElementById("cpwd").value;
	if(pwd!=cpwd)
		{
			alert("Passwords are not matching");
			return false;
		}
	
	
}
function displayLink(){
// displaying the registartion link on login form only when student identity is checked.
	if(document.getElementById("Student").checked == 1)
	{
		document.getElementById("reg").style.display = "block";
	}
	else if(document.getElementById("Employee").checked == 1)
	{
		document.getElementById("reg").style.display = "none";
	}
	}