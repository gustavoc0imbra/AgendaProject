package org.trabalho2.agendaProject.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.trabalho2.agendaProject.Enum.TipoAcessoEnum;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;
    private String email;
    private String senha;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDateTime dtCadastro;

    @OneToOne
    private TipoAcesso tipoAcesso;
    @OneToMany(mappedBy = "usuario")
    private List<Agenda> agendas;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.tipoAcesso.getTipoAcessoEnum() == TipoAcessoEnum.ADMNISTRADOR){
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        }else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
