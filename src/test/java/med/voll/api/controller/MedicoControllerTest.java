package med.voll.api.controller;

import med.voll.api.domain.endereco.DadosEndereco;
import med.voll.api.domain.medicos.DadosAtualizaMedico;
import med.voll.api.domain.medicos.DadosCadastroMedico;
import med.voll.api.domain.medicos.DadosDetalhamentoMedico;
import med.voll.api.domain.medicos.DadosListagemMedico;
import med.voll.api.domain.medicos.Especialidade;
import med.voll.api.domain.medicos.Medico;
import med.voll.api.domain.medicos.MedicoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriBuilder;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(MockitoExtension.class)
public class MedicoControllerTest {
	@InjectMocks
	MedicoController controller;

	@Mock
	private MedicoRepository repository;

	MockMvc mockMvc;

	private DadosAtualizaMedico dadosAtualizaMedico;
	private DadosCadastroMedico dadosCadastroMedico;
	private DadosDetalhamentoMedico dadosDetalhamentoMedico;
	private DadosListagemMedico dadosListagemMedico;
	private Especialidade especialidade;
	private Medico medico;
	private DadosEndereco dadosEndereco;
	private UriBuilder uri;
	private MockMultipartFile file;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.alwaysDo(print())
				.build();
		file = new MockMultipartFile(
				"file",
				"ControllerTest.text",
				MediaType.TEXT_PLAIN_VALUE,
				"This is a Controller Test".getBytes()
		);
		dadosCadastroMedico = new DadosCadastroMedico("Maria", "maria@medvoll.com", "11955667788", "111111", Especialidade.CARDIOLOGIA, dadosEndereco);
		especialidade = Especialidade.CARDIOLOGIA;
		dadosEndereco = new DadosEndereco("rua 1", "bairro", "12345678", "São Paulo", "SP", "complemento", "1");
	}
}
