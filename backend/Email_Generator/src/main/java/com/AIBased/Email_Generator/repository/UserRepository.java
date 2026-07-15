package com.AIBased.Email_Generator.repository;

import com.AIBased.Email_Generator.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
