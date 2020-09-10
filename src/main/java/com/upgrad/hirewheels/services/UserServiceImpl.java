package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.UsersDAO;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.entities.City;
import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.exceptions.UnauthorizedUserException;
import com.upgrad.hirewheels.exceptions.UserAlreadyExistsException;
import com.upgrad.hirewheels.exceptions.UserIsNotRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

    @Autowired
    @Qualifier("usersDAO")
    UsersDAO usersDAO;

    @Override
    public Users createUsers(Users users) throws UserAlreadyExistsException{
        Boolean uniqueEmail = false;
        Boolean uniqueMobile = false;
        Users userByEmail = usersDAO.findByEmail(users.getEmail());
        if(userByEmail == null )
            uniqueEmail = true;
        else
            throw new UserAlreadyExistsException("Email Already Exists");
        Users userByMobileNumber = usersDAO.findByMobileNumber(
                users.getMobileNumber());
        if(userByMobileNumber == null)
            uniqueMobile = true;
        else
            throw new UserAlreadyExistsException("Mobile Number Already Exists");
        if(uniqueEmail && uniqueMobile)
            usersDAO.save(users);
        return users;
    }

    @Override
    public Users getUser(String email, String password) throws UserIsNotRegisteredException, UnauthorizedUserException {
        Users userByEmail = usersDAO.findByEmail(email);
        if(userByEmail == null)
            throw new UserIsNotRegisteredException("User Not Registered");
        if(userByEmail.getPassword().equals(password))
            return userByEmail;
        else
            throw new UnauthorizedUserException("User Unauthorized");
    }


}
