package lines.imgupload.demo.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors
                .basePackage("com"))
            .paths(PathSelectors.regex("/.*"))
            .build().apiInfo(apiEndPointsInfo())
            .useDefaultResponseMessages(false)
            .globalResponseMessage(RequestMethod.GET, errorList())
            .globalResponseMessage(RequestMethod.POST, errorList())
            .globalResponseMessage(RequestMethod.PUT, errorList())
            .globalResponseMessage(RequestMethod.DELETE, errorList());
    }
	
	private List<ResponseMessage> errorList() {

	    List<ResponseMessage> errorList = new ArrayList<ResponseMessage>();

	    errorList.add(new ResponseMessageBuilder().code(200).message("OK")
	            .responseModel(new ModelRef("string")).build());

	    errorList.add(new ResponseMessageBuilder().code(201).message("No Content")
	            .responseModel(new ModelRef("string")).build());

	    errorList.add(new ResponseMessageBuilder().code(202).message("Partial Content")
	            .responseModel(new ModelRef("string")).build());
	    
	    errorList.add(new ResponseMessageBuilder().code(301).message("Moved Permanently")
	            .responseModel(new ModelRef("string")).build());
	    
	    errorList.add(new ResponseMessageBuilder().code(302).message("Found")
	            .responseModel(new ModelRef("string")).build());
	    
	    errorList.add(new ResponseMessageBuilder().code(303).message("See Other")
	            .responseModel(new ModelRef("string")).build());
	    
	    errorList.add(new ResponseMessageBuilder().code(304).message("Not Modified")
	            .responseModel(new ModelRef("string")).build());
	    
	    errorList.add(new ResponseMessageBuilder().code(307).message("Temporary Redirect")
	            .responseModel(new ModelRef("string")).build());
	    
	    errorList.add(new ResponseMessageBuilder().code(400).message("Bad Request")
	            .responseModel(new ModelRef("string")).build());
	    
	    errorList.add(new ResponseMessageBuilder().code(401).message("Unauthorized")
	            .responseModel(new ModelRef("string")).build());
	    
	    errorList.add(new ResponseMessageBuilder().code(403).message("Forbidden")
	            .responseModel(new ModelRef("string")).build());
	    
	    errorList.add(new ResponseMessageBuilder().code(404).message("Not Found")
	            .responseModel(new ModelRef("string")).build());
	    
	    errorList.add(new ResponseMessageBuilder().code(405).message("Method Not Allowed")
	            .responseModel(new ModelRef("string")).build());

	    errorList.add(new ResponseMessageBuilder().code(500).message("Internel Server Error")
	            .responseModel(new ModelRef("string")).build());

	    errorList.add(new ResponseMessageBuilder().code(503).message("Service Unablable")
	            .responseModel(new ModelRef("string")).build());
	    
	    errorList.add(new ResponseMessageBuilder().code(504).message("Gateway Timeout")
	            .responseModel(new ModelRef("string")).build());
	    
	    errorList.add(new ResponseMessageBuilder().code(505).message("HTTP Version Not Supported")
	            .responseModel(new ModelRef("string")).build());
	    return errorList;
	}
	
    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Lines API")
            .description("Lines REST API")
            .contact(new Contact("Lines", "1Lines", "1lines.maker@gmail.com"))
            .version("1.0.0.0")
            .build();
    }
}


