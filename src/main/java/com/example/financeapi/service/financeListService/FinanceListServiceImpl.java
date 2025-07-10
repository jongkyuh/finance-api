package com.example.financeapi.service.financeListService;

import com.example.financeapi.dto.financeListDto.FinanceListCreateDto;
import com.example.financeapi.entity.FinanceList;
import com.example.financeapi.entity.Users;
import com.example.financeapi.repository.finance.FinanceListRepository;
import com.example.financeapi.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FinanceListServiceImpl implements FinanceListService{

    private final FinanceListRepository financeListRepository;
    private final UserRepository userRepository;
    @Override
    public void save(FinanceListCreateDto financeListCreateDto) {

        FinanceList financeList = new FinanceList();

        financeList.setMemo(financeList.getMemo());
        financeList.setFinanceCategory(financeListCreateDto.getFinanceCategory());
        financeList.setFinanceType(financeListCreateDto.getFinanceType());
        financeList.setAmount(financeList.getAmount());
        financeList.setMemo(financeList.getMemo());

        Users getUser = userRepository.findById(financeListCreateDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 업습니다."));
        financeList.setUser(getUser);

        financeListRepository.save(financeList);





    }
}
