package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medicos.DadosAtualizaMedico;
import med.voll.api.medicos.DadosDetalhamentoMedico;
import med.voll.api.medicos.DadosListagemMedico;
import med.voll.api.pacientes.DadosAtualizaPacientes;
import med.voll.api.pacientes.DadosCadastroPaciente;
import med.voll.api.pacientes.DadosDetalhamentoPaciente;
import med.voll.api.pacientes.DadosListagemPaciente;
import med.voll.api.pacientes.Paciente;
import med.voll.api.pacientes.PacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private PacienteRepository repository;
	@PostMapping
	@Transactional
	public ResponseEntity cadastrarPacientes(@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriBuilder){
		var paciente = new Paciente(dados);
		repository.save(paciente);
		var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));

		}
	@GetMapping
	public ResponseEntity<Page<DadosListagemPaciente>> listagem(@PageableDefault(size = 5, sort = {"nome"}) Pageable paginacao){
		var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
		return ResponseEntity.ok(page);
	}

	@PutMapping
	@Transactional
	public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaPacientes dados){
		var paciente = repository.getReferenceById(dados.id());
		paciente.atualizarInformacoes(dados);
		return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity excluir(@PathVariable Long id){
		var paciente = repository.getReferenceById(id);
		paciente.excluir();
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity detalhar(@PathVariable Long id) {
		var paciente = repository.getReferenceById(id);
		return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
	}
	}

