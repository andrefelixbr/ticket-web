package br.com.feltex.ticketweb.modelo;


import br.com.feltex.ticketweb.constants.enums.Perfil;
import br.com.feltex.ticketweb.constants.enums.StatusUsuario;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
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

}
