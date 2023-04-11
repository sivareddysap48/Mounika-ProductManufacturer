package com.example.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.product.constant.WarehouseConstant;
import com.example.product.dto.WarehouseDTO;
import com.example.product.request.WarehouseRequest;
import com.example.product.response.WarehouseResponse;
import com.example.product.serviceimpl.WarehouseServiceImpl;

@RestController
public class WarehouseController {
	
	private final static Logger logger=LoggerFactory.getLogger(WarehouseController.class); 
	
	@Value("${server.port}")
	int port;
	
	@Value("${spring.application.name}")
	String appname;
	
	@Autowired
	WarehouseServiceImpl warehouseserviceimpl;
	@PostMapping("/createproduct")
	public WarehouseResponse createProductController(@RequestBody List<WarehouseRequest> warehouseRequest)
	{
		logger.info("Product creation in controller");
		WarehouseResponse response=new WarehouseResponse();
		try
		{
			String success=warehouseserviceimpl.createProductService(warehouseRequest);

			response.setMessage(success);
			response.setStatuscode(WarehouseConstant.SUCESS_CODE);
			response.setPort(port);
			response.setAppname(appname);		
		}catch(Exception e) {
			response.setMessage(WarehouseConstant.INSERTFAIL_MSG);
			response.setStatuscode(WarehouseConstant.NOCONTENT_CODE);
			response.setPort(port);
			response.setAppname(appname);
		}
		logger.info("***END---createproduct()");
		return response;
	}
	
	@GetMapping
	public WarehouseResponse getProductsController()
	{
		WarehouseResponse response = new WarehouseResponse();
		logger.info("***START---getallproduct()");
		try {
			List<WarehouseDTO> allproductdetals = warehouseserviceimpl.getProdcutsService();
			response.setProductDetails(allproductdetals);
			response.setStatuscode(WarehouseConstant.SUCESS_CODE);
			response.setMessage(WarehouseConstant.SUCESS_MSG);
			response.setPort(port);
			response.setAppname(appname);
		} catch (Exception e) {
			response.setProductDetails(null);
			response.setStatuscode(WarehouseConstant.NOCONTENT_CODE);
			response.setMessage(WarehouseConstant.NOCONTENT_MSG);
			response.setPort(port);
			response.setAppname(appname);
		}
		logger.info("***END---getallproduct()-RESPONSE {} " + response);
		return response;
	}
	
	@GetMapping("/getproductbyid/{id}")
	public WarehouseResponse getProductByIdController(@PathVariable int id)
	{
		logger.info("***START---getproductbyid() id{} " + id);
		WarehouseResponse response = new WarehouseResponse();
		try {
			List<WarehouseDTO> productList = warehouseserviceimpl.getProductByIdService(id);
			response.setProductDetails(productList);
			response.setStatuscode(WarehouseConstant.SUCESS_CODE);
			response.setMessage(WarehouseConstant.SUCESS_MSG);
			response.setPort(port);
			response.setAppname(appname);
		} catch (Exception e) {
			response.setProductDetails(null);
			response.setStatuscode(WarehouseConstant.NOCONTENT_CODE);
			response.setMessage(WarehouseConstant.NOCONTENT_MSG);
			response.setPort(port);
			response.setAppname(appname);
		}
		logger.info("***getproductbyid() RESPONSE{} ***" + response);
		return response;
	}
	
	@PutMapping("/updateproduct/{id}")
	public WarehouseResponse updateProductController(@RequestBody WarehouseRequest warehouseRequest,@PathVariable int id)
	{
		logger.info("***START---updateproduct() id{} " + id + "Product{}" + warehouseRequest);
		WarehouseResponse response = new WarehouseResponse();
		try {
			warehouseRequest.setId(id);
			String statusMsg = warehouseserviceimpl.updateProductService(warehouseRequest);
			response.setProductDetails(null);
			response.setStatuscode(WarehouseConstant.SUCESS_CODE);
			response.setMessage(statusMsg);
			response.setPort(port);
			response.setAppname(appname);
		} catch (Exception e) {
			response.setProductDetails(null);
			response.setStatuscode(WarehouseConstant.NOCONTENT_CODE);
			response.setMessage(WarehouseConstant.NOCONTENT_MSG);
			response.setPort(port);
			response.setAppname(appname);
		}
		logger.info("***END---updateproduct()*** RESPONSE" + response);
		return response;
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public WarehouseResponse deleteProductController(@PathVariable int id)
	{
		logger.info("***START---updateproduct() id{} " + id);
		WarehouseResponse response = new WarehouseResponse();
		try {
			warehouseserviceimpl.deleteProductService(id);
			response.setProductDetails(null);
			response.setStatuscode(WarehouseConstant.SUCESS_CODE);
			response.setMessage(WarehouseConstant.SUCESS_MSG);
			response.setPort(port);
			response.setAppname(appname);
		} catch (Exception e) {
			response.setProductDetails(null);
			response.setStatuscode(WarehouseConstant.NOCONTENT_CODE);
			response.setMessage(WarehouseConstant.NOCONTENT_MSG);
			response.setPort(port);
			response.setAppname(appname);
		}
		logger.info("***END---deleteproduct()*** RESPONSE{} " + response);
		return response;
	}
	
}
