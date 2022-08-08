package com.ameen.productlist.data.repository

import com.ameen.productlist.domain.repository.ILoginRepository

class LoginRepository : ILoginRepository {
    override fun loginWithPhoneAndPassword(phoneNumber: String, password: String): Boolean {
        return if (phoneNumber.isNotEmpty() && phoneNumber.length == 11)
            password.length > 8
        else
            false
    }
}