package com.example.financeapi.dto;

import com.example.financeapi.entity.FinanceType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FinanceCategoryRequest {
    private String categoryName;

    private FinanceType financeType;

    private Long userId;
}
