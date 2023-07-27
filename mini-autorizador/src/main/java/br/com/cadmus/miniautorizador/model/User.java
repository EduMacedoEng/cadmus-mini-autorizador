package br.com.cadmus.miniautorizador.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "AUTHORIZER_USER")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = -7248973685256795507L;

    @Id
    @Column(name = "ID_USER", nullable = false, precision = 10, scale = 0)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE")
    private Long idUser;

    @Column(name = "NUM_RG", unique = true, nullable = true, precision = 10, scale = 0)
    private String numRgCivil;

    @Column(name = "NUM_CPF")
    private String numCpf;

    @Column(name = "USER_NAME", length = 120)
    private String userName;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public User() {
    }

    public User(String name, String mail) {
        this.userName = name;
        this.email = mail;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
