package com.bulyginkonstantin.friend_app.data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UpdateClient {

    @NotBlank(message = "Login is mandatory")
    @Column(name = "login")
    private String login;

    @NotBlank(message = "User name is mandatory")
    @Column(name = "user_name")
    private String userName;

    @NotBlank(message = "Email is mandatory")
    @Email
    @Column(name = "email")
    private String email;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
