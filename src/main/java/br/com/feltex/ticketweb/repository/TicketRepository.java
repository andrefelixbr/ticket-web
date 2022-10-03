package br.com.feltex.ticketweb.repository;

import br.com.feltex.ticketweb.modelo.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}