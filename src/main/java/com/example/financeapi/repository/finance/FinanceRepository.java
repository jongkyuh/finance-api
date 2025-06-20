package com.example.financeapi.repository.finance;

import com.example.financeapi.entity.FinanceCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceRepository extends JpaRepository<FinanceCategory, Long> {
}
