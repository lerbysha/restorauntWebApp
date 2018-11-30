package ru.kpfu.itis.service;

public class WrongEmailOrPasswordException extends Exception {
    @Override
    public String getMessage() {
        return "Неверно введены электронная почта или пароль.";
    }
}
