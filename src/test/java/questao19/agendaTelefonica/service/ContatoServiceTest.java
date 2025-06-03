package questao19.agendaTelefonica.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import questao19.agendaTelefonica.enums.TipoTelefoneEnum;
import questao19.agendaTelefonica.exception.ContatoException;
import questao19.agendaTelefonica.model.Contato;
import questao19.agendaTelefonica.model.Telefone;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ContatoServiceTest {

    public final static String NOME_1 = "Maria";
    public final static String NOME_2 = "Ana";
    public final static String NUMERO_1 = "54 12345-6789";
    public final static String NUMERO_2 = "54 98765-4321";
    public final static Long ID_1 = Long.valueOf("1");
    public final static Long ID_2 = Long.valueOf("2");

    @InjectMocks
    ContatoService contatoService;

    @Test
    @DisplayName("1- deve criar contato")
    void deveCriarContato() {
        Telefone telefone1 = new Telefone(ID_1, TipoTelefoneEnum.CELULAR, NUMERO_1);
        Telefone telefone2 = new Telefone(ID_2, TipoTelefoneEnum.CASA, NUMERO_2);
        Contato contato1 = new Contato(NOME_1, List.of(telefone1));
        Contato contato2 = new Contato(NOME_2, List.of(telefone2));
        List<Contato> listaDeContatosEsperada = List.of(contato1, contato2);
        contatoService.adicionarContato(contato1);
        List<Contato> contatosDoService = contatoService.adicionarContato(contato2);

        Assertions.assertEquals(2, contatosDoService.size());
        Assertions.assertEquals(listaDeContatosEsperada.get(0), contatosDoService.get(0));
        Assertions.assertEquals(listaDeContatosEsperada.get(1), contatosDoService.get(1));
    }

    @Test
    @DisplayName("2- deve remover contato")
    void deveRemoverContato() {
        Telefone telefone1 = new Telefone(ID_1, TipoTelefoneEnum.CELULAR, NUMERO_1);
        Telefone telefone2 = new Telefone(ID_2, TipoTelefoneEnum.CASA, NUMERO_2);
        Contato contato1 = new Contato(NOME_1, List.of(telefone1));
        Contato contato2 = new Contato(NOME_2, List.of(telefone2));

        contatoService.adicionarContato(contato1);
        List<Contato> contatosDoService = contatoService.adicionarContato(contato2);
        contatoService.removerContato(contato1);

        Assertions.assertEquals(1, contatosDoService.size());
    }

    @Test
    @DisplayName("3- deve editar contato")
    void deveEditarContato() {
        Telefone telefone1 = new Telefone(ID_1, TipoTelefoneEnum.CELULAR, NUMERO_1);
        Telefone telefone2 = new Telefone(ID_2, TipoTelefoneEnum.CASA, NUMERO_2);
        Contato contato1 = new Contato(NOME_1, List.of(telefone1));
        Contato contato2 = new Contato(NOME_2, List.of(telefone2));

        contatoService.adicionarContato(contato1);
        List<Contato> contatoEditado = contatoService.editarContato(contato2, contato1);

        Assertions.assertEquals(NOME_2, contatoEditado.get(0).getNome());
        Assertions.assertEquals(1, contatoEditado.size());
    }

    @Test
    @DisplayName("4- deve não editar contato")
    void deveNaoEditarContato() {
        Telefone telefone1 = new Telefone(ID_1, TipoTelefoneEnum.CELULAR, NUMERO_1);
        Telefone telefone2 = new Telefone(ID_2, TipoTelefoneEnum.CASA, NUMERO_2);
        Contato contato1 = new Contato(NOME_1, List.of(telefone1));
        Contato contato2 = new Contato(NOME_2, List.of(telefone2));
        List<Contato> contatoEditado = contatoService.editarContato(contato2, contato1);

        Assertions.assertEquals(0, contatoEditado.size());
    }

    @Test
    @DisplayName("5- deve favoritar contato")
    void deveFavoritarContato() {
        Telefone telefone1 = new Telefone(ID_1, TipoTelefoneEnum.CELULAR, NUMERO_1);
        Contato contato1 = new Contato(NOME_1, List.of(telefone1));

        Assertions.assertEquals(1, contatoService.adicionarAosFavoritos(contato1).size());
    }

    @Test
    @DisplayName("6- deve ordenar alfabeticamente os contatos")
    void deveOrdenarAlfabeticamenteOsContatos() {
        Telefone telefone1 = new Telefone(ID_1, TipoTelefoneEnum.CELULAR, NUMERO_1);
        Telefone telefone2 = new Telefone(ID_2, TipoTelefoneEnum.CASA, NUMERO_2);
        Contato contato1 = new Contato(NOME_1, List.of(telefone1));
        Contato contato2 = new Contato(NOME_2, List.of(telefone2));
        contatoService.adicionarContato(contato1);
        contatoService.adicionarContato(contato2);
        contatoService.adicionarAosFavoritos(contato1);
        contatoService.adicionarAosFavoritos(contato2);
        contatoService.ordenarListaAlfabetica();


        Assertions.assertEquals(NOME_2, contatoService.retornarContatos().get(0).getNome());
        Assertions.assertEquals(NOME_1, contatoService.retornarContatos().get(1).getNome());
        Assertions.assertEquals(NOME_2, contatoService.retornarFavoritos().get(0).getNome());
        Assertions.assertEquals(NOME_1, contatoService.retornarFavoritos().get(1).getNome());
    }

    @Test
    @DisplayName("7- deve buscar contato")
    void deveBuscarContato() throws ContatoException {
        Telefone telefone1 = new Telefone(ID_1, TipoTelefoneEnum.CELULAR, NUMERO_1);
        Telefone telefone2 = new Telefone(ID_2, TipoTelefoneEnum.CASA, NUMERO_2);
        Contato contato1 = new Contato(NOME_1, List.of(telefone1));
        Contato contato2 = new Contato(NOME_2, List.of(telefone2));
        contatoService.adicionarContato(contato1);
        contatoService.adicionarContato(contato2);

        Assertions.assertEquals(contato1, contatoService.buscarContato(NOME_1));
    }

    @Test
    @DisplayName("8- deve lancar excecao ao buscar contato inexistente")
    void deveLancarExcecaoAoBuscarContatoInexistente() throws ContatoException {
        Telefone telefone1 = new Telefone(ID_1, TipoTelefoneEnum.CELULAR, NUMERO_1);
        Telefone telefone2 = new Telefone(ID_2, TipoTelefoneEnum.CASA, NUMERO_2);
        Contato contato1 = new Contato(NOME_1, List.of(telefone1));
        contatoService.adicionarContato(contato1);

        Assertions.assertThrows(ContatoException.class, ()-> contatoService.buscarContato(NOME_2));
    }
}
