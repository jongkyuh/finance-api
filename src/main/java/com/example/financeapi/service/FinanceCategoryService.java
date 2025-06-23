package com.example.financeapi.service;

import com.example.financeapi.dto.FinanceCategoryRequest;
import com.example.financeapi.dto.FinanceCategoryResponse;
import com.example.financeapi.entity.FinanceCategory;
import com.example.financeapi.entity.Users;

import java.util.List;

public interface FinanceCategoryService {
    Users findUsernameById(long userId);

    FinanceCategoryResponse save(FinanceCategoryRequest fr, long userId);

    List<FinanceCategoryResponse> findAllCategory(long userId);

    void deleteFinanceCategory(long userId, long categoryId);
}
