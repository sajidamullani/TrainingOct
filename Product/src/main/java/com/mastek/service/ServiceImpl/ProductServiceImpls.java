package com.mastek.service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastek.dao.ProductDao;
import com.mastek.exception.BusinessException;
import com.mastek.model.Product;
import com.mastek.service.ProductService;

@Service
public class ProductServiceImpls implements ProductService {
	@Autowired
	private ProductDao pdao;

	public ProductServiceImpls() {

	}

	@Override
	public Product createProduct(Product product) {
		if (product.getName().isEmpty() || product.getName().length() == 0 || product.getDescription().isEmpty()
				|| product.getDescription().length() == 0 || product.getUrl().isEmpty()
				|| product.getUrl().length() == 0 || product.getPrice() == 0) {
			throw new BusinessException("601", "Please send proper fields, its blank");
		}
		try {
			return pdao.save(product);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("602", "given product is null");
		} catch (Exception e) {
			throw new BusinessException("603", "Something went wrong in service layer");
		}
	}

	@Override
	public Product getProduct(Long id) {
		try {
			return pdao.findById(id).get();
		} catch (IllegalArgumentException e) {
			throw new BusinessException("612", "id mismatch");
		} catch (Exception e) {
			throw new BusinessException("613", "service layer error");
		}
	}

	@Override
	public Product updateProduct(Product product) {
		if (product.getName().isEmpty() || product.getName().length() == 0 || product.getDescription().isEmpty()
				|| product.getDescription().length() == 0 || product.getUrl().isEmpty()
				|| product.getUrl().length() == 0 || product.getPrice() == 0) {
			throw new BusinessException("605", "Fields blank");
		}
		try {
			return pdao.save(product);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("606", "product is null");
		} catch (Exception e) {
			throw new BusinessException("607", "Something went wrong in service layer");
		}
	}

	@Override
	public void deleteProduct(Long id) {
		try {
			pdao.delete(this.getProduct(id));
		} catch (IllegalArgumentException e) {
			throw new BusinessException("608", "id mismatch");
		} catch (Exception e) {
			throw new BusinessException("609", "service layer error");
		}

	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> productlist = pdao.findAll();
		if (productlist.isEmpty()) {
			throw new BusinessException("611", "List is empty");
		}
		return productlist;
	}

}
