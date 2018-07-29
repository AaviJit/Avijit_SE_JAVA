package com.sweetitech.assessment.Repository;

import com.sweetitech.assessment.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public boolean existsByEmailAndPassword(String email, String password);

}
