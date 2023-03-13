package com.example.application.validations;

import com.example.application.dto.UserDTO;
import com.example.application.exception.DogrulamaException;
import com.example.application.exception.UserException;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class UserValidation  implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;
        if(!userDTO.getIdentityNumber().matches("^[0-9]{11}")){
//            errors.reject("E00001", "Tc Kimlik numarası 11 hane dışında olamaz!!!");
            throw new UserException("Tc Kimlik numarası 11 haneden küçük veya harf barındıramaz...");
        }
        try {
            control(userDTO.getIdentityNumber());
        } catch (DogrulamaException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    boolean control(String tckn) throws DogrulamaException {

        if(tckn.length() == 11){ //contains aynı elemandan varmı
            if(tckn.charAt(0) !='0'){
                int cift = 0;
                int tek = 0;
                int toplam = 0;

                for(int i = 0;i<=8;i++){
                    if(i%2==0) {
                        tek = tek + Integer.parseInt(String.valueOf(tckn.charAt(i)));
                    }else{
                        cift = cift + Integer.parseInt(String.valueOf(tckn.charAt(i)));
                    }
                }
                if((((tek*7)-(cift))%10)==Integer.parseInt(String.valueOf(tckn.charAt(9)))){


                    toplam = tek + cift + Integer.parseInt(String.valueOf(tckn.charAt(9)));


                    if((toplam%10)==Integer.parseInt(String.valueOf(tckn.charAt(10)))){
                        return true;
                    }else{
                        throw new DogrulamaException("Geçersiz Tckn No!!!");
                    }
                }else{

                    return false;

                }
            }else {
                return false;
            }
        }
        else{
            return false;
        }
    }
}
