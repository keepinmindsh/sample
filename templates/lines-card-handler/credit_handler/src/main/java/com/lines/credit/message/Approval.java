package com.lines.credit.message;

import com.lines.credit.model.ApprovalRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Approval {

    @GetMapping("/approval")
    public String approval(ApprovalRequestVO approvalRequestVO) {

        log.debug("[From Wings (Browser) : Paramter] {}", approvalRequestVO);



        return "myFunc(12342342134)";
    }

}
