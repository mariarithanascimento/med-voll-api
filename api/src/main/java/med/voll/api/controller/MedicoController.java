package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medicos.DadosCadastroMedico;
import med.voll.api.medicos.DadosListagemMedico;
import med.voll.api.medicos.Medico;
import med.voll.api.medicos.MedicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("medicos")
public class MedicoController {

	@Autowired
	private MedicoRepository repository;
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
		repository.save(new Medico(dados));
	}

	@GetMapping
	public Page<DadosListagemMedico> listagem(Pageable paginacao){
		return repository.findAll(paginacao).map(DadosListagemMedico::new);
	}

}
