package com.architecture.admin.controllers.v1.policy;

import com.architecture.admin.controllers.v1.BaseController;
import com.architecture.admin.models.dto.SearchDto;
import com.architecture.admin.models.dto.policy.PolicyDto;
import com.architecture.admin.services.policy.PolicyService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/policy")
public class PolicyV1Controller extends BaseController {
    private final PolicyService policyService;

    /**
     * 이용약관 목록
     *
     * @param searchDto searchType, date
     * @return 이용약관 리스트
     */
    @GetMapping("")
    public ResponseEntity lists(SearchDto searchDto) {

        List<PolicyDto> list = policyService.getPolicyList(searchDto);

        Map<String, Object> map = new HashMap<>();
        map.put("list", list);

        JSONObject data = new JSONObject(map);
        String sMessage = super.langMessage("lang.common.success.search");

        return displayJson(true, "1000", sMessage, data);
    }
    
     /**
     * 약관 메뉴 리스트
     *
     * @return 약관 메뉴 리스트
     */
    @GetMapping("/menu")
    public ResponseEntity menuLists() {

        // list
        List<PolicyDto> list = policyService.getPolicyMenuList();

        Map<String, Object> map = new HashMap<>();
        map.put("list", list);

        JSONObject data = new JSONObject(map);
        String sMessage = super.langMessage("lang.common.success.search");

        return displayJson(true, "1000", sMessage, data);
    }
    
}
