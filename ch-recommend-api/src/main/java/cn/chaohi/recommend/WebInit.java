package cn.chaohi.recommend;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@Configurable
public class WebInit extends SpringBootServletInitializer {
	private static Class<RecommendApplication> applicationClass = RecommendApplication.class;
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }
}