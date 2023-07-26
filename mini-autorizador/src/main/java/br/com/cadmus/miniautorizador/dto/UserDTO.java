package br.com.cadmus.miniautorizador.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserDTO {
    private String numRgCivil;
    private String numCpf;
    private String userName;

    private Date birthDate;
    private String email;

    public String getNumRgCivil() {
        return numRgCivil;
    }

    public void setNumRgCivil(String numRgCivil) {
        this.numRgCivil = numRgCivil;
    }

    public String getNumCpf() {
        return numCpf;
    }

    public void setNumCpf(String numCpf) {
        this.numCpf = numCpf;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
