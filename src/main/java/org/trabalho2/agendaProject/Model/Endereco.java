package org.trabalho2.agendaProject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue
    private Integer id;
    private String cep;
    private String logradouro;
    private String complemento;
    private Integer numero;
    private String bairro;
    private String localidade;
    private String uf;
    private String estado;
    @OneToOne
    private Cliente cliente;

}
