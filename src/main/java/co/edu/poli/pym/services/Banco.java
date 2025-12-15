package co.edu.poli.pym.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.boot.internal.Extends;

import co.edu.poli.pym.entities.Cliente;

public class Banco {
	double saldoTotal;
	private HashMap<String, Cliente>listaClientes = new HashMap<String, Cliente>();
	private List<String>	operaciones = new ArrayList<String>();
	public boolean createCliente(Cliente cliente) {
		if (cliente.getNombre()==null ||listaClientes.containsKey(cliente.getNombre())) {
			return false;
		} else {
			listaClientes.put(cliente.getNombre(), cliente);
		return true;
		}
	};
	
	public double getSaldoTotal() {
		return saldoTotal;
	}

	public void setSaldoTotal(double saldoTotal) {
		this.saldoTotal = saldoTotal;
	}

	public double consultarCajaTotal() {
		saldoTotal=0;
		for (Cliente cliente : listaClientes.values()) {
			saldoTotal+=cliente.getSaldo();
		}
		return saldoTotal;
	}
	//operaciones
	public void operacionConsigno(Cliente cliente, double monto) {
		if(cliente!=null&&monto>0)
		operaciones.add("Cliente: "+cliente.getNombre()+" consignó "+monto);
	}
	public void operacionRetiro(Cliente cliente, double monto) {
		if(cliente!=null&&monto>0)
		operaciones.add("Cliente: "+cliente.getNombre()+" retiró "+monto);
	}
	
}
