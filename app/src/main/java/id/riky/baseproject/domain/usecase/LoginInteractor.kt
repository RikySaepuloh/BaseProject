package id.riky.baseproject.domain.usecase

import id.riky.baseproject.domain.repository.ILoginRepository

class LoginInteractor(private val loginRepository: ILoginRepository) : LoginUseCase {
    override fun getLogin(nik: String, password: String, idDevice: String) =
        loginRepository.getLogin(nik,password,idDevice)

}

