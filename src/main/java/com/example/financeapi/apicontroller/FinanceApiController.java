package com.example.financeapi.apicontroller;

import com.example.financeapi.dto.FinanceCategoryRequest;
import com.example.financeapi.dto.FinanceCategoryResponse;
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

    @GetMapping("/category/list")
    public ResponseEntity<List<FinanceCategoryResponse>> findAllCategory(@RequestParam("userId") long userId){

        List<FinanceCategoryResponse> allCategory = financeService.findAllCategory(userId);
        return ResponseEntity.ok(allCategory);

    }

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

    @PostMapping("/category/delete/{categoryId}")
    public ResponseEntity<Void> deleteFinanceCategory(@RequestParam(name = "userId") long userId,
                                                      @PathVariable(name = "categoryId") long categoryId){

        financeService.deleteFinanceCategory(userId, categoryId);

        return ResponseEntity.noContent().build();
    }



}
