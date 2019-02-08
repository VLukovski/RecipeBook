package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Recipe {
	public Recipe() {
	}

	public Recipe(String recipeName, String description) {
		this.recipeName = recipeName;
		this.description = description;
	}

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long recipeId;
	
	private String recipeName;
	private String description;
	private Long ownerId;
	
	
	public Long getId() {
		return recipeId;
	}

	public void setId(Long recipeId) {
		this.recipeId = recipeId;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwner(Long ownerId) {
		this.ownerId = ownerId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
