package com.devang.iam.repositories;
import com.devang.iam.models.AppUsers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepository extends JpaRepository<AppUsers, Integer>{
    AppUsers findByUsername(String username);
}