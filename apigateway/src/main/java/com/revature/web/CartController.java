package com.revature.web;

import com.revature.beans.Cart;
import com.revature.beans.CartFormData;
import com.revature.beans.ItemDTO;
import com.revature.delegate.BusinessDelegate;
import com.revature.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private CartService cartService;
    @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    private BusinessDelegate delegate;
    @Autowired
    public void setDelegate(BusinessDelegate delegate) {this.delegate = delegate;}

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        return cartService.createCart(cart);
    }

    @RequestMapping(value="/getAllCartItems",
            method=RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ItemDTO>> getAllCartItems (@RequestBody CartFormData formData){
        return delegate.getAllCartItems(formData);
    }
}
