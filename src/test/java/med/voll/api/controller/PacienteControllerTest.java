package med.voll.api.controller;

import med.voll.api.domain.endereco.DadosEndereco;
import med.voll.api.domain.pacientes.DadosAtualizaPacientes;
import med.voll.api.domain.pacientes.DadosCadastroPaciente;
import med.voll.api.domain.pacientes.DadosDetalhamentoPaciente;
import med.voll.api.domain.pacientes.DadosListagemPaciente;
import med.voll.api.domain.pacientes.Paciente;
import med.voll.api.domain.pacientes.PacienteRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PacienteControllerTest {

	private PacienteController pacienteController;

	@Mock
	private PacienteRepository pacienteRepository;

	@Mock
	private UriComponentsBuilder uriBuilder;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		pacienteRepository = Mockito.mock(PacienteRepository.class);
		pacienteController = new PacienteController(pacienteRepository);
	}

	@Test
	public void testCadastroPaciente() {
		DadosCadastroPaciente dados = new DadosCadastroPaciente("Leticia Mendes", "leticia@gmail.com", "11999996666", "12345678912",
				new DadosEndereco("rua", "bairro", "12345678", "São Paulo", "SP", "COMPLEMENTO", "123"));
	Paciente paciente = new Paciente();
		when(pacienteRepository.save(any(Paciente.class))).thenReturn(paciente);

		ResponseEntity result = pacienteController.cadastrarPacientes(dados, UriComponentsBuilder.newInstance());

		assertEquals(HttpStatus.CREATED, result.getStatusCode());
	}

	@Test
	public void testListagem() {
		PacienteRepository repository = mock(PacienteRepository.class);
		Page<Paciente> pacientes = mock(Page.class);
		Pageable paginacao = mock(Pageable.class);

		when(repository.findAllByAtivoTrue(paginacao)).thenReturn(pacientes);

		PacienteController controller = new PacienteController(repository);

		ResponseEntity response = controller.listagem(paginacao);

		assertEquals(ResponseEntity.ok(pacientes.map(DadosListagemPaciente::new)), response);
	}

	@Test
	public void testAtualizar() {
		PacienteRepository repository = mock(PacienteRepository.class);
		DadosAtualizaPacientes dados = new DadosAtualizaPacientes(1L, "Leticia Souza", "11999999999",
				new DadosEndereco("rua", "bairro", "12345678", "São Paulo", "SP", "complemento", "321"));

		Paciente paciente = mock(Paciente.class);

		when(repository.getReferenceById(Mockito.anyLong())).thenReturn(paciente);

		PacienteController controller = new PacienteController(repository);

		ResponseEntity response = controller.atualizar(dados);

		assertEquals(ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente)), response);
	}
}
