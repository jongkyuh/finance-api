package com.example.financeapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class FinanceList {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "finance_category_id")
    private FinanceCategory financeCategory;

    @Enumerated(EnumType.STRING)
    private FinanceType financeType;

   // private boolean isFixed;  // 고정비 일단 생략

    private int amount;
    private String memo;

    private LocalDateTime localDateTime;

    /**
     * create시 유저아이디, 카테고리, 가계부타입, 금액, 메모
     */
}
