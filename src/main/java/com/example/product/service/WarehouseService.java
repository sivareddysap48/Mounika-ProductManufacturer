package com.example.product.service;

import java.util.List;

import com.example.product.dto.WarehouseDTO;
import com.example.product.request.WarehouseRequest;

public interface WarehouseService {
	
	public String createProductService(List<WarehouseRequest> product);
	
	public List<WarehouseDTO> getProdcutsService();
	
	public List<WarehouseDTO> getProductByIdService(int id);
	
	public String updateProductService(WarehouseRequest warehouseRequest);
	
	public boolean  deleteProductService(int id);

}
