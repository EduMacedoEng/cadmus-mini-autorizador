package br.com.cadmus.miniautorizador.service;

import br.com.cadmus.miniautorizador.dto.UserDTO;
import br.com.cadmus.miniautorizador.exception.UserNotCreatedException;
import br.com.cadmus.miniautorizador.exception.UserNotFoundException;
import br.com.cadmus.miniautorizador.mapper.UserMapper;
import br.com.cadmus.miniautorizador.model.User;
import br.com.cadmus.miniautorizador.repository.jpa.UserRepository;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper = new ModelMapper();
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
    public UserDTO findByID(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuario não encontrado com o ID: " + id, null));

        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuario não encontrado com o ID: " + id, null));

        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(userDTO, user);

        User userUpdated = userRepository.save(user);

        return userMapper.toDTO(userUpdated);
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

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuario não encontrado com o ID: " + id, null));

        userRepository.delete(user);
    }
}
