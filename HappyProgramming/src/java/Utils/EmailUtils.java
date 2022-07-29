/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import com.sendgrid.*;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class EmailUtils {
public static String apiKey = "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";
    public static void sendMail(String mailto, String otp) throws Exception {
        Email from = new Email("lenamphu12345@gmail.com");
        String subject = "OTP confirmation for Happy Programming";
        Email to = new Email(mailto);
        Content content = new Content("text/plain", "Greetings,\n Please use the authentiation code to finish your registration onto Happy Programming\n"+otp+"\nIf you did not request this, please ignore this email\nThanks!\n Happy Programming Team");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }

    }

        public static void sendPassEmail(String mailto, String password) throws Exception {
        Email from = new Email("lenamphu12345@gmail.com");
        String subject = "Password change for your account";
        Email to = new Email(mailto);
        Content content = new Content("text/plain", "Greetings,\n Please use the following password to log into Happy Programming\n"+password+"\nPlease change your password afterward\nIf you did not request this, please ignore this email\nThanks!\n Happy Programming Team");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }

    }

}
