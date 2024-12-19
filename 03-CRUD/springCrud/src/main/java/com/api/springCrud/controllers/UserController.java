package com.api.springCrud.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.springCrud.models.UserModel;
import com.api.springCrud.services.UserService;

@RestController
@RequestMapping("/user") //definimos la ruta.
public class UserController {

    @Autowired
    private UserService userService;

    //@GetMapping("/getusers");  //respondemos a localhost/user/getusers
    @GetMapping //respondemos con la url localhost/user
    public ArrayList<UserModel> getUsers() {
        
        //@RequestBody vamos a pasarle info en el Body del mensaje, ... opcion b pasarle params en la url
        return this.userService.getUsers();

    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user) {
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/{id}") //Respondemos a localhost/user/1
    public Optional<UserModel> getUserById(@PathVariable("id") Long id){
        return this.userService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel requestUser, @PathVariable("id") Long id) {
        return this.userService.updateById(requestUser, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        boolean ok = this.userService.deleteUser(id);
        if (ok) {
            return "Usuario con id =" + id + " borrado correctamente"; 
        }   else {
            return "Usuario con id =" + id + " no se pudo borrar";
        }
    }
    
    


}
