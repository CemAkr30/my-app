package com.example.application.service;

import com.example.application.dto.UserDTO;
import com.example.application.entites.User;
import com.example.application.service.baseCrudService.CrudService;

import java.util.List;


//extends CrudService<User, Long>
public interface UserService {

    List<UserDTO> getAllUser();

//    List<UserDTO> getAllUserBySurname(String surname);
//
//    List<UserDTO> getAllUserByName(String name);
//
//    List<UserDTO> getAllUserByIdentityNumber(String identityNumber);

    List<UserDTO> findByIdentityNumberStartsWithIgnoreCase(String identityNumber);
    List<UserDTO> findBySurnameStartsWithIgnoreCase(String surname);
    List<UserDTO> findByNameStartsWithIgnoreCase(String name);

    void saveUser(User user);

    void deleteUserAll();
}
