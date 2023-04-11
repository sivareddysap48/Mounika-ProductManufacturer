package com.example.product.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.dao.WarehouseDAO;
import com.example.product.dto.WarehouseDTO;
import com.example.product.model.WarehouseProduct;
import com.example.product.request.WarehouseRequest;
import com.example.product.service.WarehouseService;

@Service
public class WarehouseServiceImpl  implements WarehouseService{
	
	@Autowired
	WarehouseDAO warehouseDAO;
	
	private static final Logger logger=LoggerFactory.getLogger(WarehouseServiceImpl.class);

	public String createProductService(List<WarehouseRequest> product) {
		logger.info("***START--createmyproduct()-- product{}" + product);
		String statusMsg = "";
		List<WarehouseRequest> myproduct = product;
		List<WarehouseProduct> toproduct = new ArrayList<WarehouseProduct>();
		for (WarehouseRequest warehouseRequest : myproduct) {
			WarehouseProduct warehouseProduct = new WarehouseProduct();
			warehouseProduct.setId(warehouseRequest.getId());
			warehouseProduct.setWproductid(warehouseRequest.getWproductid());
			warehouseProduct.setWproductname(warehouseRequest.getWproductname());
			warehouseProduct.setWproductprice(warehouseRequest.getWproductprice());
			toproduct.add(warehouseProduct);
		}
		try {
			warehouseDAO.saveAll(toproduct);
			statusMsg = "Data Inserted sucessfully";
		} catch (Exception e) {
			statusMsg = "Exception occured while Inserting the Data";
		}
		logger.info("***END--createmyproduct()-- product{}");
		return statusMsg;
		
		
	}

	public List<WarehouseDTO> getProdcutsService() {
		logger.info("***START--getmyproduct()--");
		List<WarehouseDTO> lisTo = new ArrayList<WarehouseDTO>();
		List<WarehouseProduct> myproduct = warehouseDAO.findAll();
		for (WarehouseProduct warehouseProduct : myproduct) {
			WarehouseDTO to = new WarehouseDTO();
			to.setId(warehouseProduct.getId());
			to.setWproductid(warehouseProduct.getWproductid());
			to.setWproductname(warehouseProduct.getWproductname());
			to.setWproductprice(warehouseProduct.getWproductprice());
			lisTo.add(to);
		}
		logger.info("***START--getmyproduct()--RESPONSE{} " + lisTo);
		return lisTo;
	}

	public List<WarehouseDTO> getProductByIdService(int id) {
		logger.info("***START--getbyidmyproduct()-- id{}" + id);
		List<WarehouseDTO> producrList = new ArrayList<WarehouseDTO>();
		WarehouseDTO to = new WarehouseDTO();
		Optional<WarehouseProduct> productbyid = warehouseDAO.findById(id);
		logger.info("***productbyid ***" + productbyid);
		to.setId(productbyid.get().getId());
		to.setWproductid(productbyid.get().getWproductid());
		to.setWproductname(productbyid.get().getWproductname());
		to.setWproductprice(productbyid.get().getWproductprice());
		producrList.add(to);
		logger.info("***END--getbyidmyproduct()--RESPONSE{} " + producrList);
		return producrList;
		
	}

	public String updateProductService(WarehouseRequest warehouseRequest) {
		logger.info("***START--updatemyproduct()-- product{}" + warehouseRequest);
		String statusMsg = "";
		WarehouseRequest myproduct = warehouseRequest;
		WarehouseProduct toproduct = new WarehouseProduct();
		toproduct.setId(myproduct.getId());
		toproduct.setWproductid(myproduct.getWproductid());
		toproduct.setWproductname(myproduct.getWproductname());
		toproduct.setWproductprice(myproduct.getWproductprice());
		try {
			warehouseDAO.save(toproduct);
			statusMsg = "Data Updated sucessfully";
		} catch (Exception e) {
			statusMsg = "Exception occured while Updating the Data";
		}
		logger.info("***END--updatemyproduct()-- product{}" + statusMsg);
		return statusMsg;
		
	}

	public boolean deleteProductService(int id) {
		logger.info("***START--deletemyproduct()-- id{}" + id);
		boolean success = false;
		warehouseDAO.deleteById(id);
		success = true;
		logger.info("***END--deletemyproduct()--");
		return success;
		
	}
}
