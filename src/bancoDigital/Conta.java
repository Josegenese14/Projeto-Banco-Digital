package bancoDigital;

import conta.Iconta;
import usuario.Cliente;

public abstract class Conta implements Iconta {
	
	private static final int AGENCIA_PADRAO= 1;
	private static int SEQUENCIAL= 1;
	
	protected int agencia;
	protected int numeroConta;
	protected double saldo;
	protected Cliente cliente;
	
	
	public Conta(Cliente cliente) {
		
		this.agencia = AGENCIA_PADRAO;
		this.numeroConta = SEQUENCIAL++;
		this.cliente = cliente;
		
	}

	
	public int getAgencia() {
		return agencia;
	}

	public int getConta() {
		return numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	
	@Override
	public void sacar(double valor) {
		
		saldo -= valor;
		
	}

	@Override
	public void depositar(double valor) {
		
		saldo += valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		
		this.sacar(valor);
		contaDestino.depositar(valor);
		
	}
	
	protected void imprimirInfosComuns() {
		
		System.out.println(String.format("Titular: %s", cliente.getNomeCliente()));
		System.out.println(String.format("Agencia: %d", agencia));
		System.out.println(String.format("Numero da conta: %d", numeroConta));
		System.out.println(String.format("Saldo: %.2f", saldo));
		
	}
	
	



	
}
