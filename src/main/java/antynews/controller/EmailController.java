package antynews.controller;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet(name = "Contact", value = "/antynews/contact")
public class EmailController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");


        String fromPara = req.getParameter("name");
        String mailPara = req.getParameter("email");
        String messagePara = req.getParameter("message");


        // Do kogo chcemy wysłać mail
        String to = "adam.florczak93@gmail.com";

        // Od kogo?
        String from = "antynews@wp.pl";
        String username = from;
        String password = "Trololo123";

        // Assuming you are sending email through relay.jangosmtp.net
        String host = "smtp.wp.pl";

        Properties props = new Properties();

        // Ustawienia dla SSL
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "465");


        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            message.setSubject("Użytkownik " + fromPara + " przesyła wiadomość");

            // Treść wiadomości


            // Wysyłanie wiadomosci plaintextem
             message.setText(messagePara + "\n\n\n\n\nE-mail do odpowiedzi: " + mailPara);

            // Wysyłanie

            Transport.send(message);

            req.setAttribute("succesfull", "Wiadomość wysłano!");

            resp.sendRedirect("http://localhost:8080/antynews/main");


        } catch (MessagingException e) {
            req.setAttribute("unsuccesfull", "Nie udało się wysłać wiadomości. Proszę spróbuj ponownie.");
        }






    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
