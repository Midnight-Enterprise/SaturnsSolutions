package com.saturnssolutions.TakeMoney.repositories;

import com.saturnssolutions.TakeMoney.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
}