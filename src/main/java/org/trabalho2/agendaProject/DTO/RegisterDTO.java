package org.trabalho2.agendaProject.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.trabalho2.agendaProject.Enum.TipoAcessoEnum;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link org.trabalho2.agendaProject.Model.Usuario}
 */
public record RegisterDTO(@Email(message = "Isso não é um email") @NotBlank(message = "Email está vazio") String email,
                          @NotBlank(message = "Senha está vazio") String senha,
                          @NotNull(message = "Acesso está vazio") TipoAcessoEnum tipoAcesso) implements Serializable {
}