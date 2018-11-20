package com.hlieb.helper.repository;

import com.hlieb.helper.entity.CashContribution;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashContributionRepository extends CrudRepository<CashContribution, Long> {
}
