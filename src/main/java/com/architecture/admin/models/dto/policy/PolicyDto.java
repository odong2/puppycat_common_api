package com.architecture.admin.models.dto.policy;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyDto {

    /**
     * sns_policy
     **/
    private int idx;           // 고유번호
    private String title;       // 약관제목
    private String required;    // 필수값 여부
    private String category;    // 카테고리 idx
    private Integer state;      // 상태값
    private String regDate;     // 등록일
    private String regDateTz;   // 등록일 타임존

    /**
     * sns_policy_menu
     */
    private String menuName; // 카테고리 이름
    private Integer menuIdx; // 카테고리 idx

    private List<String> dateList;
    /**
     * sns_policy_detail
     **/
    private Long policyIdx;     // 약관번호
    private String detail;      // 약관내용
    private String lang;        // 언어

    /**
     * sns_policy_name
     **/
    private String name;        //약관명

    /**
     * sns_policy_agree
     **/
    private String agree;    // 동의 여부

    // sql
    private Integer insertedIdx;
    private Integer affectedRow;


}
