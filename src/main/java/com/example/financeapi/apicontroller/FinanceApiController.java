package com.example.financeapi.apicontroller;

import com.example.financeapi.service.FinanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/finance")
public class FinanceApiController {

    private final FinanceService financeService;

    @GetMapping("")
    public ResponseEntity<String> check(long userId){
        String getUserName = financeService.findUsernameById(userId);
        return ResponseEntity.ok(getUserName);
    }

}
