package com.example.belolipetsckiy.belolipetsckiy_boot.service;

import com.example.belolipetsckiy.belolipetsckiy_boot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
}
