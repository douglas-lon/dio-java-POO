package dio.bootcamp.contas;

import dio.bootcamp.enums.TiposDeContas;

public class ContaPoupanca extends Conta {

    public ContaPoupanca() {
        super();
        super.tipo = TiposDeContas.POUPANCA;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("--- Extrato Conta Poupança ---");
        super.imprimirInfoBasica();
    }
}
