package com.example.taxiAppEE.dao.mapper;

import com.example.taxiAppEE.model.Car;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements ObjectMapper<Car> {
    @Override
    public Car extractFromResultSet(ResultSet rs) throws SQLException {
        Car car=new Car();

        car.setId(rs.getInt("id"));
        car.setSeats(rs.getInt("seats"));
        car.setKmPrice(rs.getInt("km_price"));
        car.setDriver(rs.getString("driver"));
        car.setCategory(rs.getString("driver"));
        car.setStatus(rs.getString("status"));

        return car;
    }
}
