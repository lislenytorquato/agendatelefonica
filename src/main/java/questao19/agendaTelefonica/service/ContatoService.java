package questao19.agendaTelefonica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import questao19.agendaTelefonica.dto.ContatoRequestDto;
import questao19.agendaTelefonica.dto.ContatoResponseDto;
import questao19.agendaTelefonica.exception.ContatoException;
import questao19.agendaTelefonica.mapper.ContatoMapper;
import questao19.agendaTelefonica.model.Contato;
import questao19.agendaTelefonica.repository.ContatoRepository;

import java.util.List;

@Service
public class ContatoService {

  @Autowired
  private ContatoRepository contatoRepository;

  @Autowired
  private ContatoMapper mapper;

    public ContatoResponseDto adicionarContato(ContatoRequestDto contatoNovo){
        Contato contato = mapper.contatoRequestDtoToEntity(contatoNovo);
        contatoRepository.save(contato);

         return mapper.entityToResponseDto(contato);
    }
}
