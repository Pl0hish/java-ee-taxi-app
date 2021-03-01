package com.example.taxiAppEE.dao;

import com.example.taxiAppEE.dao.mapper.CarMapper;
import com.example.taxiAppEE.exception.CarException;
import com.example.taxiAppEE.model.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarDao implements Crud<Car> {

    private static CarDao instance;

    public static synchronized CarDao getInstance() throws SQLException {
        if (instance == null) {
            instance = new CarDao();
        }
        return instance;
    }

    public Optional<Car> findFirstByCategoryAndStatusAndSeatsGreaterThanEqual(Car.Category category, int seats) throws CarException {
        Connection connection = DataSource.getConnection();
        Car car = null;
        CarMapper carMapper = new CarMapper();
        String SELECT_FIRST_AVAILABLE_CAR_AND_SEATS = "SELECT * FROM cars WHERE status='AVAILABLE' AND category=? AND seats>=? LIMIT 1";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FIRST_AVAILABLE_CAR_AND_SEATS)) {
            preparedStatement.setString(1, category.toString());
            preparedStatement.setInt(2, seats);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                car = carMapper.extractFromResultSet(rs);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DataSource.closeConnection(connection);
        }

        return Optional.ofNullable(car);
    }

    @Override
    public void create(Car entity) {
        Connection connection = DataSource.getConnection();
    }

    @Override
    public Optional<Car> findById(int id) throws CarException {
        Connection connection = DataSource.getConnection();
        Car car = null;
        CarMapper carMapper = new CarMapper();
        String find = "SELECT * FROM cars WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(find)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                car = carMapper.extractFromResultSet(rs);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DataSource.closeConnection(connection);
        }

        return Optional.ofNullable(car);

    }

    @Override
    public List<Car> findAll() {
        Connection connection = DataSource.getConnection();
        List<Car> cars = null;
        CarMapper userMapper = new CarMapper();
        String SELECT_ALL_CARS = "SELECT * FROM cars";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CARS)) {
            ResultSet rs = preparedStatement.executeQuery();
            cars = new ArrayList<>();
            while (rs.next()) {
                cars.add(userMapper.extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DataSource.closeConnection(connection);
        }
        return cars;
    }

    @Override
    public void update(Car car) {
        Connection connection = DataSource.getConnection();
        String UPDATE_CAR_STATUS = "UPDATE cars SET status=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CAR_STATUS)) {
            preparedStatement.setString(1, car.getStatus()
                    .toString());
            preparedStatement.setInt(2, car.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DataSource.closeConnection(connection);
        }

    }
}
