package com.example.financeapi.apicontroller;

import com.example.financeapi.dto.financeListDto.FinanceListCreateDto;
import com.example.financeapi.service.financeListService.FinanceListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/finance/list")
public class FinanceListApiController {

    private final FinanceListService financeListService;

    @PostMapping("/create")
    public void createFinanceList(FinanceListCreateDto financeListCreateDto){
        financeListService.save(financeListCreateDto);
    }
}
