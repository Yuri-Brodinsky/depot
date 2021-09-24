package com.examplestudy.depotapp.user;

import com.examplestudy.depotapp.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByLogin(String login);
    List<User> findByRole(Role role);
}
