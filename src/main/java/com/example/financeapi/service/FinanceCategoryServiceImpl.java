package com.example.financeapi.service;

import com.example.financeapi.dto.FinanceCategoryRequest;
import com.example.financeapi.dto.FinanceCategoryResponse;
import com.example.financeapi.entity.FinanceCategory;
import com.example.financeapi.entity.Users;
import com.example.financeapi.repository.finance.FinanceRepository;
import com.example.financeapi.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FinanceCategoryServiceImpl implements FinanceCategoryService {

    private final UserRepository userRepository;
    private final FinanceRepository financeRepository;

    @Override
    public Users findUsernameById(long userId){
        Users getUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 유저가 없습니다"));

        return getUser;
    }

    @Override
    public FinanceCategoryResponse save(FinanceCategoryRequest fr, long userId) {
        FinanceCategory fc = new FinanceCategory();
        // FinanceCategory 엔티티 설정
        fc.setCategoryName(fr.getCategoryName());
        fc.setUser(findUsernameById(userId));
        fc.setFType(fr.getFType());

        FinanceCategory saveCategory = financeRepository.save(fc);

        FinanceCategoryResponse financeCategoryResponse = new FinanceCategoryResponse();
        financeCategoryResponse.setCategoryId(saveCategory.getCategoryId());
        financeCategoryResponse.setCategoryName(saveCategory.getCategoryName());
        financeCategoryResponse.setUser(saveCategory.getUser());
        financeCategoryResponse.setFType(saveCategory.getFType());

        return financeCategoryResponse;
    }

    @Override
    public List<FinanceCategoryResponse> findAllCategory(long userId) {
        List<FinanceCategory> getCategory = financeRepository.findByUserId(userId);
        List<FinanceCategoryResponse> collect = getCategory.stream().map(c -> {
            FinanceCategoryResponse response = new FinanceCategoryResponse();
            response.setCategoryId(c.getCategoryId());
            response.setCategoryName(c.getCategoryName());
            response.setUser(c.getUser());
            response.setFType(c.getFType());
            return response;
        }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public void deleteFinanceCategory(long userId, long categoryId) {
        FinanceCategory findCategory = financeRepository.findById(categoryId).orElseThrow(() -> new IllegalArgumentException("해당 카테고리 없음"));
        if(userId != findCategory.getUser().getId()) throw new IllegalArgumentException("삭제권한이 없습니다");

        financeRepository.delete(findCategory);

    }

}
