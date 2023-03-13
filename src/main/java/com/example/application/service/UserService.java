package com.example.application.service;

import com.example.application.dto.UserDTO;
import com.example.application.entites.User;
import com.example.application.service.baseCrudService.CrudService;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Set;


//extends CrudService<User, Long>
public interface UserService {

    List<UserDTO> getAllUser();
    List<UserDTO> findByIdentityNumberStartsWithIgnoreCase(String identityNumber);
    List<UserDTO> findBySurnameStartsWithIgnoreCase(String surname);
    List<UserDTO> findByNameStartsWithIgnoreCase(String name);
    UserDTO saveUser(UserDTO userDTO);
    void deleteUserAll();

    boolean deleteUsers(Set<UserDTO> userDTO);

    boolean randomUserCreate();
}
