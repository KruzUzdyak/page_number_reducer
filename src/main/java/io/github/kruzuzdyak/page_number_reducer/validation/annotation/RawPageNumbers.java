package io.github.kruzuzdyak.page_number_reducer.validation.annotation;

import io.github.kruzuzdyak.page_number_reducer.validation.impl.RawPageNumbersConstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {RawPageNumbersConstraint.class})
public @interface RawPageNumbers {

    String message() default "Page numbers should be greater than 0 and separated with comma";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
