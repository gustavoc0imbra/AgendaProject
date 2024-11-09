package org.trabalho2.agendaProject.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    private String telefone;

    private String email;

    @OneToOne
    private Endereco endereco;

    private Double salario;

    @OneToMany(mappedBy = "funcionario")
    private List<Agenda> agendas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
