package org.example.onlineshop9a.repository;

import org.example.onlineshop9a.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(Integer id);
}
