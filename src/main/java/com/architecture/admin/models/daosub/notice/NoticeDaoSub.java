package com.architecture.admin.models.daosub.notice;

import com.architecture.admin.models.dto.SearchDto;
import com.architecture.admin.models.dto.notice.NoticeDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface NoticeDaoSub {
    /*****************************************************
     * Select
     ****************************************************/
    /**
     * 공지사항 목록
     *
     * @param searchDto type searchType searchWord
     * @return list
     */
    List<NoticeDto> getList(SearchDto searchDto);

    /**
     * 공지사항 메뉴 목록
     *
     * @return list
     */
    List<NoticeDto> getMenuList();


    /**
     * 전체 카운트
     *
     * @param searchDto type searchType searchWord
     * @return count
     */
    int getTotalCount(SearchDto searchDto);
}
