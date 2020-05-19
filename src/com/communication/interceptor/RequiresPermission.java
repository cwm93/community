package com.communication.interceptor;


import java.lang.annotation.Retention;  
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType; 
/**
 * @author liliang
 *
 */
//用于约束被描述的注解的使用范围，当被描述的注解超出使用范围则编译失败。
@Target(ElementType.METHOD)
//作用范围为运行时，就是我们可以通过反射动态获取该注解。
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresPermission {
	String[] values() default {"USER"};
}
