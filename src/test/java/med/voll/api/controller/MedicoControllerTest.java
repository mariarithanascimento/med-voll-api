package med.voll.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import med.voll.api.domain.endereco.DadosEndereco;
import med.voll.api.domain.endereco.Endereco;
import med.voll.api.domain.medicos.DadosCadastroMedico;
import med.voll.api.domain.medicos.Especialidade;
import med.voll.api.domain.medicos.Medico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class MedicoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@BeforeEach
	public void setUp() {
	}

	@Test
	public void testCadastrarMedico() throws Exception {

		DadosCadastroMedico dadosCadastroMedico = new DadosCadastroMedico(
				"Lucas Howard",
				"lucas@medvoll.com",
				"34999999999",
				"333333",
				Especialidade.CARDIOLOGIA,
				new DadosEndereco("rua 1", "bairro", "12345678", "Uberlandia", "MG", "complemento", "1"));

		String jsonDados = objectMapper.writeValueAsString(dadosCadastroMedico);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
						.post("/medicos")
						.contentType(MediaType.APPLICATION_JSON)
						.content(jsonDados))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andReturn();

		String responseContent = result.getResponse().getContentAsString();

	}

	@Test
	public void testListagemMedicos() throws Exception {
		List<Medico> medicosGet = new ArrayList<>();

		Page<Medico> pageMedicosGet = new PageImpl<>(medicosGet);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
						.get("/medicos")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();

		String responseContent = result.getResponse().getContentAsString();
	}
}

