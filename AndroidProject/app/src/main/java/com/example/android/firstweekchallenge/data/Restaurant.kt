package com.example.android.firstweekchallenge.data



class Restaurant(val name: String, val address: String, val picturePath: String) {
    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        if(javaClass != other?.javaClass) return false

        other as Restaurant

        if(name != other.name) return false
        if(address != other.address) return false
        if(picturePath != other.picturePath) return false

        return true
    }

}

