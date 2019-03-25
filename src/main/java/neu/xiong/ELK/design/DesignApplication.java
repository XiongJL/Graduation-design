package neu.xiong.ELK.design;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DesignApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignApplication.class, args);
	}
	
	/**
	 * http 重定向到https
	 */
	@Bean
	public TomcatServletWebServerFactory sesrvletContainer(){
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory(){
			protected void postProcessContext(Context context){
				SecurityConstraint cons = new SecurityConstraint();
				cons.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				cons.addCollection(collection);
				context.addConstraint(cons);
			}
		};
		tomcat.addAdditionalTomcatConnectors(httpConnector());
		return tomcat;
	}
	@Bean
	public Connector httpConnector() {
		Connector conn = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		conn.setScheme("http");
		//Connector监听的http的端口号
	      conn.setPort(8080);
	      conn.setSecure(false);
	      //监听到http的端口号后转向到的https的端口号
	      conn.setRedirectPort(443);
	      return conn;
	}
}
