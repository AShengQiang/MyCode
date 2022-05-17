package com.demo.validator;

import com.demo.utils.MobileValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsMobileValidator implements ConstraintValidator<IsMobile,String> {
    private boolean required = false;
    @Override
    public void initialize(IsMobile constraintAnnotation) {
         required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(required){
            return MobileValidator.isMobile(s);
        }else{
            if(s.isEmpty()){
                return true;
            }else{
                return MobileValidator.isMobile(s);
            }
        }
    }
}
