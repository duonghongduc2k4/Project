package com.codegym.project02.service.impl;

import com.codegym.project02.model.Ticket;
import com.codegym.project02.repository.ITicketRepository;
import com.codegym.project02.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService implements ITicketService {
    @Autowired
    private ITicketRepository iTicketRepository;
    @Override
    public Iterable<Ticket> findAll() {
        return iTicketRepository.findAll();
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return iTicketRepository.findById(id);
    }

    @Override
    public void save(Ticket ticket) {
        iTicketRepository.save(ticket);
    }

    @Override
    public void remove(Long id) {
        iTicketRepository.deleteById(id);
    }

    @Override
    public Page<Ticket> findAll(Pageable pageable) {
        return iTicketRepository.findAll(pageable);
    }
}
