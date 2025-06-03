package questao19.agendaTelefonica.service;

import org.springframework.stereotype.Service;
import questao19.agendaTelefonica.exception.ContatoException;
import questao19.agendaTelefonica.model.Contato;
import questao19.agendaTelefonica.model.Telefone;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    private List<Contato> contatos = new ArrayList<>();
    private List<Contato> favoritos = new ArrayList<>();

    public List<Contato> adicionarContato(Contato contatoNovo){
        Contato contato = new Contato();
        contato.setNome(contatoNovo.getNome());
        contato.setTelefone(contatoNovo.getTelefone());

        contatos.add(contato);

        return contatos;
    }
    public void removerContato (Contato contatoASerRemovido){
        contatos.remove(contatoASerRemovido);
    }

    public List<Contato> editarContato (Contato contatoEditado, Contato contatoAEditar){
        if (contatos.contains(contatoAEditar)){
            removerContato(contatoAEditar);
            contatos.add(contatoEditado);
        }
        return contatos;
    }
    public List<Contato> adicionarAosFavoritos(Contato contatoFavoritado){
        favoritos.add(contatoFavoritado);
        return favoritos;
    }
    public void ordenarListaAlfabetica(){
        contatos.sort(Comparator.comparing(Contato::getNome));
        favoritos.sort(Comparator.comparing(Contato::getNome));
    }
    public Contato buscarContato(String nomeBuscado) throws ContatoException {
        Optional<Contato> contatoBuscado = contatos.stream().
                filter(contato ->
                        contato.getNome().equalsIgnoreCase(nomeBuscado))
                .findFirst();
        if (contatoBuscado.isEmpty()){
            throw new ContatoException("Contato não encontrado");
        }
        return contatoBuscado.get();
    }

    public List<Contato> retornarContatos() {
        return contatos;
    }

    public List<Contato> retornarFavoritos() {
        return favoritos;
    }
}
