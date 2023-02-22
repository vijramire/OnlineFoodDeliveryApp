package com.food.online.authservice;

import com.food.online.authexceptions.AuthorizationException;
import com.food.online.authmodels.SignUpModel;
import com.food.online.authmodels.UserSession;

public interface UserSessionService {
	
	public UserSession getUserSession(String key) throws AuthorizationException;
	
	public Integer getUserSessionId(String key) throws AuthorizationException;
	
	public SignUpModel getSignUpDetails(String key) throws AuthorizationException;
	

}
