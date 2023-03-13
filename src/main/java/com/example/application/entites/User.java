package com.example.application.entites;

import com.example.application.entites.baseAbstractEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "USERS", uniqueConstraints = { @UniqueConstraint(columnNames = { "identityNumber"}) })
public class User extends BaseEntity {
    private String name;
    private String surname;

    private String identityNumber;
}
