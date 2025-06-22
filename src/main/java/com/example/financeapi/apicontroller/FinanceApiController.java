package com.example.financeapi.apicontroller;

import com.example.financeapi.dto.FinanceCategoryRequest;
import com.example.financeapi.dto.FinanceCategoryResponse;
import com.example.financeapi.entity.FinanceCategory;
import com.example.financeapi.entity.FinanceType;
import com.example.financeapi.entity.Users;
import com.example.financeapi.service.FinanceService;
import com.example.financeapi.service.FinanceServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/finance")
public class FinanceApiController {

    private final FinanceService financeService;

    @GetMapping("")
    public ResponseEntity<String> check(@RequestParam("userId") Long userId){
        System.out.println("userId = " + userId);
        Users getUser = financeService.findUsernameById(userId);
        return ResponseEntity.ok(getUser.getUsername());
    }

    @PostMapping("/create")
    public ResponseEntity<FinanceCategoryResponse> insertFinanceCategory(@RequestBody FinanceCategoryRequest financeCategoryRequest){

        FinanceCategory fc = new FinanceCategory();
        fc.setCategoryName(financeCategoryRequest.getCategoryName());
        Long userId = financeCategoryRequest.getUserId();
        fc.setUser(financeService.findUsernameById(userId));
        fc.setFType(financeCategoryRequest.getFType());
        FinanceCategory savedFc = financeService.save(financeCategoryRequest, userId);

        FinanceCategoryResponse fr = new FinanceCategoryResponse();
        fr.setCategoryId(savedFc.getCategoryId());
        fr.setCategoryName(savedFc.getCategoryName());
        fr.setUser(savedFc.getUser());
        fr.setFType(savedFc.getFType());

        return ResponseEntity.ok(fr);
    }

}
