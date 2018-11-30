
package ru.kpfu.itis.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kpfu.itis.form.ProfileUpdateForm;
import ru.kpfu.itis.form.SignInForm;
import ru.kpfu.itis.form.SignUpForm;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repos.UserRepository;


import java.util.List;
import java.util.Optional;

public class UserService {
    public static final int REMEMBER_ME_COOKIE_EXPIRY = 60 * 60 * 24 * 365;
    private UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public void signUp(SignUpForm form) throws UserAlreadyExistsException {
        User user = this.getUserFromSignUpForm(form);
        if (!userRepository.existsByEmail(user.getEmail())) {

            userRepository.save(user);
        } else {
            throw new UserAlreadyExistsException();
        }
    }

    private User getUserFromSignUpForm(SignUpForm form) {
        return User.builder().username(form.getUsername())
                .email(form.getEmail())
                .hashPassword(form.getPassword())
                .build();
    }

    public User signIn(SignInForm form) throws WrongEmailOrPasswordException {
        String username = form.getUsername();
        String password = form.getPassword();
        System.err.println(form);
        if (username.isEmpty() || password.isEmpty()) {
            throw new WrongEmailOrPasswordException();
        }
        Optional<User> userCandidate = userRepository.findByEmail(username);
        if (userCandidate.isPresent()) {
            User user = userCandidate.get();
            System.err.println(user);
            System.err.println(user.getHashPassword());
            if (password.equals(user.getHashPassword())) {
                return user;
            }
        }
        throw new WrongEmailOrPasswordException();
    }


    public Optional<User> identifyUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public Optional<User> identifyUserByToken(String token)
    {
        return userRepository.findByToken(token);
    }

    public void update(User user) {
        userRepository.update(user);
    }




}

