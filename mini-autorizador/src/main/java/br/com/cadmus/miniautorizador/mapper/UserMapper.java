package br.com.cadmus.miniautorizador.mapper;

import br.com.cadmus.miniautorizador.dto.UserDTO;
import br.com.cadmus.miniautorizador.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserDTO dto) {
        User user = new User();

        user.setUserName(dto.getUserName());
        user.setBirthDate(dto.getBirthDate());
        user.setEmail(dto.getEmail());
        user.setNumCpf(dto.getNumCpf());
        user.setNumRgCivil(dto.getNumRgCivil());

        return user;
    }

    public UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();

        dto.setUserName(user.getUserName());
        dto.setBirthDate(user.getBirthDate());
        dto.setEmail(user.getEmail());
        dto.setNumCpf(user.getNumCpf());
        dto.setNumRgCivil(user.getNumRgCivil());

        return dto;

    }
}
