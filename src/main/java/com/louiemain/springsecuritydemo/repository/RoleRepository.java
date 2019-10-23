package com.louiemain.springsecuritydemo.repository;

import com.louiemain.springsecuritydemo.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
