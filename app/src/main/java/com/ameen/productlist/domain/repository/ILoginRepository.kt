package com.ameen.productlist.domain.repository

interface ILoginRepository {
    fun loginWithPhoneAndPassword(phoneNumber: String, password: String): Boolean
}