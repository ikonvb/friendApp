package com.bulyginkonstantin.friend_app.data;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "client")
@Data
public class Client implements UserDetails {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 2, message = "Name must be at least 2 character long")
    @Column(name = "first_name")
    private String username;

    @Size(min = 2, message = "lastName must be at least 2 character long")
    @Column(name = "last_name")
    private String lastName;

    @Size(min = 6, message = "phone must be at least 6 character long")
    @Column(name = "phone")
    private String phone;

    @Email(message = "Please enter a valid email")
    @Column(name = "email")
    private String email;

    @Size(min = 2, message = "login must be at least 2 character long")
    @Column(name = "login")
    private String login;

    @Size(min = 4, message = "password must be at least 4 character long")
    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
