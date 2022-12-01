package com.tnas.wa.crud.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = """
		Object used for documentation purposes only. 
		It doesn't belong in the application's object model. 
		For all HTTP communications, the UserDto object must be used.
		""")
@Getter @Setter
public class UserParam {
	
	@ApiModelProperty(notes = "User name", example = "Thiago Nascimento", required = true)
	private String name;
	
	@ApiModelProperty(notes = "User document (e.g. CPF, RG)", example = "123.456.789-00", required = true)
	private String document;
}
