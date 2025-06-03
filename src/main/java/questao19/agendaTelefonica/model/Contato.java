package questao19.agendaTelefonica.model;

import java.util.List;
import java.util.Objects;

public class Contato {

    private String nome;
    private List<Telefone> telefone;

    public Contato() {
    }

    public Contato(String nome, List<Telefone> telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<Telefone> telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(nome, contato.nome) && Objects.equals(telefone, contato.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, telefone);
    }
}
