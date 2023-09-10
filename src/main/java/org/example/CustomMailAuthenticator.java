package org.example;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class CustomMailAuthenticator extends Authenticator {
    @Override
    protected PasswordAuthentication getPasswordAuthentication()
    {
        return new PasswordAuthentication(MailConstants.SENDER, MailConstants.APP_PASSWORD);

    }
}
