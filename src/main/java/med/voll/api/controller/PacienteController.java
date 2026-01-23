package med.voll.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.paciente.DadosCadastroPaciente;

@RestController
@RequestMapping("pacientes")

public class PacienteController {

	@PostMapping
	//@Valid 
	public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
      System.out.println("Dados recebidos do paciente: " + dados);
	}

}
