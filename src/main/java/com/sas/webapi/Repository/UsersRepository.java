package com.sas.webapi.Repository;

import com.sas.webapi.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Integer>{
    @Query("SELECT u FROM Users u WHERE u.username = :username")
    Optional<Users> findUserByUsername(@Param("username") String username);

    @Query("SELECT 1 FROM Users u WHERE u.id = :id")
    Integer checkUserExistenceById(@Param("id") int id);

    @Query("SELECT 1 FROM Users u WHERE u.username = :username")
    Integer checkUserExistence(@Param("username") String username);

    @Query("SELECT u FROM Users u WHERE u.id = :id")
    Users findUsersById(@Param("id") int id);


    @Transactional
    @Modifying
    @Query("DELETE FROM Users u WHERE u.username = :username")
    void deleteUserByUsername(@Param("username") String username);
}
