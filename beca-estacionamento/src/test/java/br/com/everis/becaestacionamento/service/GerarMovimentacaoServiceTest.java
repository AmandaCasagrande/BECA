//package br.com.everis.becaestacionamento.service;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import br.com.everis.becaestacionamento.dto.MovimentacoesDTO;
//import br.com.everis.becaestacionamento.dto.form.GerarMovimentacaoForm;
//import br.com.everis.becaestacionamento.entities.MovimentacoesEntity;
//import br.com.everis.becaestacionamento.entities.VeiculoEntity;
//import br.com.everis.becaestacionamento.repository.MarcaRepository;
//import br.com.everis.becaestacionamento.repository.MovimentacoesRepository;
//import javassist.NotFoundException;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class GerarMovimentacaoServiceTest {
//
//	@Autowired
//	private MarcaRepository marcaRepository;
//	
//	@Autowired
//	private MovimentacoesRepository movRepository;
//	
//	@MockBean
//	private GerarMovimentacaoService gerarMovService;
//	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	
////	private String placa;
////	private Integer ano;
////	private String cor;
//	
//	@Test
//	void deveInserirUmaMovimentacao() throws Exception{
//		GerarMovimentacaoForm gerarMov = new GerarMovimentacaoForm();
//		
//		//gerarMovService.gerarEntrada(gerarMov, uriBuilder)
//	
//	}
//
//	@Test
//	void deveInserirUmaMovimentacaoSemModelo() {
//		
//	}
//	
//	
//}
