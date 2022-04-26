package id.riky.baseproject.data.source.local.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

// THIS FILE IS EXCLUDED FROM BUILD, FOR GRADLE BUILD PURPOSE ONLY... NEED TO BE FIXED LATER
@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipe")
    fun getAllFavoriteRecipe(): Flow<List<RecipeEntity>>

    @Query("SELECT * FROM recipe WHERE `key` =:recipeKey")
    suspend fun getFavoriteRecipeById(recipeKey: String): RecipeItem?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRecipeToFavorite(recipe: RecipeEntity)

    @Delete
    suspend fun removeRecipeFromFavorite(recipe: RecipeEntity)
}