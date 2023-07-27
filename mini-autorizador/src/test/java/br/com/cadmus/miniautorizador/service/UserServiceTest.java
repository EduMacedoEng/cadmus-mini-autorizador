package br.com.cadmus.miniautorizador.service;

import br.com.cadmus.miniautorizador.dto.UserDTO;
import br.com.cadmus.miniautorizador.exception.UserNotCreatedException;
import br.com.cadmus.miniautorizador.exception.UserNotFoundException;
import br.com.cadmus.miniautorizador.mapper.UserMapper;
import br.com.cadmus.miniautorizador.model.User;
import br.com.cadmus.miniautorizador.repository.jpa.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static br.com.cadmus.miniautorizador.Utils.UserTestUtil.listUsers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserMapper userMapper;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Test
    public void whenGetAllUsers_thenUsersShouldBeFound() {
        when(userRepository.findAll()).thenReturn(listUsers());

        List<User> listUsersFound = userServiceImpl.findall();

        assertThat(listUsers()).hasSize(listUsersFound.size());
    }

    @Test
    public void shouldUpdateUser() {
        // Preparação
        Long id = 1L;

        User user = new User();
        user.setIdUser(id);

        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("Test");

        User updatedUser = new User();
        updatedUser.setIdUser(id);
        updatedUser.setUserName("Test");

        UserDTO updatedUserDTO = new UserDTO();
        updatedUserDTO.setId(id);
        updatedUserDTO.setUserName("Test");

        // Configuração do comportamento dos mocks
        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(updatedUser);
        when(userMapper.toDTO(updatedUser)).thenReturn(updatedUserDTO);

        // Chamada do método a ser testado
        UserDTO result = userServiceImpl.updateUser(id, userDTO);

        // Verificações
        assertEquals(updatedUserDTO.getUserName(), result.getUserName());
        verify(userRepository).findById(id);
        verify(userRepository).save(any(User.class));
        verify(userMapper).toDTO(updatedUser);
    }

    @Test
    public void shouldSaveUser() {
        UserDTO userDTO = new UserDTO();
        User user = new User();
        User savedUser = new User();
        UserDTO savedUserDTO = new UserDTO();

        when(userMapper.toEntity(userDTO)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(savedUser);
        when(userMapper.toDTO(savedUser)).thenReturn(savedUserDTO);

        // Execução
        UserDTO result = userServiceImpl.saveNewUser(userDTO);

        // Verificações
        assertEquals(savedUserDTO, result);
        verify(userRepository).save(user);
    }

    @Test
    public void shouldThrowExceptionWhenErrorSaveNewUser() {
        // Preparação
        UserDTO userDTO = new UserDTO();
        User user = new User();

        when(userMapper.toEntity(userDTO)).thenReturn(user);
        when(userRepository.save(user)).thenThrow(RuntimeException.class);

        // Execução e Verificações
        assertThrows(UserNotCreatedException.class, () -> userServiceImpl.saveNewUser(userDTO));
        verify(userRepository).save(user);
    }

    @Test
    public void shouldDeleteUser() {
        // Preparação
        Long id = 1L;
        User user = new User();

        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        // Execução
        userServiceImpl.deleteUser(id);

        // Verificações
        verify(userRepository).findById(id);
        verify(userRepository).delete(user);
    }

    @Test
    public void shouldThrowExceptionWhenUserIsNotFound() {
        // Preparação
        Long id = 1L;

        when(userRepository.findById(id)).thenReturn(Optional.empty());

        // Execução e Verificações
        assertThrows(UserNotFoundException.class, () -> userServiceImpl.deleteUser(id));
        verify(userRepository).findById(id);
    }
}
