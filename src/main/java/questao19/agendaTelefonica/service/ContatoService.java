package questao19.agendaTelefonica.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import questao19.agendaTelefonica.exception.ContatoException;
import questao19.agendaTelefonica.model.Contato;
import questao19.agendaTelefonica.model.Favoritos;
import questao19.agendaTelefonica.model.Telefone;
import questao19.agendaTelefonica.repository.ContatoRepository;
import questao19.agendaTelefonica.repository.FavoritosRepository;
import questao19.agendaTelefonica.repository.TelefoneRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

  private final ContatoRepository contatoRepository;
  private final TelefoneRepository telefoneRepository;
  private final FavoritosRepository favoritosRepository;
  private final Favoritos favoritos;

  public ContatoService(ContatoRepository contatoRepository, TelefoneRepository telefoneRepository, FavoritosRepository favoritosRepository, Favoritos favoritos){
      this.contatoRepository = contatoRepository;
      this.telefoneRepository = telefoneRepository;
      this.favoritosRepository = favoritosRepository;
      this.favoritos = favoritos;
  }

    public List<Contato> adicionarContato(Contato contatoNovo){

        contatoRepository.save(contatoNovo);

        return contatoRepository.findAll();
    }
    public void removerContato (Long id){
        Contato contato = repositoryFindById(id);
        contatoRepository.delete(contato);
    }

    public List<Contato> editarContato (Contato contatoEditado, Long id){
        Contato contato = repositoryFindById(id);
        contato.setNome(contatoEditado.getNome());
        contato.setTelefone(contatoEditado.getTelefone());

        contatoRepository.save(contato);
        return contatoRepository.findAll();

    }
    public List<Favoritos> adicionarAosFavoritos(Contato contatoFavoritado){
        favoritos.setContato(contatoFavoritado);
        favoritosRepository.save(favoritos);
        return favoritosRepository.findAll();
    }
    public List<Contato> ordenarListaDeContatosAlfabeticamente(){

        List<Contato> contatos = contatoRepository.findAll();
        contatos.sort(Comparator.comparing(Contato::getNome));
        return contatos;
    }
    public List<Favoritos> ordenarListaDeFavoritosAlfabeticamente(){
        List<Favoritos> listaDeFavoritos = favoritosRepository.findAll();
        listaDeFavoritos.sort(Comparator.comparing(favoritos.getContato().getNome()));
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
    private Contato repositoryFindById(Long id){
        return contatoRepository.findById(id).orElseThrow(() -> new ContatoException("Contato nao encontrado"));
    }
}
