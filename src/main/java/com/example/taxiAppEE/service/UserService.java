package com.example.taxiAppEE.service;

import com.example.taxiAppEE.dao.UserDao;
import com.example.taxiAppEE.exception.UserException;
import com.example.taxiAppEE.model.User;
import com.example.taxiAppEE.model.dto.UserDTO;

import java.sql.SQLException;

import static com.example.taxiAppEE.model.Role.ROLE_USER;

public class UserService {

    private final UserDao userDao;
    private static UserService instance;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public static synchronized UserService getInstance() throws SQLException {
        if (instance == null) {
            instance = new UserService(UserDao.getInstance());
        }
        return instance;
    }


    public UserService(UserDao userDao) {
        this.userDao=userDao;
    }

//    public Page<User> getPaginated(int pageNo, String sortField, String sortDirection) {
//        Sort sort=sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
//                Sort.by(sortField).ascending() : Sort.by(sortField).descending();
//
//        Pageable pageable=PageRequest.of(pageNo - 1, PAGE_SIZE, sort);
//        return userDao.findAll(pageable);
//    }

    public void updateSpentMoney(int userId, double price) {
        User user=new User();
        user.setId(userId);
        user.setSpentMoney(price);
        userDao.update(user);
    }

    public void create(UserDTO userDTO) throws RuntimeException, UserException {

        if (userDao.findUserByEmail(userDTO.getEmail())
                .isPresent()) {
            throw new UserException("User already exists");
        }

        userDao.create(new User(
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                ROLE_USER
        ));
    }

    public User findUserById(int id) throws UserException {
        return userDao.findById(id).orElseThrow(() -> new UserException("No user with such id"));

    }

    public User findUserByEmail(String email) throws UserException {
        return userDao.findUserByEmail(email).orElseThrow(() -> new UserException("No user with such email"));
    }
}
