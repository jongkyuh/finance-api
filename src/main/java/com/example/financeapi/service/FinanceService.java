package com.example.financeapi.service;

import com.example.financeapi.entity.Users;
import com.example.financeapi.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class FinanceService {

    private final UserRepository userRepository;

    public String findUsernameById(@RequestParam long userId){
        Users getUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 유저가 없습니다"));

        return getUser.getUsername();
    }

}
