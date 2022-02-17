package com.bulyginkonstantin.friend_app.data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class LoginClient {

    @NotBlank(message = "Login is mandatory")
    @Column(name = "login")
    String login;

    @NotBlank(message = "Password is mandatory")
    @Column(name = "password")
    String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
