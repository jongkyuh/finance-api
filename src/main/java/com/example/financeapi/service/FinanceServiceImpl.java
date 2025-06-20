package com.example.financeapi.service;

import com.example.financeapi.entity.FinanceCategory;
import com.example.financeapi.entity.FinanceType;
import com.example.financeapi.entity.Users;
import com.example.financeapi.repository.finance.FinanceRepository;
import com.example.financeapi.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FinanceServiceImpl implements FinanceService{

    private final UserRepository userRepository;
    private final FinanceRepository financeRepository;

    @Override
    public Users findUsernameById(long userId){
        Users getUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 유저가 없습니다"));

        return getUser;
    }

    @Override
    public FinanceCategory save(FinanceCategory financeCategory) {
        return financeRepository.save(financeCategory);
    }

}
