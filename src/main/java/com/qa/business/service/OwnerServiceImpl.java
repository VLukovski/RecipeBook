package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.OwnerRepository;

public class OwnerServiceImpl implements OwnerService {

	@Inject
	private OwnerRepository repo;

	@Override
	public String getAllOwners() {
		return repo.getAllOwners();
	}

	@Override
	public String addOwner(String owner) {
		return repo.createOwner(owner);
	}

	@Override
	public String getAnOwner(Long id) {
		return repo.getAnOwner(id);
	}

	@Override
	public String updateOwner(String owner, Long id) {
		return repo.updateOwner(owner, id);
	}

	@Override
	public String deleteOwner(Long id) {
		return repo.deleteOwner(id);
	}

	@Override
	public int cycleOwners(String firstName) {
		return repo.cycleOwners(firstName);
	}

}
