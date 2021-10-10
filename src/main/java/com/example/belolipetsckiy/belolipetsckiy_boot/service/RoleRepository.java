package com.example.belolipetsckiy.belolipetsckiy_boot.service;

import com.example.belolipetsckiy.belolipetsckiy_boot.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String role);
}
