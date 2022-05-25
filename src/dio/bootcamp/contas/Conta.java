package dio.bootcamp.contas;

import dio.bootcamp.clientes.Cliente;
import dio.bootcamp.enums.TiposDeContas;
import dio.bootcamp.interfaces.IConta;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected TiposDeContas tipo = TiposDeContas.COMUM;
    protected int agencia;
    protected int numero;
    protected double saldo;

    public TiposDeContas getTipo() {
        return tipo;
    }


    public Conta() {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
    }

    private boolean saldoSuficiente(double valor) {
        if (valor > this.saldo || valor < 0) {
            System.out.println("Saldo Insuficiente");
            return false;
        }

        return true;
    }

    @Override
    public void sacar(double valor) {
        if (!this.saldoSuficiente(valor)) return;

        this.saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if (!this.saldoSuficiente(valor)) return;

        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfoBasica() {
        System.out.println("Agéncia: " + this.agencia);
        System.out.println("Número: " + this.numero);
        System.out.println("Saldo: " + this.saldo);
    }
}
