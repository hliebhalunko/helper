package com.hlieb.repository;

import com.hlieb.entity.BalanceTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BalanceTransactionRepository extends CrudRepository<BalanceTransaction, Long> {

    BalanceTransaction findTopByOrderByIdDesc();

    List<BalanceTransaction> findByDateGreaterThanOrderByIdDesc(LocalDate date);

    List<BalanceTransaction> findByDateLessThanOrderByIdDesc(LocalDate date);

    List<BalanceTransaction> findByDateBetweenOrderByIdDesc(LocalDate startDate, LocalDate endDate);

}
