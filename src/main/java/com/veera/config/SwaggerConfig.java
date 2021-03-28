package com.veera.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger configuration class to generate API documentation
 * 
 * @author Veera.Shankara
 *
 */
@Configuration
public class SwaggerConfig {
	/**
	 * This method is used generate the API documentation using Swagger 2 API
	 * 
	 * @return Docket
	 */
	@Bean
	public Docket apiDoc() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.veera"))
				.paths(PathSelectors.any()).build().apiInfo(metaData());
	}

	/**
	 * This method generates the metadata for the Swagger Dashboard
	 * 
	 * @return ApiInfo
	 */
	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("SmartDubai - Veera")
				.description("\"SmartDubai Online Bookstore Interview Assessment\"").version("1.0.0")
				.contact(new Contact("Veera Shankara Ravindra Reddy Kakarla", "www.google.com",
						"kvsravindrareddy@gmail.com"))
				.build();
	}
}