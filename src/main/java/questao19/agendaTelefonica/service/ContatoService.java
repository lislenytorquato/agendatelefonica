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

    List<Contato> contatos = new ArrayList<>();
    List<Contato> favoritos = new ArrayList<>();
    List<Telefone> telefones = new ArrayList<>();

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
    public List<Contato> editarContato (Contato contatoEditado){
        if (contatos.contains(contatoEditado)){
            removerContato(contatoEditado);
        }
        return adicionarContato(contatoEditado);
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



}
