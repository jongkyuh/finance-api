package com.example.financeapi.repository.finance;

import com.example.financeapi.entity.FinanceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FinanceCategoryRepository extends JpaRepository<FinanceCategory, Long> {

    /**
     * 특정 유저가 만든 카테고리 리스트
     * @param userId
     * @return
     */
    @Query("select fc from FinanceCategory fc join fetch fc.user where fc.user.id = :userId")
    List<FinanceCategory> findByUserId(@Param("userId") long userId);
}
