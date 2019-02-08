package com.qa.persistence.repository;

public interface OwnerRepository {
	
	String getAllOwners();
	
	String createOwner(String owner);
	
	String deleteOwner(Long id);
	
	String getAnOwner(Long id);
	
	String updateOwner(String owner, Long id);
	
	int cycleOwners(String firstName);

}
