package com.xcodel.commons.mail;

import com.xcodel.commons.mail.model.Email;
import com.xcodel.commons.mail.model.MailConfiguration;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Synchronized;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

import java.util.Objects;

/**
 * I'm wrapping simple java mail library from http://www.simplejavamail.org/
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MailService {

    @NonNull
    private static Mailer simpleMailer;

    @NonNull
    private static MailService mailService;

    @Synchronized
    public static @NonNull MailService getMailService(@NonNull MailConfiguration mailConfiguration) {
        if (Objects.isNull(simpleMailer)) {
            mailService = new MailService();
            simpleMailer = MailerBuilder.withSMTPServer(
                    mailConfiguration.getSmtpHost(),
                    mailConfiguration.getSmtpPort(),
                    mailConfiguration.getSmtpUserName(),
                    mailConfiguration.getSmtpPassword())
                    .buildMailer();
        }
        return mailService;
    }

    public boolean sendMail(@NonNull Email email) {
        simpleMailer.sendMail(EmailBuilder.startingBlank()
                .to(email.getToName(), email.getToEmail())
                .from(email.getFromName(), email.getFromEmail())
                .withSubject(email.getSubject())
                .withHTMLText(email.getBody())
                .buildEmail());
        return true;
    }

    public boolean sendMailWithCC(@NonNull Email email) {
        Objects.nonNull(email.getCcName());
        Objects.nonNull(email.getCcEmail());

        simpleMailer.sendMail(EmailBuilder.startingBlank()
                .to(email.getToName(), email.getToEmail())
                .cc(email.getCcName(), email.getCcEmail())
                .from(email.getFromName(), email.getFromEmail())
                .withSubject(email.getSubject())
                .withHTMLText(email.getBody())
                .buildEmail());
        return true;
    }

}
