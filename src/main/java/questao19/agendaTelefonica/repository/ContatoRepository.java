package questao19.agendaTelefonica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import questao19.agendaTelefonica.model.Contato;

import java.util.List;

public interface ContatoRepository extends JpaRepository<Contato,Long> {
    Contato findByNome(String nome);
    @Query(value = "SELECT * FROM contato WHERE favorito:true",nativeQuery = true)
    List<Contato> findFavoritos();
}
