package br.com.feltex.ticketweb.modelo;

import br.com.feltex.ticketweb.constants.enums.Departamento;
import br.com.feltex.ticketweb.constants.enums.Prioridade;
import br.com.feltex.ticketweb.constants.enums.StatusTicket;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Ticket ticket = (Ticket) o;
        return id != null && Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
