package questao19.agendaTelefonica.dto;

import questao19.agendaTelefonica.model.Telefone;

import java.util.List;

public class ContatoRequestDto {

    private String nome;

    private Telefone telefone;

    private boolean favorito;

    public ContatoRequestDto(String nome, Telefone telefone, boolean favorito) {
        this.nome = nome;
        this.telefone = telefone;
        this.favorito = favorito;
    }

    public String getNome() {
        return nome;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public boolean isFavorito() {
        return favorito;
    }
}
