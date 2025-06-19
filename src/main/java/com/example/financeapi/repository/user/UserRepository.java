package com.example.financeapi.repository.user;

import com.example.financeapi.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
