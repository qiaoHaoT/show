package org.qiaoHaoTing.show.config;

import org.mitre.dsmiley.httpproxy.ProxyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean<ProxyServlet> CSNDServletServletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new ProxyServlet(), "/csdn/*");
        servletRegistrationBean.setName("csnd-proxy");
        servletRegistrationBean.addInitParameter("targetUri", "https://blog.csdn.net/");
        servletRegistrationBean.addInitParameter("http.read.timeout", "10000");
        servletRegistrationBean.addInitParameter("http.socket.timeout", "10000");
        servletRegistrationBean.addInitParameter("http.connection.request.timeout", "3000");
        servletRegistrationBean.addInitParameter("log", "true");
        return servletRegistrationBean;
    }

    @Bean
    public ServletRegistrationBean<ProxyServlet> localServletServletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new ProxyServlet(), "/local/*");
        servletRegistrationBean.setName("local-proxy");
        servletRegistrationBean.addInitParameter("targetUri", "http://127.0.0.1:8080/");
        servletRegistrationBean.addInitParameter("http.read.timeout", "10000");
        servletRegistrationBean.addInitParameter("http.socket.timeout", "10000");
        servletRegistrationBean.addInitParameter("http.connection.request.timeout", "3000");
        servletRegistrationBean.addInitParameter("log", "true");
        return servletRegistrationBean;
    }


}
