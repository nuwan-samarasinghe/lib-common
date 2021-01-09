package com.xcodel.commons.mail.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Email {

    @NonNull
    private String toName;

    @NonNull
    private String toEmail;

    @NonNull
    private String fromName;

    @NonNull
    private String fromEmail;

    @NonNull
    private String subject;

    @NonNull
    private String body;




}
