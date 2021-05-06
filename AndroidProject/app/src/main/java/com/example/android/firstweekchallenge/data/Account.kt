package com.example.android.firstweekchallenge.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Account(
    var email: String? = "",
    var fullName: String? = "",
    var phoneNumber: String? = "") : Parcelable{
    override fun toString(): String {
        return "Account(email='$email', fullName='$fullName', phoneNumber='$phoneNumber')"
    }
}