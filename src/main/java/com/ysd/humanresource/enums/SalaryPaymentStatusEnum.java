package com.ysd.humanresource.enums;

import lombok.Getter;

@Getter
public enum SalaryPaymentStatusEnum {
	
	SALARYPAYMENTWAITADUIT(0, "薪酬发放等待审核"),
	SALARYPAYMENTPASSEDADUIT(1, "薪酬发放通过审核"),
	SALARYPAYMENTWAITPAY(0, "薪酬单等待发放"),
	SALARYPAYMENTHASPAY(0, "薪酬单已发放"),
    ;

    private Integer code;

    private String message;

    SalaryPaymentStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
	
}
