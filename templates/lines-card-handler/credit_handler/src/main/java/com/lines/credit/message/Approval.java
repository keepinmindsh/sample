package com.lines.credit.message;

import com.lines.comm.command.SimpleCommand;
import com.lines.credit.code.SpecType;
import com.lines.credit.command.AlertCommand;
import com.lines.credit.command.ApprovalCommand;
import com.lines.credit.model.AlertVO;
import com.lines.credit.model.ApprovalRequestVO;
import com.lines.credit.model.ApprovalResultVO;
import com.lines.credit.model.ApprovalVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@Slf4j
public class Approval {

    @PostMapping("/approval/{approvalType}")
    public String approval(@PathVariable("approvalType") SpecType specType, ApprovalRequestVO approvalRequestVO) {

        log.debug("[From Wings (Browser) : Parameter] {}", approvalRequestVO);

        try {
            SimpleCommand<ApprovalResultVO> approval =
                    new ApprovalCommand(ApprovalVO.builder()
                            .requestVO(approvalRequestVO)
                            .specType(specType)
                            .build());

            approval.execute();
        } catch (Exception approvalException) {
            log.error("[SpecType] {}", specType);
            log.error("[Error During Approval] {}", approvalException.getMessage());
            log.error("[Error Parameter] {}", approvalRequestVO);

            SimpleCommand alert = new AlertCommand(AlertVO.builder().build());

            try {
                alert.execute();
            } catch (Exception alertException) {
                log.error("[Error During Alert] {}", alertException.getMessage());
                alertException.printStackTrace();
            }
        }

        return "myFunc(12342342134)";
    }

}
