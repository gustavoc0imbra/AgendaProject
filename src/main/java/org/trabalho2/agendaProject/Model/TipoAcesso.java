package org.trabalho2.agendaProject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.trabalho2.agendaProject.Enum.TipoAcessoEnum;

@Getter
@Setter
@Entity
public class TipoAcesso {

    @Id
    @GeneratedValue
    private Integer id;
    private TipoAcessoEnum tipoAcessoEnum;
}

