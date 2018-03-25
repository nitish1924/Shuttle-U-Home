package dao;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailDemo {
	public static void main(String[] args)  {  
		final String username = "shuttleuhomesu@gmail.com";
		final String password = "rewatiger";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(username, password);
		    }
		});

		try { 
			double a = Math.random();
			int c = (int) (a*1000000);
			System.out.println(c);
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("shuttleuhomesu@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("sshukl04@syr.edu"));
			message.setSubject("Shuttle-U-Home Secure Password");
			message.setText("Dear Student,"
				+ "\n\n Your OTP to login is : "+c);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	
		 
	   }
}
	