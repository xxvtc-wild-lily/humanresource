package com.ysd.humanresource.enums;

import lombok.Getter;

@Getter
public enum SalaryStandardStatusEnum {
	
	SALARYSTANDARDWAITADUIT(0, "н���׼�ȴ����"),
    ;

    private Integer code;

    private String message;

    SalaryStandardStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
	
}