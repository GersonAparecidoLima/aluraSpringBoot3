package med.voll.api.medico;

import io.micrometer.common.lang.NonNull;
import med.voll.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico( 
		@NonNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
	
}
