package com.example.financeapi.apicontroller;

import com.example.financeapi.dto.FinanceCategoryRequest;
import com.example.financeapi.dto.FinanceCategoryResponse;
import com.example.financeapi.dto.FinanceCategoryUpdateRequest;
import com.example.financeapi.entity.FinanceCategory;
import com.example.financeapi.entity.Users;
import com.example.financeapi.service.FinanceCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/finance")
public class FinanceApiController {

    private final FinanceCategoryService financeService;

    @GetMapping("")
    public ResponseEntity<String> check(@RequestParam("userId") Long userId){
        System.out.println("userId = " + userId);
        Users getUser = financeService.findUsernameById(userId);
        return ResponseEntity.ok(getUser.getUsername());
    }

    // 가계부 카테고리 리스트 (개인별)
    @GetMapping("/category/list")
    public ResponseEntity<List<FinanceCategoryResponse>> findAllCategory(@RequestParam("userId") long userId){

        List<FinanceCategoryResponse> allCategory = financeService.findAllCategory(userId);
        return ResponseEntity.ok(allCategory);

    }
    // 가계부 카테고리 만들기
    @PostMapping("/category/create")
    public ResponseEntity<FinanceCategoryResponse> insertFinanceCategory(@RequestBody FinanceCategoryRequest financeCategoryRequest){

        FinanceCategory fc = new FinanceCategory();
        fc.setCategoryName(financeCategoryRequest.getCategoryName());
        Long userId = financeCategoryRequest.getUserId();
        fc.setUser(financeService.findUsernameById(userId));
        fc.setFType(financeCategoryRequest.getFType());
        FinanceCategoryResponse saveCategoryResponse = financeService.save(financeCategoryRequest, userId);


        return ResponseEntity.ok(saveCategoryResponse);
    }

    // 가계부 카테고리 삭제하기
    @PostMapping("/category/delete/{categoryId}")
    public ResponseEntity<Void> deleteFinanceCategory(@RequestParam(name = "userId") long userId,
                                                      @PathVariable(name = "categoryId") long categoryId){

        financeService.deleteFinanceCategory(userId, categoryId);

        return ResponseEntity.noContent().build();
    }

    // 가계부 수정하기
    @PostMapping("/category/update/{categoryId}")
    public ResponseEntity<Void> updateFinanceCategory(@RequestBody FinanceCategoryUpdateRequest financeCategoryUpdateRequest){
        financeService.updateFinanceCategory(financeCategoryUpdateRequest);

        return ResponseEntity.noContent().build();
    }



}
