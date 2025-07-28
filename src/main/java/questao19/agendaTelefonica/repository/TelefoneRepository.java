package questao19.agendaTelefonica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import questao19.agendaTelefonica.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone,Long> {
}
