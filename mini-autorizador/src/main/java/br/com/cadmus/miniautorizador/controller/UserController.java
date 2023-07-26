package br.com.cadmus.miniautorizador.controller;

import br.com.cadmus.miniautorizador.dto.UserDTO;
import br.com.cadmus.miniautorizador.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllUsers() {
        try {
            return ResponseEntity.ok(userServiceImpl.findall());
        } catch (ResourceAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error returning users");
        }
    }

    @GetMapping("/byID/{id}")
    public ResponseEntity<UserDTO> findUserByID(@PathVariable Long id) {
        return ResponseEntity.ok(userServiceImpl.findByID(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> findUserByID(@PathVariable Long id, @RequestBody UserDTO usuarioDTO) {
        return ResponseEntity.ok(userServiceImpl.updateUser(id, usuarioDTO));
    }

    @PostMapping("/new")
    public ResponseEntity<UserDTO> newUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userServiceImpl.saveNewUser(userDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userServiceImpl.deleteUser(id);

        return ResponseEntity.noContent().build();
    }
}
