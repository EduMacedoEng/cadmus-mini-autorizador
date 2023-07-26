package br.com.cadmus.miniautorizador.repository.mongo;

import br.com.cadmus.miniautorizador.model.Biometry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BiometryRepository extends MongoRepository<Biometry, String>{
}
