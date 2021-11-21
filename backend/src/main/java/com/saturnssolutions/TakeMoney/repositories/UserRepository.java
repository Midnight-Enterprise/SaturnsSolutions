package com.saturnssolutions.TakeMoney.repositories;

import com.saturnssolutions.TakeMoney.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    @Query(value = "select user.*, sum(user.value_income + user.outcome_value) as AddedValues from money user", nativeQuery = true)
    List<Object[]> findAllByTotal();
}