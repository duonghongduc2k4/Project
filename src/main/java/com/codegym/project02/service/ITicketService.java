package com.codegym.project02.service;


import com.codegym.project02.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITicketService extends IGenerateService<Ticket>{
    Page<Ticket> findAll(Pageable pageable);
}
