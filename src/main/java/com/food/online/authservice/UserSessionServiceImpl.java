package com.food.online.authservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.online.authexceptions.AuthorizationException;
import com.food.online.authmodels.SignUpModel;
import com.food.online.authmodels.UserSession;
import com.food.online.authrepository.SignUpModelDAO;
import com.food.online.authrepository.UserSessionDAO;

@Service
public class UserSessionServiceImpl implements UserSessionService {

	@Autowired
	private UserSessionDAO userSessionDAO;
	
	@Autowired
	private SignUpModelDAO signUpDAO;
	
	
	
	@Override
	public UserSession getUserSession(String key) throws AuthorizationException {
		
		Optional<UserSession> currentUser = userSessionDAO.findByUUID(key);
		if(!currentUser.isPresent())
		{
			throw new AuthorizationException("Not Authorized..!!");
		}
		return currentUser.get();
	}

	@Override
	public Integer getUserSessionId(String key) throws AuthorizationException {
		
		Optional<UserSession> currentUser = userSessionDAO.findByUUID(key);
		if(!currentUser.isPresent())
		{
			throw new AuthorizationException("Not Authorized..!!");
		}
		return currentUser.get().getId();
		
	}


	@Override
	public SignUpModel getSignUpDetails(String key) {
		
		Optional<UserSession> currentUser = userSessionDAO.findByUUID(key);
		if(!currentUser.isPresent())
		{
			return null;
		}
		Integer SignUpUserId = currentUser.get().getUserId();
		System.out.println(SignUpUserId );
		
		return (signUpDAO.findById(SignUpUserId)).get();
	}

}
