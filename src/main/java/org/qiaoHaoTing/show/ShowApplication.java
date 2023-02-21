package org.qiaoHaoTing.show;

import com.alibaba.dubbo.common.serialize.support.hessian.Hessian2SerializerFactory;
import com.caucho.hessian.io.HessianFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class ShowApplication {

	@Autowired
	HttpComponentsClientHttpRequestFactory httpRequestFactory;

	HessianProxyFactoryBean hessianProxyFactoryBean;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate(httpRequestFactory);
	}

	public static void main(String[] args) {
		SpringApplication.run(ShowApplication.class, args);
	}

}
