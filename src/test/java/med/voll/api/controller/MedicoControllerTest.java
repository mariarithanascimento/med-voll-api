package med.voll.api.controller;

import med.voll.api.domain.endereco.DadosEndereco;
import med.voll.api.domain.medicos.DadosCadastroMedico;
import med.voll.api.domain.medicos.Especialidade;
import med.voll.api.domain.medicos.Medico;
import med.voll.api.domain.medicos.MedicoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class MedicoControllerTest {

	@Mock
	private MedicoController medicoController;
	private MedicoRepository medicoRepository;

	@BeforeEach
	public void setUp() {
		medicoRepository = Mockito.mock(MedicoRepository.class);
		medicoController = new MedicoController(medicoRepository);
	}

	@Test
	public void testCadastrarMedico() {
		DadosCadastroMedico dados = new DadosCadastroMedico("Fernando Morais", "fernandomorais@medvoll.com", "34999999999", "555555",
				Especialidade.CARDIOLOGIA,
				new DadosEndereco("rua 1", "bairro", "12345678", "Uberlandia", "MG", "complemento", "1"));
		Medico medico = new Medico();
		when(medicoRepository.save(any(Medico.class))).thenReturn(medico);

		ResponseEntity result = medicoController.cadastrar(dados, UriComponentsBuilder.newInstance());

		assertEquals(HttpStatus.CREATED, result.getStatusCode());
	}

	@Test
	public void testExcluirMedico() {
		Long id = 1L;
		Medico medico = new Medico();
		when(medicoRepository.getReferenceById(id)).thenReturn(medico);

		ResponseEntity result = medicoController.excluir(id);

		assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
	}

	@Test
	public void testDetalharMedico() {
		Long id = 1L;
		Medico medico = new Medico();
		when(medicoRepository.getReferenceById(id)).thenReturn(medico);

		ResponseEntity result = medicoController.detalhar(id);

		assertEquals(HttpStatus.OK, result.getStatusCode());

	}
}