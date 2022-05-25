package dio.bootcamp;

import dio.bootcamp.clientes.Cliente;
import dio.bootcamp.contas.ContaCorrente;
import dio.bootcamp.contas.ContaPoupanca;
import dio.bootcamp.enums.TiposDeContas;

public class Start {
    public static void main(String[] args) {
        Cliente rennan = new Cliente("Rennan", "65895314528", "98743214");
        rennan.addConta(new ContaCorrente());
        rennan.depositar(1000, TiposDeContas.CORRENTE);
        rennan.addConta(new ContaPoupanca());
        rennan.transferir(500, TiposDeContas.CORRENTE, rennan.getContaEspecifica(TiposDeContas.POUPANCA));

        rennan.imprimirExtrato(TiposDeContas.CORRENTE);
        rennan.imprimirExtrato(TiposDeContas.POUPANCA);

        /*Cliente rennan = new Cliente();
        rennan.setNome("Rennan");

        Conta corrente = new ContaCorrente(rennan);
        Conta poupanca = new ContaPoupança(rennan);

        corrente.depositar(100);
        corrente.transferir(100, poupanca);

        poupanca.imprimirExtrato();
        corrente.imprimirExtrato();*/
    }
}
