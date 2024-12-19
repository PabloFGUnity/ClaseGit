package com.api.springCrud.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.springCrud.models.UserModel;
import com.api.springCrud.repositories.IUserRepository;

@Service
public class UserService {
    @Autowired  //inyectar depependencias que tengamos
    IUserRepository userRepository;

    public ArrayList<UserModel> getUsers() {
        return (ArrayList<UserModel>) userRepository.findAll(); //método que está ya includo en JpaRepository
    }

    //Guardar un nuevo usuario
    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    //Obtener un usuario a partir de un filtro de un ID que me pasan como parámetro
    public Optional<UserModel> getById(Long id) {
        return userRepository.findById(id);
    }

    //Actualizar usuario
    public UserModel updateById(UserModel requestUser, Long id) {
        UserModel user = userRepository.findById(id).get();
        
        if(user.equals(null)) {
            return null;
        }   else {
            user.setFirstName(requestUser.getFirstName());
            user.setLastName(requestUser.getLastName());
            user.setEmail(requestUser.getEmail());

            return user;
        }
    }

    //Borra usuario
    public Boolean deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}