package com.ysd.humanresource.enums;

import lombok.Getter;

@Getter
public enum TransFerrecordStatusEnum {
	
	 TRANSFERRECORDWAITADUIT(0, "待审核"),
	 TRANSFERRECORDPASSEDADUIT(1, "已审核"),
     ;
	
	 private Integer code;

	 private String message;

	 TransFerrecordStatusEnum(Integer code, String message) {
		 this.code = code;
		 this.message = message;
	 }
	 
}
