package com.cbic.microservices.tickerservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class Config {

	/*@Bean
    public RestTemplate template() {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectionRequestTimeout(4000);
        httpRequestFactory.setConnectTimeout(4000);
        httpRequestFactory.setReadTimeout(4000);
        return new RestTemplate(httpRequestFactory);
    }*/
	
	
	@Bean(name = "db-cbic-production")
	@ConfigurationProperties(prefix = "spring.db-cbic-production")
	@Primary
	public DataSource createCbicProductionServiceDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "db-admin-module")
	@ConfigurationProperties(prefix = "spring.db-admin-module")
	public DataSource createAdminModuleDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "jdbcCbicProduction")
	@Autowired
	public JdbcTemplate createJdbcTemplate_CbicWebsitesService(@Qualifier("db-cbic-production") DataSource cbicProductionDS) {
		return new JdbcTemplate(cbicProductionDS);
	}

	@Bean(name = "jdbcAdminModule")
	@Autowired
	public JdbcTemplate createJdbcTemplate_AdminModuleService(@Qualifier("db-admin-module") DataSource adminModuleDS) {
		return new JdbcTemplate(adminModuleDS);
	}

}
