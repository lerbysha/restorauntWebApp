package ru.kpfu.itis.service;

public class UserAlreadyExistsException extends Exception {
    @Override
    public String getMessage() {
        return "Пользователь с таким email уже зарегистрирован.";
    }
}
