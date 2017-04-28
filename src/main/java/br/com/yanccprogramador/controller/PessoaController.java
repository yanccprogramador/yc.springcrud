package br.com.yanccprogramador.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.yanccprogramador.model.ClienteModel;
import br.com.yanccprogramador.repository.PessoaRepository;

@Controller
public class PessoaController {
	@Autowired
	PessoaRepository pr;
	@GetMapping("/home")
	public ModelAndView buscar() {
		
		
		ModelAndView mav= new ModelAndView("index");
		mav.addObject("pessoa",pr.findAll());
	
		return mav;

	}
	@GetMapping("/cadastro")
	public ModelAndView cadastrar(ClienteModel pessoa){
		ModelAndView mav= new ModelAndView("cadastro");
		mav.addObject(pessoa);
		return mav;
		
	}                        
	@PostMapping("/inserir") 
	public String inserir(ClienteModel pessoa) {
		
		
		pr.save(pessoa);
		return "redirect:/home";


	}
	@PostMapping("/{id}") 
	public ModelAndView editar(@PathVariable Long id) {
		ClienteModel clienteModel=pr.findOne(id);
	
     return cadastrar(clienteModel);

	}
	@PostMapping("/delete/{id}") 
	public String delete(@PathVariable Long id) {
		
		
		this.pr.delete(id);
		return "redirect:/home";


	}
}
