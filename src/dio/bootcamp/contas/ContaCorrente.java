package dio.bootcamp.contas;

import dio.bootcamp.clientes.Cliente;
import dio.bootcamp.enums.TiposDeContas;

public class ContaCorrente extends Conta {

    public ContaCorrente() {
        super();
        super.tipo = TiposDeContas.CORRENTE;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("--- Extrato Conta Corrente ---");
        super.imprimirInfoBasica();
    }
}
