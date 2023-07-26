package br.com.cadmus.miniautorizador.service;

import br.com.cadmus.miniautorizador.dto.UserDTO;
import br.com.cadmus.miniautorizador.exception.UserNotCreatedException;
import br.com.cadmus.miniautorizador.mapper.UserMapper;
import br.com.cadmus.miniautorizador.model.User;
import br.com.cadmus.miniautorizador.repository.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<User> findall() {
        return Optional.of(userRepository.findAll())
                .orElseThrow(() -> new RuntimeException ("Failed to fetch users"));
    }

    @Override
    public UserDTO saveNewUser(UserDTO usuarioDto) {
        User newUser = userMapper.toEntity(usuarioDto);

        try {
            newUser = userRepository.save(newUser);
        } catch (Exception e) {
            throw new UserNotCreatedException("Error creating user", e);
        }

        return userMapper.toDTO(newUser);
    }
}
