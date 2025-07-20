package com.example.financeapi.dto.financeListDto;

import com.example.financeapi.entity.FinanceCategory;
import com.example.financeapi.entity.FinanceType;
import com.example.financeapi.entity.Users;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FinanceListResponseDto {

    private Long id;
    private Users user;
    private FinanceCategory financeCategory;
    private FinanceType financeType;
    private int amount;
    private String memo;
    private LocalDateTime localDateTime;
}
