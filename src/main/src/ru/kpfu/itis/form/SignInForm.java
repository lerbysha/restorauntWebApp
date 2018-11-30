package ru.kpfu.itis.form;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class SignInForm {
    private String username;
    private String password;
}
