package cn.chaohi.recommend;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@ComponentScan("cn.chaohi")
@MapperScan("cn.chaohi.recommend.mapper")
@SpringBootApplication
public class RecommendApplication {
	
	private static final Logger log = LoggerFactory.getLogger(RecommendApplication.class);

    /**
     * Start
     */
    public static void main(String[] args) {
    	SpringApplication app = new SpringApplication(RecommendApplication.class);
        Environment env = app.run(args).getEnvironment();
        try {
			log.info("Access URLs:\n----------------------------------------------------------\n" +
			        "\tLocal: \thttp://127.0.0.1:{}{}/swagger-ui.html\n" +
			        "\tExternal: \thttp://{}:{}{}/swagger-ui.html\n----------------------------------------------------------",
			    env.getProperty("server.port"),env.getProperty("server.contextPath"),
			    InetAddress.getLocalHost().getHostAddress(),
			    env.getProperty("server.port"),env.getProperty("server.contextPath"));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
        log.info("SpringBoot Start Success");
    }

}
