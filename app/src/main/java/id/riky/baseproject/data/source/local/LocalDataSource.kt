package id.riky.baseproject.data.source.local

import id.riky.baseproject.data.source.local.room.RecipeDao

class LocalDataSource(private val recipeDao: RecipeDao) {
    // THIS FILE IS EXCLUDED FROM BUILD, FOR GRADLE BUILD PURPOSE ONLY... NEED TO BE FIXED LATER
    fun getAllFavoriteRecipe() =
        recipeDao.getAllFavoriteRecipe()

    suspend fun getFavoriteRecipeById(recipeKey: String) =
        recipeDao.getFavoriteRecipeById(recipeKey)

    suspend fun addRecipeToFavorite(recipe: RecipeEntity) =
        recipeDao.addRecipeToFavorite(recipe)

    suspend fun removeRecipeFromFavorite(recipe: RecipeEntity) =
        recipeDao.removeRecipeFromFavorite(recipe)
}