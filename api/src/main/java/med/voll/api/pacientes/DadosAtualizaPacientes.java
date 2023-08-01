package med.voll.api.pacientes;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;
import med.voll.api.endereco.Endereco;

public record DadosAtualizaPacientes(

		@NotNull
		Long id,
		String nome,
		String telefone,
		DadosEndereco endereco) {
}
