package com.example.taxiAppEE.dao.mapper;

import com.example.taxiAppEE.model.Car;
import com.example.taxiAppEE.model.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements ObjectMapper<Order> {
    @Override
    public Order extractFromResultSet(ResultSet rs) throws SQLException {
        Order order=new Order();

        order.setId(rs.getInt("id"));
        order.setCarId(rs.getInt("car_id"));
        order.setUserId(rs.getInt("user_id"));

        order.setDate(rs.getTimestamp("date").toLocalDateTime());
        order.setDepartureAddress(rs.getString("departure_address"));
        order.setDestinationAddress(rs.getString("destination_address"));

        order.setDistance(rs.getInt("distance"));
        order.setPassengers(rs.getInt("passengers"));
        order.setPrice(rs.getDouble("price"));
        order.setPrice(rs.getDouble("price"));
        order.setCarCategory(Car.Category.getCategory(rs.getString("car_category")));

        return order;
    }
}
