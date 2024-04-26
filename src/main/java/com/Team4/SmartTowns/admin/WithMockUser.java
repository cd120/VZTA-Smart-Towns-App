//package com.Team4.SmartTowns.admin;
//
//
//import java.lang.annotation.*;
//
//@Target({ElementType.METHOD, ElementType.TYPE})
//    @Retention(RetentionPolicy.RUNTIME)
//    @Inherited
//    @Documented
//    @WithSecurityContext(
//            factory = WithMockUserSecurityContextFactory.class
//    )
//    public @interface WithMockUser {
//        String value() default "user";
//
//        String username() default "";
//
//        String[] roles() default {"USER"};
//
//        String password() default "password";
//    }
//}
