package com.example.sunminprac.annotation;



import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD}) // 1
@Retention(RetentionPolicy.RUNTIME) // 2
@RestController
public @interface conAnnotation {
}
