package questao19.agendaTelefonica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import questao19.agendaTelefonica.model.Favoritos;

public interface FavoritosRepository extends JpaRepository<Favoritos,Long> {
}
