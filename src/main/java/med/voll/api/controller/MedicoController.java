package med.voll.api.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired; // ADICIONE ESTE IMPORT
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;           // Importe a sua entidade Medico
import med.voll.api.medico.MedicoRepository; // Importe o seu Repository
import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {
	
	//Essa é uma das maneiras de recebermos dados nos métodos dos controllers: 
	//declarando como string e anotando como request body, no caso de requisições do tipo post
	//@PostMapping
	//public void cadastrar(@RequestBody String json) {
	//	System.out.println(json);
	//}
	
	
	
	
    @Autowired 
    private MedicoRepository repository;
	
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico dados) {
        // Agora o dado sai do console e vai para o Banco de Dados!
        repository.save(new Medico(dados));
    }
	
    @GetMapping
    public List<DadosListagemMedico> listar() {
        return repository.findAll().stream()
                .map(DadosListagemMedico::new)
                .toList();
    }
}