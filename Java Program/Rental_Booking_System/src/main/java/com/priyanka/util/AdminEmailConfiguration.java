package com.priyanka.util;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.priyanka.entity.AdminEntity;

@Configuration
public class AdminEmailConfiguration {
	
	
	
	 @Bean
	    public JavaMailSender getJavaMailSender() {
	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        mailSender.setHost("smtp.gmail.com"); // Replace with your SMTP host
	        mailSender.setPort(587); // Replace with your SMTP port

	        mailSender.setUsername("bspriya9912@gmail.com");
	        mailSender.setPassword("ywli uioz nxou tucr");

	        Properties props = mailSender.getJavaMailProperties();
	        props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.debug", "true");

	        return mailSender;
	       
	    }
	 
	
//	private String host;
//	private String user;
//	private String pswd;
//	private String to;
//	private int port;
//	
//	
//	public boolean sendMail(AdminEntity adminEntity) {
//		 host = "smtp.gmail.com";
//		 user = "bspriya9912@gmail.com";
//		 pswd = "ywli uioz nxou tucr";
//		 to = adminEntity.getAdminEmail();
//		 port=587;
//
//		Properties props = new Properties();
//		props.put("mail.smtp.host", host);
//		props.put("mail.smtp.port", port);
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.debug", "true");
//		props.put("mail.transport.protocal", "smtp");
//
//		Session session = Session.getDefaultInstance(props, new Authenticator() {
//			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
//				return new javax.mail.PasswordAuthentication(user, pswd);
//			}
//		});
//
//		try {
//			MimeMessage msg = new MimeMessage(session);
//			msg.setFrom(new InternetAddress(user));
//			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
//		//	msg.setReplyTo(new InternetAddress[] {new InternetAddress("Savitri.Kandgal@outlook.com"), new InternetAddress(to)});
//			msg.setSubject("Login confirmation mail");
//			msg.setContent("<H3>Hello " + adminEntity.getName() + ",</H3>"
//					+ "You have logged in successfully!"
//					+ "<br/> "
//					+ "<br/> "
//					+ "<br/> "
//					+ "<b>Thanks & Regards</b>,<br/>"
//					+ "X-workz", "text/html");
//			Transport.send(msg);
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//		return true;
//	}
		
}
