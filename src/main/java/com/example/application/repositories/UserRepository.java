package com.example.application.repositories;


import com.example.application.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

//    @Query("select u from User u where lower(u.name) like " +
//            " lower(concat('%',:searchName,'%'))")
//    List<User> searchByName(@Param("searchName") String searchName);
//
//    @Query("select u from User u where lower(u.surname) like " +
//            " lower(concat('%',:searchSurname,'%'))")
//    List<User> searchBySurname(@Param("searchSurname") String searchSurname);
//
//    @Query("select u from User u where lower(u.identityNumber) like " +
//            " lower(concat('%',:searchIdentityNumber,'%'))")
//    List<User> searchByIdentityNumber(@Param("searchIdentityNumber") String searchIdentityNumber);

    List<User> findByIdentityNumberStartsWithIgnoreCase(String name);
    List<User> findBySurnameStartsWithIgnoreCase(String surname);
    List<User> findByNameStartsWithIgnoreCase(String name);
}
