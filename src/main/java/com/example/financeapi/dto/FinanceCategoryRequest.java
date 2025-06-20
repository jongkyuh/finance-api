package com.example.financeapi.dto;

import com.example.financeapi.entity.FinanceType;
import lombok.Data;

@Data
public class FinanceCategoryRequest {
    private String categoryName;
    private FinanceType fType;
}
