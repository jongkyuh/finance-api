package com.example.financeapi.repository.finance;

import com.example.financeapi.entity.FinanceList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceListRepository extends JpaRepository<FinanceList, Long> {

}
