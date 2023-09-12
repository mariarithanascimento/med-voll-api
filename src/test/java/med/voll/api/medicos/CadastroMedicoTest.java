package med.voll.api.medicos;

import com.fasterxml.jackson.databind.ObjectMapper;
import med.voll.api.controller.MedicoController;
import med.voll.api.domain.endereco.DadosEndereco;
import med.voll.api.domain.medicos.DadosCadastroMedico;
import med.voll.api.domain.medicos.MedicoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static med.voll.api.domain.medicos.Especialidade.ORTOPEDIA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MedicoController.class)
public class CadastroMedicoTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MedicoRepository repository;
	@BeforeEach
	public void setUp() {

	}
	@Test
	public void testCadastrarMedico() throws Exception {

		DadosCadastroMedico dados = new DadosCadastroMedico(
				"Lexie Grey",
				"grey@medvoll.com",
				"11999998888",
				"222222",
				ORTOPEDIA,
				new DadosEndereco("rua 1", "bairro", "12345678", "Brasilia", "DF", "complemento", "1")
		);

		ResultActions resultActions = mockMvc.perform(post("/medicos")
				.contentType("application/json")
				.content(asJsonString(dados)));

		resultActions.andExpect(status().isCreated())
				.andExpect(jsonPath("$.nome").value(dados.nome()))
				.andExpect(jsonPath("$.crm").value(dados.crm()));
	}

	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	}

