package com.upgrad.hirewheels;

import com.upgrad.hirewheels.dao.BookingDAO;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.services.InitService;
import com.upgrad.hirewheels.services.InitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String args[]) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        InitService initService = (InitService)context.getBean("initServiceImpl");
        initService.init();
    }
}
