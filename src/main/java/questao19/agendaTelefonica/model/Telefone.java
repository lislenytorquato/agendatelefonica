package questao19.agendaTelefonica.model;

import jakarta.persistence.*;
import questao19.agendaTelefonica.enums.TipoTelefoneEnum;

import java.util.Objects;

@Embeddable
public class Telefone {

    private TipoTelefoneEnum tipo;

    private String ddd;
    private String numero;

    public Telefone( TipoTelefoneEnum tipo, String numero,String ddd) {
        this.tipo = tipo;
        this.numero = numero;
        this.ddd = ddd;
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

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }
}
