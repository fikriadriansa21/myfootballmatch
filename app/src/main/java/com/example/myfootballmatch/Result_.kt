package com.example.myfootballmatch

import java.lang.Exception

sealed class Result_<out T: Any?> {
    data class Success<out T : Any>(val data: T): Result_<T>()
    data class Error(val exception: Exception): Result_<Nothing>()

    override fun toString(): String {
        return when (this){
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}