package com.example.financeapi.service;

import com.example.financeapi.dto.FinanceCategoryRequest;
import com.example.financeapi.dto.FinanceCategoryResponse;
import com.example.financeapi.entity.FinanceCategory;
import com.example.financeapi.entity.FinanceType;
import com.example.financeapi.entity.Users;
import com.example.financeapi.repository.finance.FinanceCategoryRepository;
import com.example.financeapi.repository.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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

    @Autowired private FinanceCategoryService financeCategoryService;
    @Autowired private UserRepository userRepository;
    @Autowired private FinanceCategoryRepository financeCategoryRepository;

    static Users saveUser;
    static FinanceCategory fc1;
    static FinanceCategory fc2;
    
    @BeforeEach
    public void 테스트데이터_추가(){
// 테스트 유저 등록
        Users user = new Users();
        user.setUsername("테스트이름");
        saveUser = userRepository.save(user);

        // 테스트 카테고리 등록
        FinanceCategory fc11 = new FinanceCategory();
        fc11.setCategoryName("테스트카테고리이름1");
        fc11.setUser(saveUser);
        fc1 = financeCategoryRepository.save(fc11);


        FinanceCategory fc22 = new FinanceCategory();
        fc22.setUser(saveUser);
        fc22.setCategoryName("테스트카테고리이름2");
        fc2 = financeCategoryRepository.save(fc22);
    }

    @Test
    public void 유저아이디_중복검사(){
        assertThrows(IllegalArgumentException.class,() ->{
            financeCategoryService.findUsernameById(-1L);
        });
    }

//    @Test
//    public void 카테고리_추가(){
//        Users user1 = new Users();
//        user1.setUsername("테스트1");
//        Users savedUser = userRepository.save(user1);
//
//        FinanceCategoryRequest fr = new FinanceCategoryRequest();
//        fr.setCategoryName("식비");
//        fr.setFType(FinanceType.EXPENSE);
//
//        FinanceCategoryResponse savedCategory = financeCategoryService.save(fr, savedUser.getId());
//
//        List<FinanceCategory> allList = financeCategoryRepository.findAll();
//
//        assertThat(allList.size()).isEqualTo(4);
//        FinanceCategory financeCategory = allList.get(0);
//
//        assertThat(financeCategory.getCategoryId()).isEqualTo(savedCategory.getCategoryId());
//        assertThat(financeCategory.getCategoryName()).isEqualTo("식비");
//        assertThat(financeCategory.getFType()).isEqualTo(FinanceType.EXPENSE);
//
//    }

    @Test
    public void 유저아이디별_카테고리리스트조회(){

        List<FinanceCategoryResponse> getList = financeCategoryService.findAllCategory(saveUser.getId());

        Assertions.assertThat(getList.size()).isEqualTo(2);
    }

    @Test
    public void 카테고리삭제_카테고리아이디없을떄_예외(){


        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            financeCategoryService.deleteFinanceCategory(0l, 0L);
        });

        Assertions.assertThat("해당 카테고리 없음").isEqualTo(illegalArgumentException.getMessage());

    }

    @Test
    public void 카테고리삭제_카테고리아이디와삭제요청자가다를때_예외(){


        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            financeCategoryService.deleteFinanceCategory(0L, fc2.getCategoryId());
        });
        Assertions.assertThat("삭제권한이 없습니다").isEqualTo(illegalArgumentException.getMessage());
    }

    @Test
    public void 카테고리삭제(){


    }




}