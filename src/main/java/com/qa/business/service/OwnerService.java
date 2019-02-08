package com.qa.business.service;

public interface OwnerService {

	String addOwner(String owner);

	String getAllOwners();
	
	String getAnOwner(Long id);

	String updateOwner(String owner, Long id);

	String deleteOwner(Long id);
	
	int cycleOwners(String firstName);

}
