package questao19.agendaTelefonica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import questao19.agendaTelefonica.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato,Long> {
}
