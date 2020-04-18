package mx.unnamed.scf.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import mx.unnamed.scf.model.Coupon;

@FeignClient("zuul-api-gateway")
public interface CouponClient {
	
	@GetMapping("/coupon-service/couponapi/coupons/{code}")
	Coupon getCoupon(@PathVariable("code") String code);
}
