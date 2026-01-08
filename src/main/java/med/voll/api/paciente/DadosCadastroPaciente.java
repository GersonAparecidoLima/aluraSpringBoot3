package med.voll.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroPaciente(
		
	
	@NotBlank // Campo obrigatório e não pode ser apenas espaços	
    String nome, 
    
    @NotBlank 
    @Email // Valida se o formato é de um e-mail real
    String email, 
    
    @NotBlank
    String telefone,
    
    @NotBlank 
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}") // Valida o formato 000.000.000-00
    String cpf, 
    
    @NotBlank
    @Valid // Valida também os campos dentro do objeto Endereco
    DadosEndereco endereco) {
}