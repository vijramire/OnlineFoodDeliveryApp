package com.food.online.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food.online.authexceptions.AuthorizationException;
import com.food.online.authservice.UserSessionService;
import com.food.online.exceptions.CartException;
import com.food.online.exceptions.ItemException;
import com.food.online.model.FoodCart;
import com.food.online.serverice.FoodCartService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/cart")
public class FoodCartServiceController {
	
	@Autowired
	FoodCartService cartService;
	
	@Autowired
	UserSessionService userSessionService;
	
	
	@PostMapping("/register")
	public ResponseEntity<FoodCart> saveCartDetails(@RequestParam String key,@RequestBody FoodCart fc) throws CartException, AuthorizationException
	{
				Integer sessionId = userSessionService.getUserSessionId(key);
				
				if(fc!=null && sessionId != null) {
	            FoodCart f= cartService.saveCart(fc);
	            	return new ResponseEntity<FoodCart>(f,HttpStatus.CREATED);
	            }
	            throw new CartException();
	}
	
	
	@PutMapping("/add/{cartId}/{itemId}")
	public ResponseEntity<FoodCart> addItemToCart(@PathVariable("cartId") Integer cartId, @PathVariable("itemId") Integer itemId) throws CartException, ItemException{
		FoodCart updatedCart = cartService.addItem(cartId, itemId);
		return new ResponseEntity<FoodCart>(updatedCart, HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/remove/{cartId}")
	public ResponseEntity<FoodCart> removeCart(@PathVariable("cartId") Integer cartId) throws CartException{
		FoodCart removedCart = cartService.clearCart(cartId);
		return new ResponseEntity<FoodCart>(removedCart, HttpStatus.OK);
	}
	
	
	@GetMapping("/view/{cartId}")
	public FoodCart getCartByCartId(@PathVariable ("cartId") Integer cartId,@RequestParam String key) throws AuthorizationException, CartException{
		
		Integer sessionId = userSessionService.getUserSessionId(key);
		if(sessionId != null)
			return cartService.viewCart(cartId);
		else
			 throw new CartException();
			
	}

}
