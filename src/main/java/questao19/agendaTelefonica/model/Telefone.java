package questao19.agendaTelefonica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import questao19.agendaTelefonica.enums.TipoTelefoneEnum;

import java.util.Objects;

@Entity
public class Telefone {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TipoTelefoneEnum tipo;
    private String numero;

    public Telefone(Long id, TipoTelefoneEnum tipo, String numero) {
        this.id = id;
        this.tipo = tipo;
        this.numero = numero;
    }

    public Telefone() {
    }

    public TipoTelefoneEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoTelefoneEnum tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return Objects.equals(id, telefone.id) && tipo == telefone.tipo && Objects.equals(numero, telefone.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo, numero);
    }
}
