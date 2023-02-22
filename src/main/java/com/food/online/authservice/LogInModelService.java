package com.food.online.authservice;

import com.food.online.authexceptions.AuthorizationException;
import com.food.online.authmodels.LogInModel;

public interface LogInModelService {
	
	public String LogIn(LogInModel login) throws AuthorizationException;
	
	public String LogOut(String key) throws AuthorizationException;

}
