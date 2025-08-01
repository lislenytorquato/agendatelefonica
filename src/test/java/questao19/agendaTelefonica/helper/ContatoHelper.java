package questao19.agendaTelefonica.helper;

import questao19.agendaTelefonica.dto.ContatoRequestDto;
import questao19.agendaTelefonica.dto.ContatoResponseDto;
import questao19.agendaTelefonica.enums.TipoTelefoneEnum;
import questao19.agendaTelefonica.model.Contato;
import questao19.agendaTelefonica.model.Telefone;

public class ContatoHelper {

    public final static String NOME = "Maria";
    public final static String DDD = "84";
    public final static String NUMERO = "12345-6789";
    public final static Long ID = 1L;

    public static Telefone criarTelefone(){
        return  new Telefone(TipoTelefoneEnum.CELULAR, NUMERO, DDD);
    }
    public static ContatoRequestDto criarRequestDto(){

        return new ContatoRequestDto(NOME, criarTelefone(),true);
    }
    public static ContatoResponseDto criarResponseDto(){
        return  new ContatoResponseDto(NOME, criarTelefone(),true);
    }
    public static Contato criarContato(){
        return new Contato(ID, NOME,criarTelefone(),true);
    }


}
