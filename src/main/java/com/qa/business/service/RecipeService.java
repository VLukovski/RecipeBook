package com.qa.business.service;

public interface RecipeService {

	String addRecipe(String recipe);
	
	String getAllRecipes();
	
	String getARecipe(Long id);

	String updateRecipe(String recipe, Long id);

	String deleteRecipe(Long id);
	
	int cycleRecipes(String recipeName);

}
