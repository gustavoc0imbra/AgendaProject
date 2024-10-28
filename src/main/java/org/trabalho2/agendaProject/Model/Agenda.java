package org.trabalho2.agendaProject.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.processing.Pattern;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Agenda {
    @Id
    @GeneratedValue
    private Integer id;

    private String descricao;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date data;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Servico servico;

    private boolean status;

    @ManyToOne
    private Funcionario funcionario;

    @ManyToOne
    private Usuario usuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico()
    {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
