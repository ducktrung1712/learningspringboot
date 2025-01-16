package com.ducktrung.learningspingboot.repository;

import com.ducktrung.learningspingboot.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}
