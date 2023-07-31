package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medicos.DadosListagemMedico;
import med.voll.api.pacientes.DadosCadastroPaciente;
import med.voll.api.pacientes.DadosListagemPaciente;
import med.voll.api.pacientes.Paciente;
import med.voll.api.pacientes.PacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private PacienteRepository repository;
	@PostMapping
	@Transactional
	public void cadastrarPacientes(@RequestBody @Valid DadosCadastroPaciente dados){
		repository.save(new Paciente(dados));
		}
	@GetMapping
	public Page<DadosListagemPaciente> listagem(@PageableDefault(size = 1, sort = {"nome"}) Pageable paginacao){
		return repository.findAll(paginacao).map(DadosListagemPaciente::new);
	}
	}

