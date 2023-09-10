package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
@Component
public class MailHandlerBase {
@Autowired
Car car;
    public void sendMail()
    {


        //properties

        //something like a map
        Properties sysPropertiesMap = System.getProperties();

        //System.out.println(sysPropertiesMap);

        //in this map I want to add 4 more key value pairs : mailing

        sysPropertiesMap.put("mail.smtp.host","smtp.gmail.com"); //smtp server
        sysPropertiesMap.put("mail.smtp.port","465"); //server port
        sysPropertiesMap.put("mail.smtp.ssl.enable","true"); //ssl -secure socket layer
        sysPropertiesMap.put("mail.smtp.auth","true"); //authentication - auth


        //authentication

        Authenticator mailAuthenticator = new CustomMailAuthenticator();


        //session
        Session mailSession = Session.getInstance(sysPropertiesMap,mailAuthenticator);


        //build the mail
        //Mime message

        MimeMessage mailMessage = new MimeMessage(mailSession);

        try {
            mailMessage.setFrom(MailConstants.SENDER);
            mailMessage.setSubject("Geekster Mailing class");
            mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("nitishking01@gmail.com"));


            mailMessage.setText(car.colour);

            Transport.send(mailMessage);

            System.out.println("Mail sent !!!");
        }
        catch(Exception ex)
        {
            System.out.println("Some error while preparing mail body!!!!");
            System.out.println(ex.getMessage());
        }
}
}
