package med.voll.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.medico.DadosCadastroMedico;

@RestController
@RequestMapping("medicos")
public class MedicoController {
	
	//Essa é uma das maneiras de recebermos dados nos métodos dos controllers: 
	//declarando como string e anotando como request body, no caso de requisições do tipo post
	//@PostMapping
	//public void cadastrar(@RequestBody String json) {
	//	System.out.println(json);
	//}
	
	@PostMapping
	public void cadastrar(@RequestBody DadosCadastroMedico dados) {
		System.out.println(dados);
	}

}
