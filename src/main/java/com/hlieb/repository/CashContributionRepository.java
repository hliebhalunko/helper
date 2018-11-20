package com.hlieb.repository;

import com.hlieb.entity.CashContribution;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CashContributionRepository extends CrudRepository<CashContribution, Long> {

    @Query(value = "SELECT cc FROM CashContribution cc WHERE cc.dateOfContribution > ?1")
    Iterable<CashContribution> getAllContributionsBeforeDate(LocalDate date);

}
