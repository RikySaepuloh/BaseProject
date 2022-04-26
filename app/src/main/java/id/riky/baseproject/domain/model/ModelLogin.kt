package id.riky.baseproject.domain.model


data class ModelLogin(

	val tokenType: String? = null,
	val message: String? = null,
	val expiresIn: Int? = null,
	val token: String? = null
)
