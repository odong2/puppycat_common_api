package com.architecture.admin.services.faq;

import com.architecture.admin.libraries.PaginationLibray;
import com.architecture.admin.models.daosub.faq.FaqDaoSub;
import com.architecture.admin.models.dto.SearchDto;
import com.architecture.admin.models.dto.faq.FaqDto;
import com.architecture.admin.services.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/*****************************************************
 * 자주하는 질문 모델러
 ****************************************************/
@Service
@RequiredArgsConstructor
@Transactional
public class FaqService extends BaseService {
    private final FaqDaoSub faqDaoSub;

    /*****************************************************
     *  Modules
     ****************************************************/
    /*****************************************************
     *  SubFunction - select
     ****************************************************/
    /**
     * 자주하는 질문 목록
     *
     * @param searchDto
     * @return 자주하는 질문 리스트
     */
    public List<FaqDto> getList(SearchDto searchDto) {
        List<FaqDto> list = new ArrayList<>();

        // 목록 전체 count
        int totalCount = faqDaoSub.getTotalCount(searchDto);

        if (totalCount > 0) {
            // paging
            PaginationLibray pagination = new PaginationLibray(totalCount, searchDto);
            searchDto.setPagination(pagination);

            // 자주하는 질문 리스트
            list = faqDaoSub.getList(searchDto);
        }

        return list;
    }

    /**
     * 자주하는 질문 메뉴 목록
     *
     * @return 자주하는 질문 메뉴 리스트
     */
    public List<FaqDto> getMenuList() {
        // 자주하는 질문 메뉴 리스트
        return faqDaoSub.getMenuList();
    }
    /*****************************************************
     *  SubFunction - insert
     ****************************************************/

    /*****************************************************
     *  SubFunction - Update
     ****************************************************/

    /*****************************************************
     *  SubFunction - Delete
     ****************************************************/

    /*****************************************************
     *  SubFunction - State
     ****************************************************/
}
