package com.upgrad.hirewheels;

import com.upgrad.hirewheels.dao.UsersDAO;
import com.upgrad.hirewheels.entities.Users;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String args[]) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UsersDAO usersDAO = (UsersDAO) context.getBean("usersDAO");
        Users user = new Users("Vineetha", "Alluri", "vineetha29",
                "vineethaalluri29@gmail.com", "9100446388", 1, 10000  );
        usersDAO.save(user);
        List<Users> allUsers = usersDAO.findAll();
        for (Users userValue: allUsers) {
            System.out.println(userValue.toString());
        }
    }
}
