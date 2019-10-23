package com.confing;


import com.interceptor.*;
/*import org.springframework.beans.factory.annotation.Configurable;*/
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyConfing implements WebMvcConfigurer{

@Override
public void addInterceptors(InterceptorRegistry registry){
     /*
         /index: 只拦截 index
	     /page/*:拦截 page 路径下的所有
	     /*: 拦截  / 路径下的所有
	     /**: 拦截  所有
        */
   /* registry.addInterceptor(new BaseInterceptor()).addPathPatterns("/test");*/

    registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/*");

    registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/*");
}
}
