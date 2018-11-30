package ru.kpfu.itis.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProfileUpdateForm {
    private String email;
    private String password;
    private String confirmedPassword;
    private String username;
}
