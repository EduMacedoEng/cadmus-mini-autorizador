package br.com.cadmus.miniautorizador.repository.jpa;

import br.com.cadmus.miniautorizador.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
