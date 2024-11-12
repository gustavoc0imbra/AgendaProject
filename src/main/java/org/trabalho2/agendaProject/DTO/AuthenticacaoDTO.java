package org.trabalho2.agendaProject.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link org.trabalho2.agendaProject.Model.Usuario}
 */
public record AuthenticacaoDTO(
        @NotNull(message = "Email Vazia") @Email(message = "Não é um Email") String email,
        @NotNull(message = "Senha Vazia") @NotBlank(message = "Senha Vazia") String senha) implements Serializable {
}