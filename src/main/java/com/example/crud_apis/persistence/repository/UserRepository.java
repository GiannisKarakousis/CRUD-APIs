package com.example.crud_apis.persistence.repository;


import com.example.crud_apis.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByAfm(String afm);
}
