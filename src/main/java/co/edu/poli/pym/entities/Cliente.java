package co.edu.poli.pym.entities;



public class Cliente {
	private String nombre;
	private double saldo;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Cliente() {
	}
	//metodo para  consulta de saldo
	public double consultarSaldo() {
		return saldo;
	}
	public boolean consignarDinero(double dineroAConsignar) {
		if(dineroAConsignar>0) {
			saldo+=dineroAConsignar;
			return true;
		}else {
			return false;
		} 
		
	}
	public boolean retirarDinero(double cantRetirar) {
		if(cantRetirar<=saldo&&cantRetirar>0) {
			saldo-=cantRetirar;
			
			return true;
		}else {
			return false;
		}
	}
}
