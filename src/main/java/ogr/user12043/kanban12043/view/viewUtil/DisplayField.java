package ogr.user12043.kanban12043.view.viewUtil;

import ogr.user12043.kanban12043.utils.Constants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by user12043 on 11.07.2018 - 11:01
 * Part of project: kanban12043
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DisplayField {
    String value() default Constants.defaultName;

    String keyParam() default "";

    String staticMethod() default "";
}
