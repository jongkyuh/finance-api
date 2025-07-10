package com.example.financeapi.service.financeCategory;

import com.example.financeapi.dto.financeCategoryDto.FinanceCategoryRequest;
import com.example.financeapi.dto.financeCategoryDto.FinanceCategoryResponse;
import com.example.financeapi.dto.financeCategoryDto.FinanceCategoryUpdateRequest;
import com.example.financeapi.entity.Users;

import java.util.List;

public interface FinanceCategoryService {
    Users findUsernameById(long userId);

    FinanceCategoryResponse save(FinanceCategoryRequest fr, long userId);

    List<FinanceCategoryResponse> findAllCategory(long userId);

    void deleteFinanceCategory(long userId, long categoryId);

    void updateFinanceCategory(FinanceCategoryUpdateRequest financeCategoryUpdateRequest);
}
