package ru.kpfu.itis.form;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class SignUpForm {
    private String username;
    private String email;
    private String password;
}
