package br.com.feltex.ticketweb.modelo;


import br.com.feltex.ticketweb.constants.enums.Perfil;
import br.com.feltex.ticketweb.constants.enums.StatusUsuario;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;
    @Column(unique = true)
    private String email;
    private String sobrenome;
    @Column(nullable = false)
    private Perfil perfil;
    @Column(nullable = false)
    private StatusUsuario status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Usuario usuario = (Usuario) o;
        return id != null && Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
