package com.example.financeapi.service;

import com.example.financeapi.dto.FinanceCategoryRequest;
import com.example.financeapi.entity.FinanceCategory;
import com.example.financeapi.entity.FinanceType;
import com.example.financeapi.entity.Users;

public interface FinanceService {
    Users findUsernameById(long userId);
    FinanceCategory save(FinanceCategoryRequest financeCategoryRequest, long userId);
}
