package com.architecture.admin.controllers.v1.faq;

import com.architecture.admin.controllers.v1.BaseController;
import com.architecture.admin.models.dto.SearchDto;
import com.architecture.admin.models.dto.faq.FaqDto;
import com.architecture.admin.services.faq.FaqService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/faq")
public class FaqV1Controller extends BaseController {

    private final FaqService faqService;

    /**
     * faq 목록
     *
     * @param searchDto page 페이지 searchType 검색항목 searchWord 검색내용 limit 페이지에 노출 될 개수 type FAQ 메뉴 idx값
     * @return 리스트 가져오기 성공
     */
    @GetMapping("")
    public ResponseEntity lists(@ModelAttribute SearchDto searchDto) {

        // list
        List<FaqDto> list = faqService.getList(searchDto);

        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("params", searchDto);

        String sMessage;
        if (!list.isEmpty()) {
            // 리스트 가져오기 성공
            sMessage = super.langMessage("lang.faq.success.list");
        } else {
            // 리스트가 없습니다
            sMessage = super.langMessage("lang.faq.exception.list.null");
        }

        JSONObject data = new JSONObject(map);
        return displayJson(true, "1000", sMessage, data);
    }

    /**
     * FAQ 메뉴 리스트
     *
     * @return FAQ 메뉴 리스트
     */
    @GetMapping("menu")
    public ResponseEntity menuLists() {
        // list
        List<FaqDto> list = faqService.getMenuList();

        Map<String, Object> map = new HashMap<>();
        map.put("list", list);

        JSONObject data = new JSONObject(map);
        String sMessage = super.langMessage("lang.faq.success.list");

        return displayJson(true, "1000", sMessage, data);
    }
}
