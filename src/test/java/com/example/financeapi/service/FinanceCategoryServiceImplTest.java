package com.example.financeapi.service;

import com.example.financeapi.dto.FinanceCategoryRequest;
import com.example.financeapi.dto.FinanceCategoryResponse;
import com.example.financeapi.entity.FinanceCategory;
import com.example.financeapi.entity.FinanceType;
import com.example.financeapi.entity.Users;
import com.example.financeapi.repository.finance.FinanceRepository;
import com.example.financeapi.repository.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class FinanceCategoryServiceImplTest {

    @Autowired private FinanceCategoryService financeService;
    @Autowired private UserRepository userRepository;
    @Autowired private FinanceRepository financeRepository;

    @Test
    public void 유저아이디_중복검사(){
        assertThrows(IllegalArgumentException.class,() ->{
            financeService.findUsernameById(-1L);
        });
    }

    @Test
    public void 카테고리_추가(){
        Users user1 = new Users();
        user1.setUsername("테스트1");
        Users savedUser = userRepository.save(user1);

        FinanceCategoryRequest fr = new FinanceCategoryRequest();
        fr.setCategoryName("식비");
        fr.setFType(FinanceType.EXPENSE);

        FinanceCategoryResponse savedCategory = financeService.save(fr, savedUser.getId());

        List<FinanceCategory> allList = financeRepository.findAll();

        assertThat(allList.size()).isEqualTo(1);
        FinanceCategory financeCategory = allList.get(0);

        assertThat(financeCategory.getCategoryId()).isEqualTo(savedCategory.getCategoryId());
        assertThat(financeCategory.getCategoryName()).isEqualTo("식비");
        assertThat(financeCategory.getFType()).isEqualTo(FinanceType.EXPENSE);



    }



}