package med.voll.api.medicos;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;
import med.voll.api.endereco.Endereco;

public record DadosAtualizaMedico(
		@NotNull
		Long id,
		String telefone,

		String nome,
		DadosEndereco endereco
) {
}
