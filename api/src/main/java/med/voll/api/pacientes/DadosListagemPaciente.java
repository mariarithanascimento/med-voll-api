package med.voll.api.pacientes;

import med.voll.api.endereco.Endereco;

public record DadosListagemPaciente(String nome, String email, String cpf) {
	public DadosListagemPaciente(Paciente paciente){
		this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
	}
}
