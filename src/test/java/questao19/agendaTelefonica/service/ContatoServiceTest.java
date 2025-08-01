package questao19.agendaTelefonica.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import questao19.agendaTelefonica.dto.ContatoRequestDto;
import questao19.agendaTelefonica.dto.ContatoResponseDto;
import questao19.agendaTelefonica.enums.TipoTelefoneEnum;
import questao19.agendaTelefonica.exception.ContatoException;
import questao19.agendaTelefonica.helper.ContatoHelper;
import questao19.agendaTelefonica.mapper.ContatoMapper;
import questao19.agendaTelefonica.model.Contato;
import questao19.agendaTelefonica.model.Telefone;
import questao19.agendaTelefonica.repository.ContatoRepository;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ContatoServiceTest {


    @InjectMocks
    ContatoService contatoService;

    @Mock
    ContatoMapper mapper;

    @Mock
    ContatoRepository contatoRepository;

    @Test
    @DisplayName("1- deve criar contato")
    void deveCriarContato() {
        ContatoRequestDto contatoRequestDto = ContatoHelper.criarRequestDto();
        Contato contato = ContatoHelper.criarContato();
        ContatoResponseDto responseDtoEsperado = ContatoHelper.criarResponseDto();

        Mockito.when(mapper.contatoRequestDtoToEntity(contatoRequestDto)).thenReturn(contato);
        Mockito.when(contatoRepository.save(mapper.contatoRequestDtoToEntity(contatoRequestDto))).thenReturn(contato);
        Mockito.when(mapper.entityToResponseDto(contato)).thenReturn(responseDtoEsperado);

        ContatoResponseDto responseDto = contatoService.adicionarContato(contatoRequestDto);

        Assertions.assertEquals(responseDtoEsperado.getNome(), responseDto.getNome());
        Assertions.assertEquals(responseDtoEsperado.getTelefone(),responseDto.getTelefone());
        Assertions.assertEquals(responseDtoEsperado.isFavorito(),responseDto.isFavorito());

    }


}
