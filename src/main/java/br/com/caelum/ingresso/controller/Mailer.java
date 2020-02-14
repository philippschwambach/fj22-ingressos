package br.com.caelum.ingresso.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import br.com.caelum.ingresso.mail.Email;

@Component
public class Mailer {
	
	@Autowired
	private JavaMailSender sender;
	
	private final String from = "Ingresso<cursofj22@gmail.com>";
	
	public void send(Email email) {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message);
		try {
			messageHelper.setFrom(from);
			messageHelper.setTo(email.getTo());
			messageHelper.setSubject(email.getSubject());
			messageHelper.setText(email.getBody(), true);
			
			sender.send(message);
			
		} catch (MessagingException e) {
			throw new IllegalArgumentException(e);
		
		}
	}
}