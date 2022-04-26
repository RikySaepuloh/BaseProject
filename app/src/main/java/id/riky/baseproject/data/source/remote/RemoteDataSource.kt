package id.riky.baseproject.data.source.remote

import android.util.Log
import id.riky.baseproject.data.source.remote.network.ApiResponse
import id.riky.baseproject.data.source.remote.network.ApiService
import id.riky.baseproject.data.source.remote.response.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import okhttp3.ResponseBody

class RemoteDataSource(val apiService: ApiService) {
//
    suspend fun getLogin(nik:String,password:String,idDevice:String?=null): Flow<ApiResponse<LoginResponse>> {
        return flow {
            try {
                val response = apiService.getLogin(nik,password,idDevice)
                emit(ApiResponse.Success(response))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }



//
//    inner class RecipePagingSource : PagingSource<Int, RecipeItemResponse>() {
//        private lateinit var listRecipe: List<RecipeItemResponse>
//        private var currentPage = 1
//
//        override fun getRefreshKey(state: PagingState<Int, RecipeItemResponse>): Int? = null
//
//        override val keyReuseSupported = true
//
//        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RecipeItemResponse> {
//            params.key?.let { currentPage = it }
//
//            return try {
//                setListRecipes()
//
//                LoadResult.Page(
//                    data = listRecipe,
//                    prevKey = getPrevPage(),
//                    nextKey = getNextPage()
//                )
//            } catch (exception: IOException) {
//                return LoadResult.Error(exception)
//            } catch (exception: HttpException) {
//                return LoadResult.Error(exception)
//            }
//        }
//
//        private suspend fun setListRecipes() {
//            listRecipe = apiService.getListRecipe(currentPage).results
//        }
//
//        private fun getNextPage() = if (listRecipe.isEmpty()) null else currentPage + 1
//
//        private fun getPrevPage() = if (currentPage == 1) null else currentPage - 1
//    }
}