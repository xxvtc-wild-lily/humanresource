package com.ysd.humanresource.enums;

import lombok.Getter;

@Getter
public enum SalaryStandardStatusEnum {
	
	SALARYSTANDARDWAITADUIT(0, "薪酬标准等待审核"),
	SALARYSTANDARDPASSEDADUIT(1, "薪酬标准通过审核"),
    ;

    private Integer code;

    private String message;

    SalaryStandardStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
	
}
