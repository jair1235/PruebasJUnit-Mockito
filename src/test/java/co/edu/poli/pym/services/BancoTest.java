package co.edu.poli.pym.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import ch.qos.logback.core.net.server.Client;
import co.edu.poli.pym.entities.Cliente;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class BancoTest {
	@Test
	//consulta caja vacio
	void consultaCaja() {
		Banco banco = new Banco();
		
		assertEquals(0, banco.consultarCajaTotal());
	}
	//consulta caja seteo de clientes con saldo
	@Test
	void consultaCajaCliente() {
		
		Banco banco = new Banco();
		banco.setSaldoTotal(0);
		Cliente cliente = new Cliente();
		Cliente cliente2 = new Cliente();
		cliente.setNombre("jonas");
		cliente.setSaldo(200);
		cliente2.setNombre("jair");
		cliente2.setSaldo(200);
		banco.createCliente(cliente);
		banco.createCliente(cliente2);
		
		assertEquals(400, banco.consultarCajaTotal());
	}
	@Test
	void createCliente() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente();
		cliente.setNombre("jair");
		cliente.setSaldo(0);
		
		assertEquals(true, banco.createCliente(cliente));
	}
	@Test
	void createClienteRepetido() {
		Banco banco = new Banco();
		Cliente cliente = new Cliente();
		Cliente cliente1 = new Cliente();

		cliente.setNombre("jair");
		cliente.setSaldo(0);
		cliente1.setNombre("jair");
		cliente1.setSaldo(1000);
		banco.createCliente(cliente);
		assertFalse(banco.createCliente(cliente1));//da error porque el nombre está repetido 
	}
	//test con mockito
	@Test
	void testCajaTotalConMocks() {
		Banco banco = new Banco();
		Cliente cliente = mock(Cliente.class);
		Cliente cliente2 = mock(Cliente.class);
		when(cliente.getNombre()).thenReturn("jair");
		when(cliente.getSaldo()).thenReturn(3000.0);
		
		
		when(cliente2.getNombre()).thenReturn("juan");
		when(cliente2.getSaldo()).thenReturn(300.0);
		banco.createCliente(cliente);
		banco.createCliente(cliente2);
		
		assertEquals(3300, banco.consultarCajaTotal());
		verify(cliente).getSaldo();//verifica bien la interaccion que realizo getsaldo con el mock
		verify(cliente2).getSaldo();//-mismo caso
	}
	
}
