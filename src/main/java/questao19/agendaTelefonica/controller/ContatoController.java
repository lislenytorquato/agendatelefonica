package questao19.agendaTelefonica.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import questao19.agendaTelefonica.dto.ContatoRequestDto;
import questao19.agendaTelefonica.dto.ContatoResponseDto;
import questao19.agendaTelefonica.model.Contato;
import questao19.agendaTelefonica.service.ContatoService;

import java.util.List;

@RestController
@RequestMapping(value = "/contatos")
public class ContatoController {

    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService){
        this.contatoService = contatoService;
    }

    @PostMapping
    public ResponseEntity<ContatoResponseDto>criar(@RequestBody ContatoRequestDto contato){
        ContatoResponseDto contatos = this.contatoService.adicionarContato(contato);
        return new ResponseEntity<>(contatos, HttpStatus.CREATED);
    }

}
