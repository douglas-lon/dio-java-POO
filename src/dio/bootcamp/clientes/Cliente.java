package dio.bootcamp.clientes;

import dio.bootcamp.contas.Conta;
import dio.bootcamp.enums.TiposDeContas;
import dio.bootcamp.interfaces.IConta;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    private List<Conta> contas = new ArrayList<>();

    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    private boolean contaCriada() {
        if (this.contas.isEmpty()) {
            System.out.println("Este Cliente Ainda não tem contas criadas");
            return false;
        }

        return true;
    }


    public void imprimirExtrato(TiposDeContas tipo) {
        if (!this.contaCriada()) return;

        for (Conta conta: this.contas) {
            if (conta.getTipo() == tipo) {
                System.out.println("=== Extrato ===");
                System.out.println("Titular: " + this.nome);
                conta.imprimirExtrato();
            }
        }
    }

    public void sacar(double valor, TiposDeContas minhaConta) {
        if (!this.contaCriada()) return;

        for (Conta conta: this.contas) {
            if (conta.getTipo() == minhaConta) {
                conta.sacar(valor);
            }
        }
    }

    public void depositar(double valor, TiposDeContas minhaConta) {
        if (!this.contaCriada()) return;

        for (Conta conta: this.contas) {
            if (conta.getTipo() == minhaConta) {
                conta.depositar(valor);
            }
        }
    }

    public void transferir(double valor, TiposDeContas minhaConta, IConta contaDestino) {
        if (!this.contaCriada()) return;

        for (Conta conta: this.contas) {
            if (conta.getTipo() == minhaConta) {
                conta.transferir(valor, contaDestino);
            }
        }
    }

    public Conta getContaEspecifica(TiposDeContas tipo) {
        if (!this.contaCriada()) return null;

        for (Conta conta: this.contas) {
            if (conta.getTipo() == tipo) {
                return conta;
            }
        }

        return null;
    }

    public List<Conta> getContas() {
        return contas;
    }


    public void addConta(Conta conta) {
        this.contas.add(conta);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
