package com.example.application.dto;

import com.example.application.dto.baseAbstractDto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDTO  extends BaseDto {
    private String name;
    private String surname;
    private String identityNumber;
    private boolean islemTuru=false;
}
