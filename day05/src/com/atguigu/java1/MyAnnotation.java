package com.atguigu.java1;



import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE,FIELD,METHOD,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
@Repeatable(MyAnnotations.class)
public @interface MyAnnotation {
    String value() default "hello";
}
