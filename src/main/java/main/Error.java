package main;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface REM {
	String value() default "";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Leet {
	String value() default "";
}

public class Error {
	public static void fatal(String messge) {
		System.out.println("ERROR: " + messge);
		System.exit(1);
	}
	
	public static void error(String messge) {
		System.out.println("ERROR: " + messge);
		System.exit(1);
	}
}
