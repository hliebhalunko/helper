package com.hlieb.repository;

import com.hlieb.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByBalanceLessThanOrderByBalanceAsc(int i);

    List<User> findByBalanceGreaterThanEqualOrderByBalanceDesc(int i);
}
