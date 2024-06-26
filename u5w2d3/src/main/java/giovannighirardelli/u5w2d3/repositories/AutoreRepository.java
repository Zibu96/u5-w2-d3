package giovannighirardelli.u5w2d3.repositories;

import giovannighirardelli.u5w2d3.entities.Autore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutoreRepository extends JpaRepository<Autore, Integer> {

    boolean existsByNomeAndCognome(String nome, String cognome);
}
