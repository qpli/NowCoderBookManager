package com.lqp.ncbook.service;

import com.lqp.ncbook.dao.TicketDao;
import com.lqp.ncbook.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    private TicketDao ticketDao;

    public void addTicket(Ticket t)
    {
        ticketDao.addTicket(t);
    }

    public Ticket getTicket(int uid)
    {
        return ticketDao.selectByUserId(uid);
    }

    public Ticket getTicket(String t)
    {
        return ticketDao.selectByTicket(t);
    }

    public void delectTicket(int tid)
    {
        ticketDao.deleteTicketById(tid);
    }

    public void delectTicket(String t)
    {
        ticketDao.deleteTicket(t);
    }
}
