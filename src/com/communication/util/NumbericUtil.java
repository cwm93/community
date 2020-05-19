package com.communication.util;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.math.BigDecimal;

public class NumbericUtil {
	// 默认除法运算精度  
    private static final int DEF_DIV_SCALE = 2;  
    
	public static float strToFloat(String var) {
		return isBlank(var) ? 0.00F : Float.valueOf(var);
	}
	
	public static double strToDouble(String var) {
		return isBlank(var) ? 0.0000 : Double.valueOf(var);
	}
	
	public static int strToInteger(String var) {
		return isBlank(var) ? 0 : Integer.valueOf(var);
	}
	
	
	/** 
     * 说明： 
     * 提供精确的加法运算 
     * 创建人: 李林君 邮箱：  
     * 创建日期: 2013-9-28 
     *  
     * @param v1 被加数 
     * @param v2 加数 
     * @return 两个参数的和 
     */  
    public static double add(double v1, double v2) {  
        BigDecimal b1 = new BigDecimal(Double.toString(v1));// 建议写string类型的参数，下同  
        BigDecimal b2 = new BigDecimal(Double.toString(v2));  
        return b1.add(b2).doubleValue();  
    }  
  
    /** 
     *  
     * @param v1 
     * @param v2 
     * @return 
     */  
    public static double sub(double v1, double v2) {  
        BigDecimal b1 = new BigDecimal(Double.toString(v1));  
        BigDecimal b2 = new BigDecimal(Double.toString(v2));  
        return b1.subtract(b2).doubleValue();  
    }  
  
    /** 
     * 说明： 
     * 提供精确的乘法运算  
     * 创建日期: 2013-9-28 
     *  
     * @param v1 
     * @param v2 
     * @return 
     */  
    public static double mul(double v1, double v2) {  
        BigDecimal b1 = new BigDecimal(Double.toString(v1));  
        BigDecimal b2 = new BigDecimal(Double.toString(v2));  
        return b1.multiply(b2).doubleValue();  
    }  
  
    /** 
     * 说明： 
     * 提供相对精确的除法运算，当发生除不尽的情况，精确到.后10位 
     * 创建人: 李林君 邮箱  
     * 创建日期: 2013-9-28 
     *  
     * @param v1 
     * @param v2 
     * @return 
     */  
    public static double div(double v1, double v2) {  
        return div(v1, v2, DEF_DIV_SCALE);  
    }  
  
    /** 
     * 说明： 
     * 创建人: 李林君 邮箱：  
     * 创建日期: 2013-9-28 
     *  
     * @param v1 
     * @param v2 
     * @param scale 
     * @return 
     */  
    public static double div(double v1, double v2, int scale) {  
        if (scale < 0) {  
            throw new IllegalArgumentException(" the scale must be a positive integer or zero");  
        }  
        BigDecimal b1 = new BigDecimal(Double.toString(v1));  
        BigDecimal b2 = new BigDecimal(Double.toString(v2));  
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();// scale 后的四舍五入  
    }  

}
