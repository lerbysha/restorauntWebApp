package ru.kpfu.itis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Builder
@Data
@ToString
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private String email;
    private String hashPassword;
    private String token;
    private List<Order> orders;
}
