package com.example.application.entites;

import com.example.application.entites.baseAbstractEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "USERS")
public class User extends BaseEntity {
    private String name;
    private String surname;
    private String identityNumber;
}
