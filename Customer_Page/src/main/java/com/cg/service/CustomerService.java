package com.cg.service;

import java.util.List;

import com.cg.bean.Transaction;
import com.cg.bean.User1;
import com.cg.bean.Wishlist;

public interface CustomerService {

	public void update(User1 customer);
	public User1 findUser(int uid);
	public List<Wishlist> fetchWishlist(int uid);
	public List<Transaction> fetchStatus(int transactionId);

}
