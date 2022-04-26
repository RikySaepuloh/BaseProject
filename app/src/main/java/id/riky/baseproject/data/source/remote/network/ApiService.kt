package id.riky.baseproject.data.source.remote.network

import id.riky.baseproject.data.source.remote.response.LoginResponse
import retrofit2.http.*

interface ApiService {
    @FormUrlEncoded
    @POST("bdh-auth/login-pin")
    suspend fun getLogin(
        @Field("nik") nik: String?,
        @Field("pin",encoded=true) pin: String?,
        @Field("id_device") id_device: String?
    ): LoginResponse


}
