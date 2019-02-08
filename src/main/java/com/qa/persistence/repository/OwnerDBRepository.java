package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Owner;
import com.qa.persistence.domain.Recipe;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class OwnerDBRepository implements OwnerRepository{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
	
	@Override
	public String getAllOwners() {
		Query query = manager.createQuery("Select a FROM Owner a");
		Collection<Owner> owners = (Collection<Owner>) query.getResultList();
		
		return util.getJSONForObject(owners);
	}
	
	@Override
	@Transactional(REQUIRED)
	public String createOwner(String owner) {
		Owner anOwner = util.getObjectForJSON(owner, Owner.class);
		manager.persist(anOwner);
		return "{\"message\": \"owner has been sucessfully added\"}";
	}
	
	@Override
	@Transactional(REQUIRED)
	public String deleteOwner(Long id) {
		Owner ownerInDb = util.getObjectForJSON(getAnOwner(id), Owner.class);
		
		if (manager.contains(manager.find(Owner.class, id))) {
			manager.remove(manager.find(Owner.class, id));
		}
		return "{\"message\": \"owner sucessfully deleted\"}";
	}

	@Override
	public String getAnOwner(Long id) {
		return util.getJSONForObject(manager.find(Owner.class, id));
	}
	
	@Override
	public String updateOwner(String owner, Long id) {
		// TODO Auto-generated method stub
		return "Finish this functionality pls";
	}
	
	@Override
	public int cycleOwners(String firstName) {

		Query query = manager.createQuery("Select a FROM Owner a");
		Collection<Owner> owners = (Collection<Owner>) query.getResultList();

		List<Owner> validList = owners.stream().filter(n -> n.getFirstName().equals(firstName)).collect(Collectors.toList());

		return validList.size();
	}
}
