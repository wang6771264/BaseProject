package maple.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {TestA.Checker.class})
public @interface TestA {
	String message() default "名称不存在";  
	
	String associatedField();
	
	Class<?> clazz();
	
    Class<?>[]groups() default {};  
  
    Class<? extends Payload>[]payload() default {};  
    
    public static class Checker implements ConstraintValidator<TestA, Object> {  
  
        @Override  
        public void initialize(TestA constraintAnnotation) {  
        	
        }  
  
        @Override  
        public boolean isValid(Object value, ConstraintValidatorContext context) {  
            if ("111111".equals(value)) {  
                return true;  
            }  
            return false;  
        }  
  
    }  
}