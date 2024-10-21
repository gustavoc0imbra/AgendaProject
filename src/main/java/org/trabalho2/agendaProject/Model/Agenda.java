package org.trabalho2.agendaProject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import org.hibernate.annotations.processing.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Agenda {
    @Id
    @GeneratedValue
    private Integer id;

    private String descricao;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date data;

    @OneToOne
    private Cliente cliente;

    @OneToOne
    private Servico servico;

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
}
