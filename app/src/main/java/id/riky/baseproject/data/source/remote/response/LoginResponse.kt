package id.riky.baseproject.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("token_type")
	val tokenType: String? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("expires_in")
	val expiresIn: Int? = null,

	@field:SerializedName("token")
	val token: String? = null
)
