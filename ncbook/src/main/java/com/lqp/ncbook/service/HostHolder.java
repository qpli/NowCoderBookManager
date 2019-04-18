package com.lqp.ncbook.service;

import com.lqp.ncbook.model.User;
import com.lqp.ncbook.utils.ConcurrentUtils;
import org.springframework.stereotype.Service;

@Service
public class HostHolder {
    public User getUser()
    {
        return ConcurrentUtils.getHost();
    }
}
