package id.riky.baseproject.domain.repository

import id.riky.baseproject.data.Resource
import id.riky.baseproject.domain.model.ModelLogin
import kotlinx.coroutines.flow.Flow

interface ILoginRepository {
    fun getLogin(nik: String, password: String, idDevice: String): Flow<Resource<ModelLogin>>
}