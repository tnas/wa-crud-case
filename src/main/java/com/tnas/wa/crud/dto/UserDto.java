package com.tnas.wa.crud.dto;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Data Trasnfer Object for User")
@Getter @Setter
public class UserDto {
	
	@ApiModelProperty(notes = "Internal user ID", example = "1")
	private Long id;
	
	@ApiModelProperty(notes = "User name", example = "Thiago Nascimento", required = true)
	private String name;
	
	@ApiModelProperty(notes = "User document (e.g. CPF, RG)", example = "123.456.789-00", required = true)
	private String document;
	
	@ApiModelProperty(notes = "User creation date", example = "2022-12-01T11:10:06.330419498")
	private LocalDateTime creationDate;
	
	@ApiModelProperty(notes = "User update date", example = "2022-12-01T11:10:06.330419498")
	private LocalDateTime updateDate;
}
