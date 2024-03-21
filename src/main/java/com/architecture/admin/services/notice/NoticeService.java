package com.architecture.admin.services.notice;

import com.architecture.admin.libraries.PaginationLibray;
import com.architecture.admin.models.daosub.notice.NoticeDaoSub;
import com.architecture.admin.models.dto.SearchDto;
import com.architecture.admin.models.dto.notice.NoticeDto;
import com.architecture.admin.services.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/*****************************************************
 * 공지사항 모델러
 ****************************************************/
@Service
@RequiredArgsConstructor
@Transactional
public class NoticeService extends BaseService {
    private final NoticeDaoSub noticeDaoSub;
    /*****************************************************
     *  Modules
     ****************************************************/

    /*****************************************************
     *  SubFunction - select
     ****************************************************/
    /**
     * 공지사항 목록
     *
     * @param searchDto type searchType searchWord
     * @return 공지사항 리스트
     */
    public List<NoticeDto> getList(SearchDto searchDto) {
        List<NoticeDto> list = new ArrayList<>();

        // 목록 전체 count
        int totalCount = noticeDaoSub.getTotalCount(searchDto);

        if (totalCount > 0) {
            // paging
            PaginationLibray pagination = new PaginationLibray(totalCount, searchDto);
            searchDto.setPagination(pagination);

            // list
            list = noticeDaoSub.getList(searchDto);
        }

        // 공지사항 리스트
        return list;
    }

    /**
     * 공지사항 메뉴 목록
     *
     * @return 공지사항 메뉴 목록
     */
    public List<NoticeDto> getMenuList() {
        // 공지사항 메뉴 리스트
        return noticeDaoSub.getMenuList();
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
}
