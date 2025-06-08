package com.example.SpringFirstProject.services;

import com.example.SpringFirstProject.entities.User;
import com.example.SpringFirstProject.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public User findById(Integer id) {
            if(userRepository.existsById(id))
                return userRepository.findById(id).get();
            return null;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User addUser(User user){
        return userRepository.save(user);
    }
    public String deleteUser(Integer id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return id+ " was deleted";
        }
         return id+ " was not found";
    }

    public String updateUserName(int id, String name){
        if(userRepository.existsById(id)){
            User user = userRepository.findById(id).get();
            user.setName(name);
            userRepository.save(user);
            return id+ " was updated";
        }
        return id+ " was not found";
    }

    public String updateUser(int id, User user){
        if(userRepository.existsById(id)){
            User user_ = userRepository.findById(id).get();
            user.setUserId(user_.getUserId());
            userRepository.save(user);
            return id+ " was updated";
        }
        return id+ " was not found";
    }

    public List<User> findByName(String name){
        return userRepository.findByName(name);
    }
    public List<User> selectUserByEmail(String email){
        return userRepository.selectUserByEmail(email);
    }
    public List<User> selectUserByAddress(String address){
        return userRepository.findUserByAddress(address);
    }

//    public List<User> selectUserByAddressAndSort(String address, Sort sort){
//        return  userRepository.findUserByAddressAndSort(address, sort);
//    }
}
