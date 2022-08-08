package com.ameen.productlist.domain.usecase

import com.ameen.productlist.domain.repository.ILoginRepository
import javax.inject.Inject

class PhoneNumberLoginUseCase @Inject constructor(val repo: ILoginRepository) {
    fun execute(phoneNumber: String, password: String): Boolean {
        return repo.loginWithPhoneAndPassword(phoneNumber, password)
    }
}