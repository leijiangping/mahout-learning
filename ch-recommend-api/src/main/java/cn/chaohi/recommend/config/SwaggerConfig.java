package cn.chaohi.recommend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by leijp on 2017/12/22
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig
{
	@Value("${sys.version}")
	private String systemPublish;
    
	@Bean
    public Docket CDFSApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("recommend")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
                /*.paths(or(regex("/api/.*")))*///过滤的接口
                //.paths(PathSelectors.none())//如果是线上环境，添加路径过滤，设置为全部都不符合  
                .build()
                .apiInfo(webApiInfo());
    }
    
    private ApiInfo webApiInfo() {
    	ApiInfo apiInfo = new ApiInfo("超嗨--推荐服务API",//大标题
                "",//小标题
                "1.0",//版本
                "www.chaohi.com",//服务条款网址
                "leijiang21@126.com",//联系人邮箱
                "The Apache License, Version 2.0",//链接显示文字
                "http://www.apache.org/licenses/LICENSE-2.0.html"//网站链接
        );
		return apiInfo;
    }
}