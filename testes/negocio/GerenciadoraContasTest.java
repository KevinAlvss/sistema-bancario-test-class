package negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraContasTest {
	private GerenciadoraContas gerContas;
	
	@Test
	public void testTransfereValor() {
		int idConta1 = 1;
		int idConta2 = 2;
		
		ContaCorrente conta1 = new ContaCorrente(idConta1,200,true);
		ContaCorrente conta2 = new ContaCorrente(idConta2,0,true);
		
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta1);
		contasDoBanco.add(conta2);
		
		gerContas = new GerenciadoraContas(contasDoBanco);
		
		boolean sucesso = gerContas.transfereValor(idConta1, 100, idConta2);
		
		assertTrue(sucesso);
		assertThat(conta1.getSaldo(), is(100.0));
		assertThat(conta1.getSaldo(), is(100.0));
	}
}
