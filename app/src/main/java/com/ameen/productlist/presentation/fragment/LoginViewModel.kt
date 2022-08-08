package com.ameen.productlist.presentation.fragment

import androidx.lifecycle.ViewModel
import com.ameen.productlist.domain.usecase.PhoneNumberLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val phoneNumberLoginUseCase: PhoneNumberLoginUseCase
) : ViewModel() {

    fun loginUsernameAndPassword(
        phoneNumber: String,
        password: String
    ) =
        phoneNumberLoginUseCase.execute(phoneNumber, password)

}