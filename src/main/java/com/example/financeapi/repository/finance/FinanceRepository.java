package com.example.financeapi.repository.finance;

import com.example.financeapi.dto.FinanceCategoryResponse;
import com.example.financeapi.entity.FinanceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FinanceRepository extends JpaRepository<FinanceCategory, Long> {

    @Query("select fc from FinanceCategory fc join fetch fc.user where fc.user.id = :userId")
    List<FinanceCategory> findByUserId(@Param("userId") long userId);
}
