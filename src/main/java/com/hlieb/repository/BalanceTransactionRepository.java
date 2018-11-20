package com.hlieb.repository;

import com.hlieb.entity.BalanceTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalanceTransactionRepository extends CrudRepository<BalanceTransaction, Long> {

    BalanceTransaction findTopByOrderByIdDesc();

    List<BalanceTransaction> findTop30ByOrderByIdDesc();
}
