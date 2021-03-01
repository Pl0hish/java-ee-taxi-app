package com.example.taxiAppEE.dao;

import com.example.taxiAppEE.dao.mapper.UserMapper;
import com.example.taxiAppEE.exception.UserException;
import com.example.taxiAppEE.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements Crud<User> {

    private static UserDao instance;

    public static synchronized UserDao getInstance() throws SQLException {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    public Optional<User> findUserByEmail(String email) {
        Connection connection = DataSource.getConnection();

        User user = null;
        String find = "SELECT * FROM users WHERE email=?";
        try (PreparedStatement preparedStatement=connection.prepareStatement(find)) {
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            UserMapper userMapper = new UserMapper();

            while (rs.next()) {
                user = userMapper.extractFromResultSet(rs);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DataSource.closeConnection(connection);
        }

            return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findById(int id) throws UserException {
        Connection connection = DataSource.getConnection();
        User user = null;
        UserMapper userMapper=new UserMapper();
        String find = "SELECT * FROM users WHERE id=?";
        try (PreparedStatement preparedStatement=connection.prepareStatement(find)) {
            preparedStatement.setInt(1, id);
            ResultSet rs=preparedStatement.executeQuery();

            while (rs.next()) {
                user=userMapper.extractFromResultSet(rs);
            }

        } catch (Exception e) {
            user = null;
            System.out.println(e.getMessage());
        } finally {
            DataSource.closeConnection(connection);
        }

        return Optional.ofNullable(user);
    }

    @Override
    public void create(User entity) {
        Connection connection = DataSource.getConnection();
        String insert = "INSERT INTO users (email, first_name, last_name, password, role, spent_money) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement=connection.prepareStatement(insert)) {
            preparedStatement.setString(1, entity.getEmail());
            preparedStatement.setString(2, entity.getFirstName());
            preparedStatement.setString(3, entity.getLastName());
            preparedStatement.setString(4, entity.getPassword());
            preparedStatement.setString(5, entity.getRole().toString());
            preparedStatement.setDouble(6, entity.getSpentMoney());

            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            DataSource.closeConnection(connection);
        }
    }

    @Override
    public List<User> findAll() {
        Connection connection = DataSource.getConnection();
        List<User> users;
        UserMapper userMapper=new UserMapper();
        String SELECT_ALL_USERS = "SELECT * FROM users";
        try (PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet rs=preparedStatement.executeQuery();
            users=new ArrayList<>();
            while (rs.next()) {
                users.add(userMapper.extractFromResultSet(rs));
            }
        } catch (Exception e) {
            users = null;
            System.out.println(e.getMessage());
        } finally {
            DataSource.closeConnection(connection);
        }
        return users;
    }

    @Override
    public void update(User user) {
        Connection connection = DataSource.getConnection();
        String UPDATE_USER_MONEY = "UPDATE users SET spent_money=spent_money + ? WHERE id=?";
        try (PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_USER_MONEY)){
            preparedStatement.setDouble(1, user.getSpentMoney());
            preparedStatement.setInt(2, user.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DataSource.closeConnection(connection);
        }
    }
}
