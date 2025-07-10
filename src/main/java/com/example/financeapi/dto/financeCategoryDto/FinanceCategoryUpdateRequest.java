package com.example.financeapi.dto.financeCategoryDto;

import com.example.financeapi.entity.FinanceType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FinanceCategoryUpdateRequest {

    private Long categoryId;
    private String categoryName;
    @JsonProperty("fType")
    private FinanceType fType;

    private Long userId;

}
