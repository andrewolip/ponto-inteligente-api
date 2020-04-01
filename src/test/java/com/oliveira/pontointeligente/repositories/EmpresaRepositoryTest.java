package com.oliveira.pontointeligente.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.oliveira.pontointeligente.api.entities.Empresa;
import com.oliveira.pontointeligente.api.repositories.EmpresaRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmpresaRepositoryTest {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	private static final String CNPJ = "51463645000100";
	
	@BeforeEach
	public void setUp() throws Exception {
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("Empresa Test");
		empresa.setCnpj(CNPJ);
		this.empresaRepository.save(empresa);
	}
	
	@AfterEach
	public final void tearDown() {
		this.empresaRepository.deleteAll();
	}
	
	public void testBuscaPorCnpj() {
		Empresa empresa = this.empresaRepository.findByCnpj(CNPJ);
		
		assertEquals(CNPJ, empresa.getCnpj());
	}
}
