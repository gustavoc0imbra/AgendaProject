package org.trabalho2.agendaProject.Model;

import jakarta.persistence.*;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@ToString
public class Cliente implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String telefone;
    private String email;

    @OneToOne
    private Endereco endereco;

    @OneToMany(mappedBy = "cliente")
    private List<Agenda> agendamentos;

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

    public List<Agenda> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agenda> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
