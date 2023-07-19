package com.deloitte.ads.repository;

import com.deloitte.ads.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByExternalKeyUser(UUID id);
}
