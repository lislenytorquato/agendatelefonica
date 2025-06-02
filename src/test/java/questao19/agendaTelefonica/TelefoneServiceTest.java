package questao19.agendaTelefonica;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import questao19.agendaTelefonica.enums.TipoTelefoneEnum;
import questao19.agendaTelefonica.model.Telefone;
import questao19.agendaTelefonica.service.TelefoneService;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TelefoneServiceTest {
    
    public final static String NUMERO_1 = "54 12345-6789";
    public final static String NUMERO_2 = "54 98765-4321";
    public final static Long ID_1 = 1L;
    public final static Long ID_2 = 2L;
    
    @InjectMocks
    TelefoneService telefoneService;
    
    @Test
    @DisplayName("1- deve adicionar Telefone")
    void deveAdicionarTelefone(){
        Telefone telefone1 = new Telefone(ID_1,TipoTelefoneEnum.CELULAR,NUMERO_1);
        Telefone telefone2 = new Telefone(ID_2,TipoTelefoneEnum.CASA,NUMERO_2);
        List<Telefone> telefones = List.of(telefone1, telefone2);
        telefoneService.criarTelefone(telefone1);
        List<Telefone> telefonesCriados = telefoneService.criarTelefone(telefone2);

        Assertions.assertEquals(telefones.get(0).getId(),telefonesCriados.get(0).getId());
        Assertions.assertEquals(telefones.get(0).getTipo(),telefonesCriados.get(0).getTipo());
        Assertions.assertEquals(telefones.get(0).getNumero(),telefonesCriados.get(0).getNumero());
        Assertions.assertEquals(telefones.get(1).getId(),telefonesCriados.get(1).getId());
        Assertions.assertEquals(telefones.get(1).getTipo(),telefonesCriados.get(1).getTipo());
        Assertions.assertEquals(telefones.get(1).getNumero(),telefonesCriados.get(1).getNumero());
        Assertions.assertEquals(telefones.size(),telefonesCriados.size());
    }
    @Test
    @DisplayName("2- deve deletar telefone")
    void deveDeletarTelefone(){
        Telefone telefone1 = new Telefone(ID_1,TipoTelefoneEnum.CELULAR,NUMERO_1);
        Telefone telefone2 = new Telefone(ID_2,TipoTelefoneEnum.CASA,NUMERO_2);
        List<Telefone> telefones = List.of(telefone1, telefone2);
        telefoneService.criarTelefone(telefone1);
        List<Telefone> telefonesCriados = telefoneService.criarTelefone(telefone2);

        telefoneService.deletarTelefone(telefone1);
        Assertions.assertEquals(1,telefonesCriados.size());
    }
    @Test
    @DisplayName("3- deve editar telefone")
    void deveEditarTelefone(){
        Telefone telefone1 = new Telefone(ID_1,TipoTelefoneEnum.CELULAR,NUMERO_1);
        Telefone telefone2 = new Telefone(ID_1,TipoTelefoneEnum.CASA,NUMERO_2);
        List<Telefone> telefones = List.of(telefone1);
        List<Telefone> telefonesEditados = telefoneService.editarTelefone(telefone2);
        Assertions.assertEquals(telefones.get(0).getId(), telefonesEditados.get(0).getId());
        Assertions.assertNotEquals(telefones.get(0).getNumero(), telefonesEditados.get(0).getNumero());
        Assertions.assertNotEquals(telefones.get(0).getTipo(), telefonesEditados.get(0).getTipo());
    }

    @Test
    @DisplayName("1- deve retornar listas de Telefone")
    void deveAdicionarTelefone(){
        Telefone telefone1 = new Telefone(ID_1,TipoTelefoneEnum.CELULAR,NUMERO_1);
        Telefone telefone2 = new Telefone(ID_2,TipoTelefoneEnum.CASA,NUMERO_2);
        List<Telefone> telefones = List.of(telefone1, telefone2);
        telefoneService.criarTelefone(telefone1);
        List<Telefone> telefonesCriados = telefoneService.criarTelefone(telefone2);
}
