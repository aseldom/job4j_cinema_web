package ru.job4j.cinemaweb.service;

import org.springframework.stereotype.Service;
import ru.job4j.cinemaweb.model.Ticket;
import ru.job4j.cinemaweb.repository.TicketRepository;

import java.util.Optional;

@Service
public class SimpleTicketService implements TicketRepository {

    private final TicketRepository ticketRepository;

    public SimpleTicketService(TicketRepository sql2oTicketRepository) {
        this.ticketRepository = sql2oTicketRepository;
    }

    @Override
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Optional<Ticket> findById(int id) {
        return ticketRepository.findById(id);
    }
}