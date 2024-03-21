package com.architecture.admin.services.policy;

import com.architecture.admin.models.daosub.policy.PolicyDaoSub;
import com.architecture.admin.models.dto.SearchDto;
import com.architecture.admin.models.dto.policy.PolicyDto;
import com.architecture.admin.services.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*****************************************************
 * 이용약관 모델러
 ****************************************************/
@RequiredArgsConstructor
@Service
@Transactional
public class PolicyService extends BaseService {
    private final PolicyDaoSub policyDaoSub;

    /*****************************************************
     *  SubFunction - Select
     ****************************************************/

    /**
     * 이용약관 목록
     *
     * @return
     */
    public List<PolicyDto> getPolicyList(SearchDto searchDto) {
        String localeLang = super.getLocaleLang();
        searchDto.setLang(localeLang);
        return policyDaoSub.getPolicyList(searchDto);
    }

    /**
     * 약관 메뉴 목록
     *
     * @return 공지사항 메뉴 목록
     */
    public List<PolicyDto> getPolicyMenuList() {
        List<PolicyDto> menuList = policyDaoSub.getPolicyMenuList();

        for (PolicyDto menu : menuList) {
            // 날짜 목록 가져오기
            List<String> dateList = policyDaoSub.getPolicyDateList(menu.getIdx());
            menu.setDateList(dateList);
        }

        // 약관 메뉴 리스트
        return policyDaoSub.getPolicyMenuList();
    }

}
