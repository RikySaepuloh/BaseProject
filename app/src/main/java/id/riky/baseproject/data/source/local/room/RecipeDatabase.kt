package id.riky.baseproject.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import id.agis.core.data.source.local.entity.RecipeEntity
import id.riky.baseproject.data.source.local.room.RecipeDao

// THIS FILE IS EXCLUDED FROM BUILD, FOR GRADLE BUILD PURPOSE ONLY... NEED TO BE FIXED LATER
@Database(entities = [RecipeEntity::class], version = 1, exportSchema = false)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}