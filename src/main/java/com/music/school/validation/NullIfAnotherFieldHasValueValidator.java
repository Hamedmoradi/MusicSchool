package com.music.school.validation;


import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.music.school.exception.InputDataException;
import com.music.school.exception.MusicSchoolBaseBusinessException;
import org.apache.commons.beanutils.BeanUtils;

/**
 * Implementation of {@link NullIfAnotherFieldHasValue} validator.
 **/
public class NullIfAnotherFieldHasValueValidator
        implements ConstraintValidator<NullIfAnotherFieldHasValue, Object> {

    private String fieldName;
    private String expectedFieldValue;
    private String dependFieldName;
    private String match;
    private String messages;

    @Override
    public void initialize(NullIfAnotherFieldHasValue annotation) {
        fieldName = annotation.fieldName();
        expectedFieldValue = annotation.fieldValue();
        dependFieldName = annotation.dependFieldName();
        match = annotation.match();
        if (match.equals("true")) {
            messages = annotation.message();
        } else {
            messages = "{invalid.field.structure}";}
    }


    @Override
    public boolean isValid(Object value, ConstraintValidatorContext ctx) {

        if (value == null) {
            return true;
        }

        try {
            String fieldValue = BeanUtils.getProperty(value, fieldName);
            String dependFieldValue = BeanUtils.getProperty(value, dependFieldName);

            if (expectedFieldValue.equals(fieldValue) && dependFieldValue.equals("")) {
                ctx.disableDefaultConstraintViolation();
                ctx.buildConstraintViolationWithTemplate(ctx.getDefaultConstraintMessageTemplate())
                        .addNode(dependFieldName)
                        .addConstraintViolation();
                return true;
            }
            if (fieldName.equals("emailChecked")) {
                return isValidRegex(dependFieldValue, "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$");

            } else if (fieldName.equals("smsChecked")) {
                return isValidRegex(dependFieldValue, "\\d{11}");
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException
                |MusicSchoolBaseBusinessException ex) {
            throw new InputDataException();
        }

        return false;
    }

    private boolean isValidRegex(String dependFieldValue, String s) {
        final AtomicReference<Pattern> validRegex =
                new AtomicReference<>(Pattern.compile(s, Pattern.CASE_INSENSITIVE));
        Matcher matcher = validRegex .get().matcher(dependFieldValue);
        return checkMatcher(matcher);
    }

    private boolean checkMatcher(Matcher matcher) {
        return matcher.matches();
    }

}