package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Owner {
	public Owner() {
	}
	
	public Owner(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long ownerId;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ownerId", cascade=CascadeType.ALL)
	private List<Recipe> recipeList = new ArrayList<Recipe>();
	private String firstName;
	private String lastName;
	
	public List<Recipe> getRecipes() {
		return recipeList;
	}

	public void setRecipes(List<Recipe> recipeList) {
		this.recipeList = recipeList;
	}

	public Long getId() {
		return ownerId;
	}
	public void setId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
