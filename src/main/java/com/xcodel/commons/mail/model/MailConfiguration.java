package com.xcodel.commons.mail.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
public class MailConfiguration {

    @NonNull
    private String smtpHost;

    @NonNull
    private Integer smtpPort;

    @NonNull
    private String smtpUserName;

    @NonNull
    private String smtpPassword;
}
