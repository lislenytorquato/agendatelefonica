package questao19.agendaTelefonica.mapper;

import org.springframework.stereotype.Component;
import questao19.agendaTelefonica.dto.ContatoRequestDto;
import questao19.agendaTelefonica.dto.ContatoResponseDto;
import questao19.agendaTelefonica.model.Contato;

import java.util.ArrayList;
import java.util.List;


@Component
public class ContatoMapper {

    public Contato contatoRequestDtoToEntity(ContatoRequestDto requestDto) {
        Contato contato = new Contato();
        contato.setNome(requestDto.getNome());
        contato.setTelefone(requestDto.getTelefone());
        contato.setFavorito(requestDto.isFavorito());

        return contato;
    }

    public ContatoResponseDto entityToResponseDto(Contato contato) {
        return new ContatoResponseDto(contato.getNome(),contato.getTelefone(),contato.isFavorito());
    }

    public List<ContatoResponseDto> listaEntityToListaResponseDto(List<Contato> contatos) {

        List<ContatoResponseDto> responseDtos = new ArrayList<>();
        for (Contato contato : contatos) {
            ContatoResponseDto responseDto = new ContatoResponseDto(contato.getNome(),contato.getTelefone(),contato.isFavorito());
            responseDtos.add(responseDto);
        }
        return responseDtos;

    }
}

