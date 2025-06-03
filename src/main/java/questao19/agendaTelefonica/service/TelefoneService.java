package questao19.agendaTelefonica.service;

import org.springframework.stereotype.Service;
import questao19.agendaTelefonica.enums.TipoTelefoneEnum;
import questao19.agendaTelefonica.model.Telefone;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelefoneService {

    List<Telefone> telefones = new ArrayList<>();

    public List<Telefone> criarTelefone (Telefone telefoneNovo){
        Telefone telefone = new Telefone();
        telefone.setId(telefoneNovo.getId());
        telefone.setTipo(telefoneNovo.getTipo());
        telefone.setNumero(telefoneNovo.getNumero());

        telefones.add(telefone);

        return telefones;
    }

    public void deletarTelefone(Telefone telefone){
        telefones.remove(telefone);
    }
    public List<Telefone> editarTelefone(Telefone telefoneEditado,Telefone telefoneAEditar){
        if (telefones.contains(telefoneAEditar)){
            telefones.remove(telefoneAEditar);
             telefones.add(telefoneEditado);
        }
        return telefones;
    }

    public List<Telefone> retornarListaDeTelefones(){
        return telefones;
    }

    public List<TipoTelefoneEnum> retornarTipoTelefone(){
        List<TipoTelefoneEnum> tiposDeTelefones = new ArrayList<>();
        tiposDeTelefones.add(TipoTelefoneEnum.CELULAR);
        tiposDeTelefones.add(TipoTelefoneEnum.CASA);
        tiposDeTelefones.add(TipoTelefoneEnum.TRABALHO);
        return tiposDeTelefones;
    }

}
