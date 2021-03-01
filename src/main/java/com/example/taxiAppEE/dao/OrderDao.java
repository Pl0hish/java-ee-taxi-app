package com.example.taxiAppEE.dao;

import com.example.taxiAppEE.dao.mapper.OrderMapper;
import com.example.taxiAppEE.exception.OrderException;
import com.example.taxiAppEE.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderDao implements Crud<Order> {

    private static OrderDao instance;

    public static synchronized OrderDao getInstance() throws SQLException {
        if (instance == null) {
            instance = new OrderDao();
        }
        return instance;
    }

    public List<Order> findTop5ByUserIdOrderByDateDesc(int id) {
        String SELECT_TOP_5_BY_USER_ID_ORDER_BY_DATE = "SELECT o.*, c.category as car_category FROM orders as o, cars as c WHERE o.car_id = c.id and o.user_id=? ORDER BY date DESC LIMIT 5";
        return getOrdersByIds(id, SELECT_TOP_5_BY_USER_ID_ORDER_BY_DATE);
    }

    public List<Order> findAllByUserId(int id) {
        String SELECT_ALL_ORDERS = "SELECT o.*, c.category as car_category FROM orders as o, cars as c WHERE o.car_id = c.id and o.user_id=?";
        return getOrdersByIds(id, SELECT_ALL_ORDERS);
    }


    public List<Order> findAllByCarId(int id) {
        String SELECT_ALL_ORDERS = "SELECT o.*, c.category as car_category FROM orders as o, cars as c WHERE o.car_id = c.id and o.car_id=?";
        return getOrdersByIds(id, SELECT_ALL_ORDERS);
    }

    public List<Order> getOrdersByIds(int id, String SELECT) {
        Connection connection = DataSource.getConnection();
        List<Order> orders = null;
        OrderMapper orderMapper = new OrderMapper();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            orders = new ArrayList<>();

            while (rs.next()) {
                orders.add(orderMapper.extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DataSource.closeConnection(connection);
        }
        return orders;
    }

    @Override
    public void create(Order order) {
        Connection connection = DataSource.getConnection();
        String insert = "INSERT INTO orders (date," +
                " departure_address," +
                " destination_address," +
                " distance," +
                " passengers," +
                " price," +
                " car_id," +
                " user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setTimestamp(1, order.getDate());
            preparedStatement.setString(2, order.getDepartureAddress());
            preparedStatement.setString(3, order.getDestinationAddress());
            preparedStatement.setInt(4, order.getDistance());
            preparedStatement.setInt(5, order.getPassengers());
            preparedStatement.setDouble(6, order.getPrice());
            preparedStatement.setInt(7, order.getCarId());
            preparedStatement.setInt(8, order.getUserId());

            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            DataSource.closeConnection(connection);
        }

    }

    @Override
    public Optional<Order> findById(int id) throws OrderException {
        Connection connection = DataSource.getConnection();
        Order order = null;
        OrderMapper orderMapper = new OrderMapper();
        String find = "SELECT o.*, c.category as car_category FROM orders as o, cars as c WHERE o.car_id = c.id and o.id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(find)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                order = orderMapper.extractFromResultSet(rs);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DataSource.closeConnection(connection);
        }

        return Optional.ofNullable(order);
    }

    @Override
    public List<Order> findAll() {
        Connection connection = DataSource.getConnection();
        List<Order> orders = null;
        OrderMapper userMapper = new OrderMapper();
        String SELECT_ALL_ORDERS = "SELECT o.*, c.category as car_category FROM orders as o, cars as c WHERE o.car_id = c.id and";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERS)) {
            ResultSet rs = preparedStatement.executeQuery();
            orders = new ArrayList<>();
            while (rs.next()) {
                orders.add(userMapper.extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DataSource.closeConnection(connection);
        }
        return orders;
    }

    @Override
    public void update(Order entity) {
        Connection connection = DataSource.getConnection();
    }
}
