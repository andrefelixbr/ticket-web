package br.com.feltex.ticketweb.modelo;

import br.com.feltex.ticketweb.constants.enums.Departamento;
import br.com.feltex.ticketweb.constants.enums.Prioridade;
import br.com.feltex.ticketweb.constants.enums.StatusTicket;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Departamento departamento;
    @Column(nullable = false)
    private Prioridade prioridade;
    @Column(nullable = false)
    private StatusTicket status;
    private byte[] arquivos;
}
