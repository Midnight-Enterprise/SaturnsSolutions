package com.saturnssolutions.TakeMoney.services;

import com.saturnssolutions.TakeMoney.models.UserModel;
import com.saturnssolutions.TakeMoney.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserModel> listAllUsers() {
        return userRepository.findAll();
    }

    public void saveUser(UserModel user) {
        userRepository.save(user);
    }

    public UserModel getUser (Integer id) {
        return userRepository.findById(id).get();
    }

    public void deleteUser (Integer id) {
        userRepository.deleteById(id);
    }

    public List<Object[]> getTotal() {
        return userRepository.findAllByTotal();
    }
}
