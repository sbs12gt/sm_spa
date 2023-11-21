package idat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import idat.entity.Consulta;
import idat.entity.Quejas;
import idat.service.IConsultaService;
import idat.service.IQuejasService;
import jakarta.validation.Valid;

@Controller
public class IndexController {
	
	@Autowired
	private IConsultaService consultaService;
	
	@Autowired
	private IQuejasService quejasService;
	
	@GetMapping({"/", "", "/principal"})
	public String principal(Model model) {
		model.addAttribute("titulo","SM Spa");
		return "principal";	
	}
	
	@GetMapping({"/nosotros"})
	public String nosotros(Model model) {
		model.addAttribute("titulo","SM Spa");
		return "nosotros";	
	}
	
	@GetMapping({"/servicios"})
	public String servicios(Model model) {
		model.addAttribute("titulo","SM Spa");
		return "servicios";	
	}
	
	@GetMapping({"/promociones"})
	public String promociones(Model model) {
		model.addAttribute("titulo","SM Spa");
		return "promociones";	
	}
	
	@GetMapping("/form")
	public String form(Model model){
		Consulta consulta = new Consulta();
		model.addAttribute("titulo","Formulario de contacto");
		model.addAttribute("consulta", consulta);
		return "fragments/form";
	}
	
	@PostMapping("/form")
	public String proceso(@Valid Consulta consulta, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("titulo","Formulario de contacto");
			return "fragments/form";
		}
		consultaService.save(consulta);
		return "redirect:principal";
	}
	
	@GetMapping("/encuesta")
	public String encuesta(Model model){
		model.addAttribute("titulo","Encuesta de satisfacción");
		return "fragments/encuesta";
	}
	
	@PostMapping("/encuesta")
	public String procesar() {
		return "redirect:principal";
	}

	@GetMapping("/QyR")
	public String QyR(Model model){
		Quejas quejas = new Quejas();
		model.addAttribute("titulo","Quejas y Reclamos");
		model.addAttribute("quejas", quejas);
		return "fragments/QyR";
	}
	
	@PostMapping("/QyR")
	public String solucion(@Valid Quejas quejas, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("titulo","Quejas y Reclamos");
			return "fragments/QyR";
		}
		quejasService.save(quejas);
		return "redirect:principal";
	}
	
	@GetMapping("/reservas")
	public String reservas(Model model) {
		model.addAttribute("titulo", "SM Spa");
		return "reservas";
	}
	
	@GetMapping("/pasarelas")
	public String pasarelas(Model model) {
		model.addAttribute("titulo", "SM Spa");
		return "pasarelas";
	}
	
}
