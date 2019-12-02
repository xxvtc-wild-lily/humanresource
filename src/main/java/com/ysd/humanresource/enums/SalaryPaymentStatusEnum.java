package com.ysd.humanresource.enums;

import lombok.Getter;

@Getter
public enum SalaryPaymentStatusEnum {
	
	SALARYPAYMENTWAITADUIT(0, "н�귢�ŵȴ����"),
	SALARYPAYMENTPASSEDADUIT(1, "н�귢��ͨ�����"),
    ;

    private Integer code;

    private String message;

    SalaryPaymentStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
	
}
