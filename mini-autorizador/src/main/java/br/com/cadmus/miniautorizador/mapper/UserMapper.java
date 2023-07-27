package br.com.cadmus.miniautorizador.mapper;

import br.com.cadmus.miniautorizador.dto.UserDTO;
import br.com.cadmus.miniautorizador.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserDTO dto) {
        User user = new User();

        user.setIdUser(dto.getId());
        user.setUserName(dto.getUserName());
        user.setBirthDate(dto.getBirthDate());
        user.setEmail(dto.getEmail());
        user.setNumCpf(dto.getNumCpf());
        user.setNumRgCivil(dto.getNumRgCivil());
        user.setCreatedAt(dto.getCreatedAt());
        user.setUpdatedAt(dto.getUpdatedAt());

        return user;
    }

    public UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();

        dto.setId(user.getIdUser());
        dto.setUserName(user.getUserName());
        dto.setBirthDate(user.getBirthDate());
        dto.setEmail(user.getEmail());
        dto.setNumCpf(user.getNumCpf());
        dto.setNumRgCivil(user.getNumRgCivil());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());

        return dto;

    }
}
