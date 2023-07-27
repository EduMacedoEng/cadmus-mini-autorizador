package br.com.cadmus.miniautorizador.model;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "biometria")
public class Biometry {
    @Id
    private String id;

    private Long userId;

    private byte[] dadosBiometricos;
}
