package com.ysd.humanresource.enums;

import lombok.Getter;

@Getter
public enum AccountLockStatusEnum {
	
	LOCK(1, "锁定"),
	UNLCOK(0, "未锁定"),
    ;

    private Integer code;

    private String message;

    AccountLockStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
	
}
