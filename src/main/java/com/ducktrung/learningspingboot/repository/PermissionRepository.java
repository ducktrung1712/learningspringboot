package com.ducktrung.learningspingboot.repository;

import com.ducktrung.learningspingboot.Entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {
}
