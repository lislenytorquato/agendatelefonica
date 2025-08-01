package questao19.agendaTelefonica.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import questao19.agendaTelefonica.dto.ContatoRequestDto;
import questao19.agendaTelefonica.dto.ContatoResponseDto;
import questao19.agendaTelefonica.enums.TipoTelefoneEnum;
import questao19.agendaTelefonica.helper.ContatoHelper;
import questao19.agendaTelefonica.model.Telefone;
import questao19.agendaTelefonica.service.ContatoService;

@ExtendWith(MockitoExtension.class)
public class ContatoControllerTest {


    @InjectMocks
    ContatoController contatoController;

    @Mock
    ContatoService contatoService;

    @Test
    @DisplayName("1- deve criar contato")
    void deveCriarContato(){
        ContatoRequestDto contatoRequestDto = ContatoHelper.criarRequestDto();
        ContatoResponseDto contatoResponseDto = ContatoHelper.criarResponseDto();

        Mockito.when(contatoService.adicionarContato(contatoRequestDto)).thenReturn(contatoResponseDto);

        ResponseEntity<ContatoResponseDto> responseEntity = contatoController.criar(contatoRequestDto);

        Assertions.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

}
