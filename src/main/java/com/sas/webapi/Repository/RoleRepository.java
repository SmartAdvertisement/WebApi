package com.sas.webapi.Repository;

import com.sas.webapi.Model.Roles;
import com.sas.webapi.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles,Integer> {

    Roles findByRole(String role);

    @Query("SELECT r FROM Roles r WHERE r.id = :id")
    Roles findRolesById(@Param("id") int id);

}
