package com.example.application.bootstrap;


import com.example.application.dto.UserDTO;
import com.example.application.entites.User;
import com.example.application.genUtils.GenUtilMap;
import com.example.application.service.UserService;
import com.example.application.validations.UserValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Component
@Slf4j
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final UserService userService;

    private int counter=0;


    public DataLoader(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
         userService.deleteUserAll();
         getLoaderData();
         log.info("Loading Bootstrap Data");
    }

    @Transactional
    void getLoaderData() {
        userService.saveUser(getCreateUser("Ali", "Yılmaz", "12345678901"));
        userService.saveUser(getCreateUser("Veli", "Özdemir", "12345678902"));
        userService.saveUser(getCreateUser("Ayşe", "Kara", "12345678903"));
        userService.saveUser(getCreateUser("Fatma", "Nur", "12345678904"));
        userService.saveUser(getCreateUser("Mehmet", "Ülker", "12345678905"));
        userService.saveUser(getCreateUser("Özge", "Tutuş", "12345678906"));
        userService.saveUser(getCreateUser("Merve", "Kaya", "12345678907"));
        userService.saveUser(getCreateUser("Ahmet", "Kara", "12345678908"));
        userService.saveUser(getCreateUser("Zeynep", "Kara", "12345678909"));
        userService.saveUser(getCreateUser("Cem", "Akar", "12345678910"));
    }

    private UserDTO getCreateUser(String username, String surname, String identityNumber){
        return new GenUtilMap<UserDTO,User>().pojoToDto(new UserDTO(),User.builder()
                .name(username)
                .surname(surname)
                .identityNumber(identityNumber)
                .build());
    }
}
