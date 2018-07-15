package br.ufpi.listavip.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufpi.listavip.model.Convidado;
import br.ufpi.listavip.services.ConvidadoService;

/**
 * Controlador do Domínio Convidado
 * @author armandosoaressousa
 *
 */
@Controller
public class ConvidadoController {
	
	@Autowired
	private ConvidadoService service;
	
	/**
	 * Carrega a página index do sistema
	 * @return index.html
	 */
	@RequestMapping("/")
	public String index(){
		return "index";
	}	
	
	/**
	 * Carrega a página com a lista de todos os convidados
	 * @param model Model da lista de convidados
	 * @return listaconvidados.html
	 */
	@RequestMapping("listaconvidados")
    public String listaConvidados(Model model){

        Iterable<Convidado> convidados = service.obterTodos();
        model.addAttribute("convidados", convidados);

        return "listaconvidados";
    }
	
	/**
	 * Salva um convidado na lista de convidados
	 * @param nome do convidado
	 * @param email do convidado
	 * @param telefone do convidado
	 * @param model model da lista de convidados
	 * @return redireciona para a página listaconvidados atualizada com o convidado salvo
	 */
	@RequestMapping(value= "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
	                   @RequestParam("telefone") String telefone, Model model ){

	    Convidado novoConvidado = new Convidado(nome, email, telefone);
	    service.salvar(novoConvidado);
	    //new EmailService().enviar(email, "Lista VIP", "Olá " + nome + " você foi convidado para a lista VIP!", "armando@ufpi.edu.br");

	    Iterable<Convidado> convidados = service.obterTodos();
	    model.addAttribute("convidados", convidados);

	    return "redirect:listaconvidados";
	}
	
}