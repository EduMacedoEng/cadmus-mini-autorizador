package br.com.cadmus.miniautorizador.service;

import br.com.cadmus.miniautorizador.dto.UserDTO;
import br.com.cadmus.miniautorizador.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<User> findall();
    UserDTO saveNewUser(UserDTO usuarioDto);
}
