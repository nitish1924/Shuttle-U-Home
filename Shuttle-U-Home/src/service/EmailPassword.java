/////////////////////////////////////////////////////////////////////////////
//  Student.java - Forgot password on Registered email id of student       //
//  version 2.0  (Date - 04/04/2018)                                       //
//  Language:    Java                                                      //
//  Platform:    Windows 10 Pro                                            //
//  Application: Shuttle U Home CSE686 - Internet Programming              //
//  Author:      Nitish Kumar, Syracuse University                         //
/////////////////////////////////////////////////////////////////////////////
/*
 *   Purpose
 *   ------------------
 *   Uses  Java mail API (Using gmail SMTP) to send password on registered email id of student when they select forgot password option
 *   OTP is 6 digit number calculated randomly using random.math() function.
 *   
 */


package service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailPassword {
	public void sendPassword(String TOemail,String spassword)  {  // this method receive email argument from student controller.Java
		final String username = "shuttleuhomesu@gmail.com";// email address of SUshuttle through which otp is to be sent.
		final String password = "shuttleuhome";      // password of SUshuttle
		Properties props = new Properties();       
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com"); // smtp protocol is used
		props.put("mail.smtp.port", "587");  // port number used is 587

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(username, password);  // username & password is verified through google mail API
		    }
		});

		try { 
			Message message = new MimeMessage(session); // object of message is created
  message.setFrom(new InternetAddress("shuttleuhomesu@gmail.com")); //the authenticated email address through which password to be sent
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(TOemail)); // The to email address to which password is to bes sent
			message.setSubject("Shuttle-U-Home Forgot Password"); // subject of email address.
			message.setText("Dear Student,"
				+ "\n\n Your password is : "+spassword); // Main message to containing the password

			Transport.send(message); // Finally the drafted message is to be sent through the send method of transport

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);   // any exception which occurs throgh the process is handled here 
		}

	
	   }
}
