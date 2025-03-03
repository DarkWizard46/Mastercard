package com.mastercard.app.repository;

<<<<<<<< HEAD:src/main/java/com/mastercard/app/repository/UserRepository.java
import com.mastercard.app.model.User;
========
import com.mastercard.model.users.Users;
>>>>>>>> 47ad84b109476092d22ce982fa22cf102e530a12:src/main/java/com/mastercard/app/repository/UsersRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByUsername(String username);
}
