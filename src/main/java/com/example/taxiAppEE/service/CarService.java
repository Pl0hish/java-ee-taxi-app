package com.example.taxiAppEE.service;

import com.example.taxiAppEE.dao.CarDao;
import com.example.taxiAppEE.exception.CarException;
import com.example.taxiAppEE.model.Car;

import java.sql.SQLException;
import java.util.List;

public class CarService {

    private final CarDao carDao;
    private static CarService instance;

    public static synchronized CarService getInstance() throws SQLException {
        if (instance == null) {
            instance = new CarService(CarDao.getInstance());
        }
        return instance;
    }

    public CarService(CarDao carDao) {
        this.carDao=carDao;
    }

    public List<Car> getCars() {
        return carDao.findAll();
    }

//    public Page<Car> getPaginated(int pageNo, String sortField, String sortDirection){
//        Sort sort=sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
//                Sort.by(sortField).ascending() : Sort.by(sortField).descending();
//
//        Pageable pageable=PageRequest.of(pageNo - 1, PAGE_SIZE, sort);
//        return carDao.findAll(pageable);
//    }

    public Car findFirstByCategory(Car.Category category, int seats) throws CarException {
        return carDao.findFirstByCategoryAndStatusAndSeatsGreaterThanEqual(category, seats)
                .orElseThrow(() -> new CarException("No car AVAILABLE for given category and seats amount"));
    }

    public void create(Car car) {
        carDao.create(car);
    }

    public Car findById(int id) throws CarException{
        return carDao.findById(id).orElseThrow(() -> new CarException("No car with such id"));
    }


    public void updateStatus(int carId) {
        Car car=new Car();
        car.setId(carId);
        car.setStatus(Car.Status.ACTIVE);
        carDao.update(car);
    }
}
