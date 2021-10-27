package com;


import javax.mail.*;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;



public class Mailman {





    public static void sendMail(String email) throws MessagingException {

       String host = "smtp.mailtrap.io";
       int port = 2525;
       String username = "0172916196964b";
       String password = "6e172dfc53212b";

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", port);
        prop.put("mail.smtp.ssl.trust", host);

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("maalti@web.de"));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse("tim.federolf@gmx.de"));
        message.setSubject("Mail Subject");

        String msg = "Bitte Passwort des Users: " + email + " zuruecksetzen!";

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);

    }




}

