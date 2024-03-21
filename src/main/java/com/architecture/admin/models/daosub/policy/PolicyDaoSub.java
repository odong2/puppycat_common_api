package com.architecture.admin.models.daosub.policy;

import com.architecture.admin.models.dto.SearchDto;
import com.architecture.admin.models.dto.policy.PolicyDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PolicyDaoSub {

    /**
     * 약관 목록 가져오기
     *
     * @param searchDto lang : 사용언어
     * @return PolicyDto
     */
    List<PolicyDto> getPolicyList(SearchDto searchDto);

    /**
     * 검색 날짜 목록 가져오기
     *
     * @param menu
     * @return
     */
    List<String> getPolicyDateList(Integer menu);

    /**
     * 약관 메뉴 목록
     *
     * @return list
     */
    List<PolicyDto> getPolicyMenuList();

}
