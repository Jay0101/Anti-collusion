/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package  actionPackage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class mail_Send {

    public static boolean sendMail(String msg, String userid, String to) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");


        Session session = Session.getDefaultInstance(props,
        new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("anticloud94@gmail.com","helpme13");
        }
        });
        
        System.out.println("Message   " + msg);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userid));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
            message.setSubject("Signature key ");
            message.setText(msg);
            Transport.send(message);
            System.out.println("Done");
            System.out.println(message);
            return true;
        } 
        
        catch (MessagingException e) {
            e.printStackTrace();
             return false;
        }
       
    }

}

