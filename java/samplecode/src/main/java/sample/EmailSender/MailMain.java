package sample.EmailSender;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;


public class MailMain {

    static final String HOST = "smtp.gmail.com";

    // Replace smtp_username with your Amazon SES SMTP user name.
    static final String SMTP_USERNAME = "************@gmail.com";

    // Replace smtp_password with your Amazon SES SMTP password.
    static final String SMTP_PASSWORD = "****************";

    public static void main(String[] args) {
        System.out.println("SimpleEmail Start");

        String smtpHostServer = "smtp.gmail.com";
        String emailID = "1lines.maker@gmail.com";

        Properties props = System.getProperties();

        props.put("mail.smtp.host", smtpHostServer);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        final PasswordAuthentication auth = new PasswordAuthentication(SMTP_USERNAME, "*********************");

        Session mailSession = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() { return auth; }
        });

        EmailSender.sendEmail(mailSession, emailID, "SimpleEmail Testing Subject", "SimpleEmail Testing Body");


    }
}
