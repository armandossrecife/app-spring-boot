package br.ufpi.listavip.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufpi.listavip.model.Convidado;
import br.ufpi.listavip.repository.ConvidadoRepository;

/**
 * Classe de serviço que acessa o repositório de Convidados
 * @author armandosoaressousa
 *
 */
@Service
public class ConvidadoService {

    @Autowired
    private ConvidadoRepository repository;

    /**
     * Busca todos os convidados cadastrados no repositório
     * @return Iterable de convidados
     */
    public Iterable<Convidado> obterTodos(){
        Iterable<Convidado> convidados = repository.findAll();
        return convidados;
    }

    /**
     * Salva um convidado no repositório
     * @param convidado Convidado
     */
    public void salvar(Convidado convidado){
        repository.save(convidado);
    }
}
