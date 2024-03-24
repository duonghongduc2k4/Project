package com.codegym.project02.controller;

import com.codegym.project02.model.Account;
import com.codegym.project02.model.MovieTheater;
import com.codegym.project02.model.Ticket;
import com.codegym.project02.service.impl.AccountService;
import com.codegym.project02.service.impl.MovieTheaterService;
import com.codegym.project02.service.impl.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@RestController
@RequestMapping("/tickets")
public class AdminController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private MovieTheaterService movieTheaterService;

    @ModelAttribute("accounts")
    public Iterable<Account> findAllAcc() {
        return accountService.findAll();
    }
    @ModelAttribute("movieTheaters")
    public Iterable<MovieTheater> findAllMTheater() {
        return movieTheaterService.findAll();
    }

    @GetMapping()
    public ModelAndView listCustomers(@PageableDefault(value = 10) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/ticket/list");
        Page<Ticket> tickets = ticketService.findAll(pageable);
        modelAndView.addObject("tickets", tickets);
        return modelAndView;
    }
    @GetMapping("/{id}")
    public ModelAndView viewTicket(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/ticket/view");
        Optional<Ticket> ticket = ticketService.findById(id);
        modelAndView.addObject("ticket",ticket.get());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/ticket/create");
        modelAndView.addObject("ticket", new Ticket());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveTicket(@ModelAttribute("ticket") Ticket ticket) {
        ticketService.save(ticket);
        ModelAndView modelAndView = new ModelAndView("/ticket/create");
        modelAndView.addObject("ticket", new Ticket());
        modelAndView.addObject("message", "New ticket created successfully");
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Ticket> ticket = ticketService.findById(id);
            ModelAndView modelAndView = new ModelAndView("/ticket/update");
            modelAndView.addObject("ticket", ticket.get());
            return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView updateTicket(@ModelAttribute("ticket") Ticket ticket) {
        ticketService.save(ticket);
        ModelAndView modelAndView = new ModelAndView("/ticket/update");
        modelAndView.addObject("ticket", ticket);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Ticket> ticket = ticketService.findById(id);
            ModelAndView modelAndView = new ModelAndView("/ticket/delete");
            modelAndView.addObject("ticket", ticket.get());
            return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView deleteTicket(@ModelAttribute("ticket") Ticket ticket) {
        ModelAndView modelAndView = new ModelAndView( "redirect:/tickets");
        ticketService.remove(ticket.getId());
        return modelAndView;
    }
}
