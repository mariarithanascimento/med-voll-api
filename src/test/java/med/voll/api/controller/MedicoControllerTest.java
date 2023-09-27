package med.voll.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import med.voll.api.domain.endereco.DadosEndereco;
import med.voll.api.domain.endereco.Endereco;
import med.voll.api.domain.medicos.DadosCadastroMedico;
import med.voll.api.domain.medicos.Especialidade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class MedicoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@BeforeEach
	public void setUp() {
		// Qualquer inicialização necessária antes dos testes
	}

	@Test
	public void testCadastrarMedico() throws Exception {
		// Crie um objeto de dados para o teste
		DadosCadastroMedico dadosCadastroMedico = new DadosCadastroMedico(
				"Pedro Howard",
				"pedro@medvoll.com",
				"34999999999",
				"222222",
				Especialidade.CARDIOLOGIA,
				new DadosEndereco("rua 1", "bairro", "12345678", "Uberlandia", "MG", "complemento", "1"));

		// Converte o objeto para JSON
		String jsonDados = objectMapper.writeValueAsString(dadosCadastroMedico);

		// Execute a requisição POST para cadastrar o médico
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
						.post("/medicos")
						.contentType(MediaType.APPLICATION_JSON)
						.content(jsonDados))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andReturn();

		// Verifique se a resposta está correta, por exemplo, você pode verificar o corpo da resposta JSON
		String responseContent = result.getResponse().getContentAsString();

	}
}

