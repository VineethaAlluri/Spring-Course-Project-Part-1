package com.upgrad.hirewheels;

import com.upgrad.hirewheels.dao.CityDAO;
import com.upgrad.hirewheels.dao.RoleDAO;
import com.upgrad.hirewheels.dao.UsersDAO;
import com.upgrad.hirewheels.entities.City;
import com.upgrad.hirewheels.entities.Role;
import com.upgrad.hirewheels.entities.Users;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String args[]) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UsersDAO usersDAO = (UsersDAO) context.getBean("usersDAO");
        RoleDAO roleDAO = (RoleDAO) context.getBean("roleDAO") ;


        Role adminRole = new Role("Admin");
        Role userRole = new Role("User");
        roleDAO.save(adminRole);
        roleDAO.save(userRole);


        Users user = new Users("Vineetha", "Alluri", "vineetha29",
                "vineethaalluri29@gmail.com", "9100446388", userRole, 10000  );
        usersDAO.save(user);


        Users admin = new Users("Admin", "Admin", "9999999999", "upgrad@gmail.com", "admin@123",
                adminRole, 10000);
        usersDAO.save(admin);


        List<Users> allUsers = usersDAO.findAll();
        for (Users userValue: allUsers) {
            System.out.println(userValue);
        }


        Users data = usersDAO.findByRole(adminRole);
        System.out.println(data);

        City city = new City("Hyderabad");
        CityDAO cityDAO= (CityDAO) context.getBean("cityDAO");
        cityDAO.save(city);

    }
}
