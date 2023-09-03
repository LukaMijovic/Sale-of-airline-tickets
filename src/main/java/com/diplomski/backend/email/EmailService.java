package com.diplomski.backend.email;

import com.diplomski.backend.domain.Ticket;
import com.diplomski.backend.pdf.GeneratorPDF;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

@Service
@RequiredArgsConstructor
public class EmailService {
    @Autowired
    private final JavaMailSender javaMailSender;

    @Async
    public void sendRegisterEmail(String toEmail, String subject, String message){
        SimpleMailMessage mailMessage= new SimpleMailMessage();
        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setFrom("springbootdiplomski@gmail.com");
        javaMailSender.send(mailMessage);
        System.out.println(1);
    }
    @Async
    public void sendTicket(String toEmail, Ticket ticket) throws MalformedURLException, FileNotFoundException {
        MimeMessage message=javaMailSender.createMimeMessage();
        try{
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            helper.setTo(toEmail);
            helper.setFrom("springbootdiplomski@gmail.com");
            helper.setSubject("Air Sales Application | Ticket Buying Notification");
            helper.setText("Hi, "+ticket.getBooking().getCustomer().getFirstName()+" there is your ticket in pdf format.\nWe wish you a nice trip!");

            GeneratorPDF generatorPDF=new GeneratorPDF(ticket);
            generatorPDF.createTicketPdf();
            ClassPathResource pdf=new ClassPathResource("tickets/"+generatorPDF.getFileName()+".pdf");
            String pathPdf="tickets/"+generatorPDF.getFileName()+".pdf";
            FileSystemResource file=new FileSystemResource(new File(pathPdf));
            helper.addAttachment(file.getFilename(), file);

            javaMailSender.send(message);
        }catch (MessagingException e){

        }

    }
}
