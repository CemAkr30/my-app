package com.example.application.dto.baseAbstractDto;


import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseDto {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
