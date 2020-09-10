package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.*;
import com.upgrad.hirewheels.entities.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("initServiceImpl")
public class InitServiceImpl implements InitService {



    @Override
    public void init() {
        insertIntoRole();
        createAdmin();
        insertVehicleCategory();
        insertVehicleSubCategory();
        insertFuelType();
        insertCity();
        insertLocation();
        System.out.println("executed role");
    }

    public void insertIntoRole() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        RoleDAO roleDAO = (RoleDAO) context.getBean("roleDAO");
        Role userRole = new Role("User");
        Role adminRole = new Role("Admin");
        roleDAO.save(userRole);
        roleDAO.save(adminRole);
        System.out.println("hello");
    }

    /*private UsersDAO usersDAO = (UsersDAO) context.getBean("usersDAO");

        private VehicleSubCategoryDAO vehicleSubCategoryDAO = (VehicleSubCategoryDAO)
                context.getBean("vehicleSubCategoryDAO");
        private FuelTypeDAO fuelTypeDAO = (FuelTypeDAO)context.getBean("fuelTypeDAO");
        private CityDAO cityDAO = (CityDAO) context.getBean("cityDAO");
        private LocationDAO locationDAO = (LocationDAO) context.getBean("locationDAO");*/

    public void createAdmin() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        RoleDAO roleDAO = (RoleDAO) context.getBean("roleDAO");
        UsersDAO usersDAO = (UsersDAO) context.getBean("usersDAO");
        Users admin = new Users("Admin","Admin","admin@123","upgrad@gmail.com",
                "9999999999", roleDAO.findByName("Admin"),10000.00);
        usersDAO.save(admin);
    }

    public void insertVehicleCategory() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        VehicleCategoryDAO vehicleCategoryDAO = (VehicleCategoryDAO) context.getBean("vehicleCategoryDAO");
        VehicleCategory car = new VehicleCategory("Car");
        VehicleCategory bike = new VehicleCategory("Bike");
        vehicleCategoryDAO.save(car);
        vehicleCategoryDAO.save(bike);
    }

    public void insertVehicleSubCategory() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        VehicleSubCategoryDAO vehicleSubCategoryDAO = (VehicleSubCategoryDAO)
                context.getBean("vehicleSubCategoryDAO");
        VehicleCategoryDAO vehicleCategoryDAO = (VehicleCategoryDAO) context.getBean("vehicleCategoryDAO");
        VehicleSubCategory suv = new VehicleSubCategory("Suv",300.00,
                vehicleCategoryDAO.findByName("Car"));
        vehicleSubCategoryDAO.save(suv);
        VehicleSubCategory sedan = new VehicleSubCategory("Sedan",350.00,
                vehicleCategoryDAO.findByName("Car"));
        vehicleSubCategoryDAO.save(sedan);
        VehicleSubCategory hatchBack = new VehicleSubCategory("HatchBack",250.00,
                vehicleCategoryDAO.findByName("Car"));
        vehicleSubCategoryDAO.save(hatchBack);
        VehicleSubCategory cruiser = new VehicleSubCategory("Cruiser",200.00,
                vehicleCategoryDAO.findByName("Bike"));
        vehicleSubCategoryDAO.save(cruiser);
        VehicleSubCategory dirtBike = new VehicleSubCategory("DirtBike",200.00,
                vehicleCategoryDAO.findByName("Bike"));
        vehicleSubCategoryDAO.save(dirtBike);
        VehicleSubCategory sportsBike = new VehicleSubCategory("SportsBike",150.00,
                vehicleCategoryDAO.findByName("Bike"));
        vehicleSubCategoryDAO.save(sportsBike);

    }

    public void insertFuelType() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        FuelTypeDAO fuelTypeDAO = (FuelTypeDAO)context.getBean("fuelTypeDAO");
        FuelType petrol = new FuelType("Petrol");
        fuelTypeDAO.save(petrol);
        FuelType diesel = new FuelType("Diesel");
        fuelTypeDAO.save(diesel);
    }

    public void insertCity() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        CityDAO cityDAO = (CityDAO) context.getBean("cityDAO");
        City city = new City("Mumbai");
        cityDAO.save(city);
    }

    public void insertLocation() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        CityDAO cityDAO = (CityDAO) context.getBean("cityDAO");
        LocationDAO locationDAO = (LocationDAO) context.getBean("locationDAO");
        Location location1 = new Location("Worli", "Dr E Moses Rd, Worli Naka, Upper Worli",
                "400018",cityDAO.findByName("Mumbai"));
        locationDAO.save(location1);
        Location location2 = new Location("Chembur", "Optic Complex",
                "400019",cityDAO.findByName("Mumbai"));
        locationDAO.save(location2);
        Location location3 = new Location("Powai", "Hiranandani Towers",
                "400020",cityDAO.findByName("Mumbai"));
        locationDAO.save(location3);
    }
}