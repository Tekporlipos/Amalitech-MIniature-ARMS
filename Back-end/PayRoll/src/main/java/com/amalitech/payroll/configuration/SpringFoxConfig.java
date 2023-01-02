package com.amalitech.payroll.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@Configuration
public class SpringFoxConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.amalitech.payroll"))
                .build()
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Amalitech Resource Management Planning System Payroll API",
                """
                        The payroll backend should be able to
                        1. create an allowance type
                        2. create a bonus type
                        3. create a bonus for an employee for the current month (bonus type and amount)
                        
                        Payroll front-end "The payroll front-end consumes the ARMS API, which in turn consumes the Payroll API.
                        
                        Steps involved
                        1. The payroll front-end makes a request to the ARMS API
                        2. The ARMS API makes a request to the payroll API
                        3. The payroll API returns the requested data to the ARMS API
                        4. The ARMS API returns the requested data to the payroll front-end 
                        5. The payroll front-end renders the data
                        
                        There should be a bonus section to add a bonus for an employee. (This data is stored  on the payroll database).
                        This section should also contain a list of employees with a  monthly bonus (information comes from payroll).
                        There should be a payroll section which displays all the payroll data for the month.  
                        Admin should be able to select a past month and see generated data. It should show  the current month by default (this information comes from payroll).
                        
                        
                        Admin should authorization from the ARMS platform to get the access token for the payroll api authentication
                        """,
                "1.0.0",
                "All right reserved.",
                new Contact("John Dzikunu", "www.amalitech.org", "john.dzikunu@amalitech.com"),
                "MIT", "", Collections.emptyList());
    }
}
