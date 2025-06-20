package com.example.financeapi.dto;

import com.example.financeapi.entity.FinanceType;
import com.example.financeapi.entity.Users;
import lombok.Data;

@Data
public class FinanceCategoryResponse {

    private Long categoryId;
    private Users user;
    private String categoryName;
    private FinanceType fType;

}
