package id.riky.baseproject.data

import id.riky.baseproject.data.source.remote.network.ApiResponse
import kotlinx.coroutines.flow.*

abstract class NetworkBoundResource<ResultType, RequestType> {

    private var result: Flow<Resource<ResultType>> = flow {
        emit(Resource.Loading())
        try {
            when (val apiResponse = getDataFromNetwork().first()) {
                is ApiResponse.Success -> {
                    emit(Resource.Success(convertDataToDomainModel(apiResponse.data)))
                }
                is ApiResponse.Empty -> {
                    emit(Resource.Error<ResultType>("Data is empty"))
                }
                is ApiResponse.Error -> {
                    onFetchFailed()
                    emit(Resource.Error<ResultType>(apiResponse.errorMessage))
                }
            }
        } catch (e: Exception) {

        }
    }


    protected open fun onFetchFailed() {}

    protected abstract fun convertDataToDomainModel(data: RequestType): ResultType

    protected abstract suspend fun getDataFromNetwork(): Flow<ApiResponse<RequestType>>

    fun asFlow(): Flow<Resource<ResultType>> = result
}