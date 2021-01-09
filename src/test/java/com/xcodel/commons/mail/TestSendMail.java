package com.xcodel.commons.mail;

import com.xcodel.commons.mail.model.Email;
import com.xcodel.commons.mail.model.MailConfiguration;
import org.junit.Assert;
import org.junit.Test;

public class TestSendMail {

    @Test
    public void testSendMail() {
        MailConfiguration mailConfiguration = new MailConfiguration();
        mailConfiguration.setSmtpHost("mail.bhoomitech.com");
        mailConfiguration.setSmtpPort(25);
        mailConfiguration.setSmtpUserName("gnsspp@bhoomitech.com");
        mailConfiguration.setSmtpPassword("D,ISp~BBujlt}(k4E?");

        Email email = new Email();
        email.setToName("Supun Kanushka");
        email.setToEmail("skanushka@gmail.com");
        email.setFromName("Bhoomitech");
        email.setFromEmail("gnsspp@bhoomitech.com");
        email.setSubject("Hello from XCODEL Mail service");
        email.setBody("Hello I'm from XCODEL");

        boolean success = MailService.getMailService(mailConfiguration).sendMail(email);
        Assert.assertTrue("email sent successfully", success);
    }

}
