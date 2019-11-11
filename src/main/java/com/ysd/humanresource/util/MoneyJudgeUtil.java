package com.ysd.humanresource.util;

import java.math.BigDecimal;

public class MoneyJudgeUtil {
	
	public static BigDecimal judge(BigDecimal bigDecimal) {
		if ("".equals(bigDecimal) || bigDecimal == null) {
			return new BigDecimal(0.00);
		}
		
		return bigDecimal;
	}
	
}
