package com.food.online.serverice;

import com.food.online.exceptions.BillException;
import com.food.online.exceptions.CustomerException;
import com.food.online.exceptions.ItemException;
import com.food.online.model.Bill;

public interface BillService {
	
	public Bill addBill(Bill bill) throws BillException;
	
	public Bill updateBill(Bill bill)throws BillException;
	
	public Bill removeBill(Integer billId)throws BillException;
	
	public Bill viewBill(Integer billId)throws BillException;
	
	public String generateTotalBillById(Integer customerId)throws ItemException,CustomerException;
	

}
