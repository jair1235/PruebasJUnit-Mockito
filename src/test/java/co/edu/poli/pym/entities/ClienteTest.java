package co.edu.poli.pym.entities;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {
	//testeo de consignar dinero
	@Test
	void testConsignarDineroPositivo(){
		Cliente cliente = new Cliente();
		cliente.setSaldo(0);
		
		cliente.consignarDinero(100);
		
		
		assertEquals(100, cliente.consultarSaldo());
	}
	@Test
	void testConsignarNegativo() {
		Cliente cliente = new Cliente();
		cliente.setSaldo(0);
				
		/*assertEquals(false,cliente.consignarDinero(-100));//al ser el valor esperado false, porque no ejecutó la condicion, la prueba pasa
		 */
		assertFalse(cliente.consignarDinero(-100));//se usa este porque se quiere saber si es falso, no comparar
	}
	@Test
	void testConsignarCero() {
		Cliente cliente = new Cliente();
		cliente.setSaldo(0);
		
		
		assertFalse(cliente.consignarDinero(0));//para trabajar errores, el valor esperado es false, lo que hace que cuando sea false este caso, la prueba pase
		assertEquals(0, cliente.getSaldo());//el saldo tampoco debería cambiar
	}
	
	//retirar más de esperado
	@Test
	void testRetirarDinero() {
		Cliente cliente = new Cliente();
		cliente.setSaldo(100);
		
		assertFalse(cliente.retirarDinero(1000));//retorna falso porq no se completa la operación
		assertEquals(100, cliente.consultarSaldo());//rsaldo no cambia
	}
	//retirar 0
	@Test
	void testRetirarCero() {
		Cliente cliente = new Cliente();
		cliente.setSaldo(0);
		assertFalse(cliente.retirarDinero(0));//bota error pq no se puede retirar 0, tiene que ser mayor
		assertEquals(0, cliente.consultarSaldo());
	}
	@Test
	void testRetirarDineroNegativo() {
		Cliente cliente = new Cliente();
		cliente.setSaldo(100);
		
		assertFalse(cliente.retirarDinero(-1000));//retorna falso porq no se completa la operación
		assertEquals(100, cliente.consultarSaldo());//saldo no cambia
	}
}
