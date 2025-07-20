package com.example.financeapi.service.financeListService;

import com.example.financeapi.dto.financeListDto.FinanceListCreateDto;
import com.example.financeapi.entity.FinanceCategory;
import com.example.financeapi.entity.FinanceList;
import com.example.financeapi.entity.Users;
import com.example.financeapi.repository.finance.FinanceCategoryRepository;
import com.example.financeapi.repository.finance.FinanceListRepository;
import com.example.financeapi.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FinanceListServiceImpl implements FinanceListService{

    private final FinanceListRepository financeListRepository;
    private final UserRepository userRepository;
    private final FinanceCategoryRepository financeCategoryRepository;
    @Override
    public void save(FinanceListCreateDto financeListCreateDto) {

        FinanceList financeList = new FinanceList();

        financeList.setMemo(financeListCreateDto.getMemo());
        FinanceCategory financeCategory = financeCategoryRepository.findById(financeListCreateDto.getFinanceCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("해당하는 카테고리가 없습니다"));
        financeList.setFinanceCategory(financeCategory);
        financeList.setFinanceType(financeListCreateDto.getFinanceType());
        financeList.setAmount(financeList.getAmount());
        financeList.setMemo(financeList.getMemo());

        Users getUser = userRepository.findById(financeListCreateDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 업습니다."));
        financeList.setUser(getUser);



        financeListRepository.save(financeList);





    }
}
