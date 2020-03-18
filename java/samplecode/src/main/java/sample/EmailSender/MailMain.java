package sample.EmailSender;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;


public class MailMain {
    public static void main(String[] args) {
        System.out.println("SimpleEmail Start");

        String smtpHostServer = "smtp.gmail.com";
        String emailID = "doodujiggang@naver.com";

        Properties props = System.getProperties();

        props.put("mail.smtp.host", smtpHostServer);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("*********", "********");
                    }
                });

        EmailSender.sendEmail(session, emailID, "SimpleEmail Testing Subject", "SimpleEmail Testing Body");


    }
}
