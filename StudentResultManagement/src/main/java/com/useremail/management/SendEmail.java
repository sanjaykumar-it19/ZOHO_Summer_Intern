package com.useremail.management;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SendEmail", urlPatterns = {"/SendEmail"})
public class SendEmail extends HttpServlet {
    
	
    String name, subject, email, msg;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// session management using mail id to send mail
    	HttpSession session = request.getSession();
        String email = (String)session.getAttribute("email1");
        
        System.out.println(email);
    	
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
      
        subject = "Result info";
        String msg = (String)session.getAttribute("mesg");
        // From username and password
        final String username = "sanjaykumar.it19@bitsathy.ac.in";//your email id
        final String password = "########";// your password
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put(" mail.smtp.ssl.trust", "smtp.gmail.com");
        
        Session session1 = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        
                    	
                    	return new PasswordAuthentication(username, password);
                    
                    
                    }
                }
        );
        
        try {
        	
        	// Messesage body
            Message message = new MimeMessage(session1);
            // from mail id
            message.setFrom(new InternetAddress(email));
            
           // to mail id which was taken as password from the login form
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(email));
            MimeBodyPart textPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();
            
            //body of content in the mail
            String final_Text = "Greetings !!!!"+"\n"+"Find Your Results Below:\n"+ msg;
            textPart.setText(final_Text);
            message.setSubject(subject);
            multipart.addBodyPart(textPart);
            
            
            message.setContent(multipart);
            message.setSubject("Result Summary");
            
            
            Transport.send(message);
            
            out.println("<center><h2 style='color:green;'>Email Sent Successfully.</h2>");
            out.println("Thank you !! Your Result has been shared with your mail id.</center>");
        
        
        }
        
        catch (Exception e) {
        	
            out.println(e);
        
        }
    }

}
