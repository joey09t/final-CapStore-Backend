package com.cg.controller;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cg.bean.User1;
import com.cg.bean.Transaction;
import com.cg.bean.Wishlist;
import com.cg.service.CustomerService;
import com.cg.service.PhotoUpload;

@CrossOrigin("http://localhost:4200")
@RestController
public class CustomerController {
	@Autowired CustomerService service;
	
	 private final PhotoUpload fileService;



	 public CustomerController(PhotoUpload fileService) {

	 this.fileService = fileService;}
	
	@PutMapping("customer/update")
	public void changeCustomerDetails(@RequestBody User1 User) {
		service.update(User);
		
	}
	
	@GetMapping("customer/getWishlist/{uid}")
	public List<Wishlist> getAllWishlist(@PathVariable int uid){
		
		List<Wishlist> lst = service.fetchWishlist(uid);
		return lst;
		
	}
	
	@GetMapping("customer/{uid}")
	public User1 getUser(@PathVariable int uid){
		
		User1 user = service.findUser(uid);
		return user;
		
	}
	
	@GetMapping("customer/getStatus/{transactionId}")
	public List<Transaction> getAllStatus(@PathVariable int transactionId)
	{	
		List<Transaction> lst=service.fetchStatus(transactionId);
		return lst;
	}
	@PostMapping(value = "/api/files")

	 public void handleFileUpload(@RequestParam("file") MultipartFile file,@RequestHeader("Number")String filler) throws IOException {
		System.out.println("accept"+filler);
	 fileService.storeFile(file,filler);

	 }
	

}
