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

    /**
     * Busca um convidado por Id
     * @param id do convidado
     * @return convidado encontrado
     */
	public Convidado buscarClientePorId(Long id) {
		//Convidado resultado = repository.findById(id).get();
		return repository.findOne(id);
	}
	
	/**
	 * Deleta um convidado do repositório
	 * @param convidado selecionado
	 */
	public void remover(Convidado convidado){
		repository.delete(convidado);
	}
	
	/**
	 * Deleta um convidado do repositório
	 * @param id do convidado selecionado
	 */
	public void remover(Long id){
		repository.delete(this.buscarClientePorId(id));
	}

	/**
	 * Altera um convidado existente
	 * @param id do convidado existente selecionado
	 * @param nome novo nome do convidado
	 * @param email novo e-mail do convidado
	 * @param telefone novo telefone convidado
	 */
	public void alterar(Long id, String nome, String email, String telefone) {
		Convidado convidado = this.buscarClientePorId(id); 
		convidado.setEmail(email);
		convidado.setNome(nome);
		convidado.setTelefone(telefone);
	    repository.save(convidado);
	}
	
}