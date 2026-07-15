package com.AIBased.Email_Generator.repository;

import com.AIBased.Email_Generator.entity.EmailHistory;
import com.AIBased.Email_Generator.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailHistoryRepository extends JpaRepository<EmailHistory, Long>
{

    List<EmailHistory> findByUser(User user);

    List<EmailHistory> findByUserId(Long userId);

    void deleteByUserId(Long userId);
}
