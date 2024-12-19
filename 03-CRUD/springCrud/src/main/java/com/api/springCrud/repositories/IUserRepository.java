package com.api.springCrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.springCrud.models.UserModel;

//Clase para hacer consultar sobre la BBDD
@Repository
public interface  IUserRepository extends JpaRepository<UserModel, Long>{

}
