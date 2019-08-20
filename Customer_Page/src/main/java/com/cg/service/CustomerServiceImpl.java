package com.cg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bean.Transaction;
import com.cg.bean.User1;
import com.cg.bean.Wishlist;
import com.cg.dao.CustomerDAO;
import com.cg.dao.WishlistDAO;
import com.cg.dao.TransactionDAO;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired CustomerDAO dao;
	@Autowired WishlistDAO dao1;
	@Autowired TransactionDAO dao2;

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(User1 customer) {
		
		dao.save(customer);
		
	}
	@Override
	public List<Wishlist> fetchWishlist(int uid) {
		List<Wishlist> lst = dao1.findAll(); 
		List<Wishlist> finalList = new ArrayList<>();
		
		for(Wishlist w : lst) {
			if(uid == w.getUser().getUserId())
			{
				finalList.add(w);
			}
		}
		
		return finalList;
	}
	@Override
	public User1 findUser(int uid) {
		List<User1> lst = dao.findAll(); 
		User1 user = new User1();
		for(User1 u: lst)
		{
			if(uid == u.getUserId())
			{
				user = u;
			}
		}
	
		return user;
	}
	@Override
	public List<Transaction> fetchStatus(int transactionId) {
		List<Transaction> lst=dao2.findAll();
		List<Transaction> finalList=new ArrayList<>();
		for(Transaction t:lst)
		{
			if(t.getStatus().equals("Delivered"))
			{
				finalList.add(t);
			}
		}
		return finalList;
	}
	
	

	
}
