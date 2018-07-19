/////////////////////////////////////////////////////////////////////////////
//  Student.java - File send OTP on Registered email id of student         //
//  version 2.0  (Date - 03/25/2018)                                       //
//  Language:    Java                                                      //
//  Platform:    Windows 10 Pro                                            //
//  Application: Shuttle U Home CSE686 - Internet Programming              //
//  Author:      Nitish Kumar, Syracuse University                         //
/////////////////////////////////////////////////////////////////////////////
/*
 *   Purpose
 *   ------------------
 *   Uses  Java mail API (Using gmail SMTP) to send OTP on registered email id of student for authentication while login.
 *   OTP is 6 digit number calculated randomly using random.math function.
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

import dao.StudentDAO;


public class EmailOTP {
	public void createotp(String TOemail)  {              // this method receive email argument from student controller.Java 
		final String username = "YOUR EMAIL HERE"; // email address of SUshuttle through which otp is to be sent.
		final String password = "YOUR PASSWORD HERE";             // password of SUshuttle
        String otp="";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");  
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");  // smtp protocol is used
		props.put("mail.smtp.port", "587");              // port number used is 587

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(username, password);    // username & password is verified through google mail API.
		    }
		});

		try { 
			double a = Math.random();  // A random number is generated
			int c = (int) (a*1000000); // Type casted to int to form a 6 digit number
			otp=Integer.toString(c);   // otp is finally created and changed to string
			System.out.println(otp);
			
			
			Message message = new MimeMessage(session);    // object of message is created
 message.setFrom(new InternetAddress("shuttleuhomesu@gmail.com"));//the authenticated email address through which otp to be sent
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(TOemail)); // The to email address to which otp is to bes sent
			message.setSubject("Shuttle-U-Home Secure Password"); // subject of email address.
			message.setText("Dear Student,"
				+ "\n\n Your OTP to login is : "+otp); // Main message to containing the OTP

			Transport.send(message); // Finally the drafted message is to be sent through the send method of transport

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e); // any exception which occurs throgh the process is handled here 
		}

	
		StudentDAO d= new StudentDAO();
		d.insertOTP(otp,TOemail);// now calling the  insertOTP method of StudentDAO to insert the otp in database for authentication.
		 
	   }
	
//	public void createotp(String TOemail) {
//		StudentDAO d= new StudentDAO();
//		d.insertOTP("1",TOemail);
//	}
	
}
	