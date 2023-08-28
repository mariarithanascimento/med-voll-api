package med.voll.api.domain.medicos;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosAtualizaMedico(

		@NotNull
		Long id,

		String telefone,

		String nome,

		DadosEndereco endereco
) {
}
