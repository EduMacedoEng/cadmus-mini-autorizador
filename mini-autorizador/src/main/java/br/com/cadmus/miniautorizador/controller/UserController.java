package br.com.cadmus.miniautorizador.controller;

import br.com.cadmus.miniautorizador.dto.UserDTO;
import br.com.cadmus.miniautorizador.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/find-all")
    public ResponseEntity<?> findAllUsers() {
        try {
            return ResponseEntity.ok(userServiceImpl.findall());
        } catch (ResourceAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error returning users");
        }
    }

    @PostMapping("/new-user")
    public ResponseEntity<UserDTO> newUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userServiceImpl.saveNewUser(userDTO), HttpStatus.CREATED);
    }
}
