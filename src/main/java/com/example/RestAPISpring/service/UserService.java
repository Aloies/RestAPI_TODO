package com.example.RestAPISpring.service;

import com.example.RestAPISpring.entity.UserEntity;
import com.example.RestAPISpring.exception.UserAllReadyExistException;
import com.example.RestAPISpring.exception.UserNotFoundException;
import com.example.RestAPISpring.model.User;
import com.example.RestAPISpring.perository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity registration(UserEntity user) throws UserAllReadyExistException {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new UserAllReadyExistException("Пользователь с таким именем уже существует");
        }
        return userRepository.save(user);
    }

//    Метод возвращающий entity
   /* public UserEntity getOne (Long id) throws UserNotFoundException{
        UserEntity user = userRepository.findById(id).get();
        if(user==null){
            throw new UserNotFoundException("Пользователь с таким id не найде");
        }
        return user;
    }*/

//      метод возвращает модель entity
    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepository.findById(id).get();
        if(user==null){
            throw new UserNotFoundException("Пользователь с таким id не найден");
        }
        return User.toModel(user);
    }

    public Long delete(Long id){
        userRepository.deleteById(id);
        return id;
    }
}
