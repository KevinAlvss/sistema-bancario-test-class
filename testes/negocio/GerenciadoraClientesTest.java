package negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GerenciadoraClientesTest {
	private GerenciadoraClientes gerClientes;
	private int idCliente1 = 1;
	private int idCliente2 = 2;
	
	@Before
	public void setUp() {
		Cliente cliente01 = new Cliente(idCliente1,"João",31,"joao@gmail.com",1,true);
		Cliente cliente02 = new Cliente(idCliente2,"Maria",34,"maria@gmail.com",1,true);
		
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
	}
	
	@After
	public void tearDown() {
		gerClientes.limpa();
	}
	
	@Test
	public void testPesquisaCliente() {
		Cliente cliente = gerClientes.pesquisaCliente(idCliente1);
		
		assertThat(cliente.getId(),is(idCliente1));
	}
	
	@Test
	public void testRemoveCliente() {
		boolean clienteRemovido = gerClientes.removeCliente(idCliente2);
		
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCliente2));
		
	}
}
