package org.trabalho2.agendaProject.Controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link org.trabalho2.agendaProject.Model.Usuario}
 */
public record AuthenticacaoDTO(
        @NotNull(message = "Email Vazia") @Email(message = "Não é um Email", regexp = "@") @NotEmpty(message = "Email Vazia") String email,
        @NotNull(message = "Senha Vazia") @NotBlank(message = "Senha Vazia") String senha) implements Serializable {
}