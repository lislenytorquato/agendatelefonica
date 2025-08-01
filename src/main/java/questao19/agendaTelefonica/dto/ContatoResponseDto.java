package questao19.agendaTelefonica.dto;

import questao19.agendaTelefonica.model.Telefone;

import java.util.List;

public class ContatoResponseDto {

    private String nome;

    private Telefone telefone;

    private boolean favorito;

    public ContatoResponseDto(String nome, Telefone telefone, boolean favorito) {
        this.nome = nome;
        this.telefone = telefone;
        this.favorito = favorito;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
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
