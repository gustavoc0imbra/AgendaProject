package org.trabalho2.agendaProject.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.trabalho2.agendaProject.DTO.AuthenticacaoDTO;
import org.trabalho2.agendaProject.DTO.LoginResponseDTO;
import org.trabalho2.agendaProject.DTO.RegisterDTO;
import org.trabalho2.agendaProject.Infra.Security.TokenService;
import org.trabalho2.agendaProject.Model.Usuario;
import org.trabalho2.agendaProject.Repository.UsuarioRepository;
import org.trabalho2.agendaProject.Service.UsuarioService;

import java.time.LocalDateTime;

@Controller
@RequestMapping("login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<Object> login(@RequestBody @Valid AuthenticacaoDTO authenticacaoDTO){
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticacaoDTO.email(), authenticacaoDTO.senha());
        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO){
        if (this.usuarioRepository.findByEmail(registerDTO.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.senha());

        Usuario newUser = new Usuario(null, registerDTO.email(), encryptedPassword, LocalDateTime.now(),
                registerDTO.tipoAcesso(), null);

        this.usuarioRepository.save(newUser);
        return ResponseEntity.ok().build();
    }
}
