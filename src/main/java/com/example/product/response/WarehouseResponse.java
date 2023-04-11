package com.example.product.response;

import java.util.List;

import com.example.product.dto.WarehouseDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Setter
@Getter
public class WarehouseResponse {

	private int statuscode;
	private String message;
	private int port;
	private String appname;
	private List<WarehouseDTO> productDetails;
	


}
