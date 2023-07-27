package br.com.cadmus.miniautorizador.Utils;

import br.com.cadmus.miniautorizador.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserTestUtil {
    public static User uniqueUser() {
        User user = new User();

        user.setIdUser(1L);
        user.setUserName("João");
        user.setNumCpf("12345678900");
        user.setNumRgCivil("1234456665");
        user.setEmail("teste@teste.com");
        user.setBirthDate(LocalDate.of(1995, 9, 12));
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        return user ;
    }

    public static List<User> listUsers() {
        User user1 = new User();

        user1.setIdUser(1L);
        user1.setUserName("João");
        user1.setNumCpf("12345678900");
        user1.setNumRgCivil("1234456665");
        user1.setEmail("teste@teste.com");
        user1.setBirthDate(LocalDate.of(1995, 9, 12));
        user1.setCreatedAt(LocalDateTime.now());
        user1.setUpdatedAt(LocalDateTime.now());

        User user2 = new User();

        user2.setIdUser(2L);
        user2.setUserName("João");
        user2.setNumCpf("12345678900");
        user2.setNumRgCivil("1234456665");
        user2.setEmail("teste@teste.com");
        user2.setBirthDate(LocalDate.of(1995, 9, 12));
        user2.setCreatedAt(LocalDateTime.now());
        user2.setUpdatedAt(LocalDateTime.now());

        return Stream.of(user1, user2).collect(Collectors.toList());
    }
}
