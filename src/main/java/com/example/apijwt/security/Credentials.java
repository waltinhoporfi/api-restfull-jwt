package com.example.apijwt.security;

import java.io.Serializable;

/**
 * @author Walter Porfirio
 *
 */
public class Credentials implements Serializable {

    private static final long serialVersionUID = -6312209003181781376L;

//    @NotNull
//    @NotBlank
//    @Email
    private String email;

//    @NotNull
//    @NotBlank
    private String password;

    public Credentials(String email, String password) {
        this.email = email;
        this.password = password;
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

}
