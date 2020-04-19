package mx.unnamed.scf.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.unnamed.scf.model.Coupon;
import mx.unnamed.scf.model.Product;
import mx.unnamed.scf.repository.ProductRepository;
import mx.unnamed.scf.restclient.CouponClient;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {

	@Autowired
	CouponClient couponClient; 
	
	@Autowired
	private ProductRepository productRepository;
	
	@HystrixCommand(fallbackMethod = "sendErrorResponse")
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public Product create(@RequestBody Product product) {
		
		Coupon coupon = couponClient.getCoupon(product.getCouponCode());
		
		//Reducing the price :
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		
		return productRepository.save(product);
	}

	public Product sendErrorResponse(Product product) {

		return product;
	}
}
