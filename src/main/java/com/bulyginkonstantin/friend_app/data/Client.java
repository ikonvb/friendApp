package com.bulyginkonstantin.friend_app.data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    @NotBlank(message = "Password is mandatory")
    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    public Client(String login, String userName, String email, String password, String confirmPassword) {
        this.login = login;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public Client() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(login, client.login) && Objects.equals(userName, client.userName) && Objects.equals(email, client.email) && Objects.equals(password, client.password) && Objects.equals(confirmPassword, client.confirmPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, userName, email, password, confirmPassword);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
