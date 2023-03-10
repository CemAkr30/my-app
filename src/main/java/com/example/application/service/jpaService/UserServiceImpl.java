package com.example.application.service.jpaService;

import com.example.application.dto.UserDTO;
import com.example.application.entites.User;
import com.example.application.genUtils.GenUtilMap;
import com.example.application.repositories.UserRepository;
import com.example.application.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User>  userList =  userRepository.findAll();
        return  new GenUtilMap<UserDTO,User>().pojoToListDto(new UserDTO(),userList);
    }

    @Override
    public List<UserDTO> findByIdentityNumberStartsWithIgnoreCase(String identityNumber) {
        return new GenUtilMap<UserDTO,User>().pojoToListDto(new UserDTO(),userRepository.findByIdentityNumberStartsWithIgnoreCase(identityNumber));
    }

    @Override
    public List<UserDTO> findBySurnameStartsWithIgnoreCase(String surname) {
        return new GenUtilMap<UserDTO,User>().pojoToListDto(new UserDTO(),userRepository.findBySurnameStartsWithIgnoreCase(surname));
    }

    @Override
    public List<UserDTO> findByNameStartsWithIgnoreCase(String name) {
        return new GenUtilMap<UserDTO,User>().pojoToListDto(new UserDTO(),userRepository.findByNameStartsWithIgnoreCase(name));
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUserAll() {
        userRepository.deleteAll();
    }


    //    @Override
//    public List<UserDTO> getAllUserBySurname(String surname) {
//        userRepository.searchBySurname(surname);
//        return null;
//    }
//    @Override
//    public List<UserDTO> getAllUserByName(String name) {
//        return new GenUtilMap<UserDTO,User>().pojoToListDto(new UserDTO(),userRepository.searchByName(name));
//    }
//    @Override
//    public List<UserDTO> getAllUserByIdentityNumber(String identityNumber) {
//        return new GenUtilMap<UserDTO,User>().pojoToListDto(new UserDTO(),userRepository.searchByIdentityNumber(identityNumber));
//    }
}
