package questao19.agendaTelefonica.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Contato {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;


    private Telefone telefone;

    private boolean favorito;

    public Contato() {
    }

    public Contato(Long id, String nome, Telefone telefone, boolean favorito) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.favorito = favorito;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
}
