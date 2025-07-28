package questao19.agendaTelefonica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import questao19.agendaTelefonica.enums.TipoTelefoneEnum;

import java.util.Objects;

@Entity
public class Favoritos {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Contato contato;

    public Favoritos(Long id, Contato contato) {
        this.id = id;
        this.contato = contato;
    }

    public Favoritos() {
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Favoritos favoritos = (Favoritos) o;
        return Objects.equals(id, favoritos.id) && Objects.equals(contato, favoritos.contato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contato);
    }
}
