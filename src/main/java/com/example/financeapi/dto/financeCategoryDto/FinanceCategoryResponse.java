package com.example.financeapi.dto.financeCategoryDto;

import com.example.financeapi.entity.FinanceType;
import com.example.financeapi.entity.Users;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FinanceCategoryResponse {

    private Long categoryId;
    private Users user;
    private String categoryName;
    private FinanceType financeType;

}
