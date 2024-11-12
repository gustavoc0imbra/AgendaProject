package org.trabalho2.agendaProject.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.trabalho2.agendaProject.Enum.TipoAcessoEnum;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private Integer id;
    private String email;
    private String senha;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dtCadastro;
    private TipoAcessoEnum tipoAcesso;

    @OneToMany(mappedBy = "usuario")
    private List<Agenda> agendas;

}
