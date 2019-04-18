package com.lqp.ncbook.interceptor;

import com.lqp.ncbook.model.Ticket;
import com.lqp.ncbook.model.User;
import com.lqp.ncbook.service.TicketService;
import com.lqp.ncbook.service.UserService;
import com.lqp.ncbook.utils.ConcurrentUtils;
import com.lqp.ncbook.utils.CookieUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class HostInfoInterceptor implements HandlerInterceptor {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    /**
     * 为注入host信息
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String t = CookieUtils.getCookie("t",request);
        if(!StringUtils.isEmpty(t))
        {
            Ticket ticket = ticketService.getTicket(t);
            if(ticket!=null && ticket.getExpiredAt().after(new Date()))
            {
                User host = userService.getUser(ticket.getUserId());
                ConcurrentUtils.setHost(host);
            }
        }
        return true;
    }
}
