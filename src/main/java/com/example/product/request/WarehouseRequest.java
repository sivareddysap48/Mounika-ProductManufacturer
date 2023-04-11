package com.example.product.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WarehouseRequest {

	private int id;
	private String wproductid;
	private String wproductname;
	private long wproductprice;
}
