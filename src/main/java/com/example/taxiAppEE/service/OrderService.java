package com.example.taxiAppEE.service;

import com.example.taxiAppEE.dao.OrderDao;
import com.example.taxiAppEE.exception.CarException;
import com.example.taxiAppEE.model.Car;
import com.example.taxiAppEE.model.Order;
import com.example.taxiAppEE.model.User;
import com.example.taxiAppEE.model.dto.OrderDTO;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class OrderService {

    private final OrderDao orderDao;
    private final CarService carService;
    private final UserService userService;

    private static OrderService instance;

    public static synchronized OrderService getInstance() throws SQLException {
        if (instance == null) {
            instance = new OrderService(OrderDao.getInstance(),
                    CarService.getInstance(),
                    UserService.getInstance());
        }
        return instance;
    }

    public void saveOrder(Order order) {
        order.setDate(LocalDateTime.now());
        userService.updateSpentMoney(order.getUserId(), order.getPrice());
        carService.updateStatus(order.getCarId());
        orderDao.create(order);
    }

    public OrderService(OrderDao orderDao, CarService carService, UserService userService) {
        this.orderDao=orderDao;
        this.carService=carService;
        this.userService=userService;
    }

    public List<Order> getOrders() {
        return orderDao.findAll();
    }

//    public Page<Order> getPaginated(int pageNo, String sortField, String sortDirection){
//        Sort sort=sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
//                Sort.by(sortField).ascending() : Sort.by(sortField).descending();
//
//        Pageable pageable=PageRequest.of(pageNo - 1, PAGE_SIZE, sort);
//        return orderDao.findAll(pageable);
//    }

    public Order createOrder(OrderDTO orderDTO, User user) throws CarException {
        Car car = carService.findFirstByCategory(orderDTO.getCategory(), orderDTO.getPassengers());

        double spentMoney = user.getSpentMoney();
        orderDTO.setDistance();

        return new Order(
                        orderDTO.getDepartureAddress(),
                        orderDTO.getDestinationAddress(),
                        orderDTO.getPassengers(),
                        orderDTO.getDistance(),
                        orderDTO.getPrice(),
                        spentMoney,
                        car.getId(),
                        user.getId(),
                        orderDTO.getCategory());
    }



    public List<Order> getOrdersByUserId(int id){
        return orderDao.findTop5ByUserIdOrderByDateDesc(id);
    }

    public List<Order> getAllOrdersByUserId(int id){
        return orderDao.findAllByUserId(id);
    }

    public List<Order> getAllOrdersByCarId(int id) {
        return orderDao.findAllByCarId(id);
    }
}
