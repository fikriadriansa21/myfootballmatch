package com.example.myfootballmatch.ui.base

import android.util.Log
import com.example.myfootballmatch.Result_
import retrofit2.Response
import java.io.IOException

open class BaseRepository {
    suspend fun <T : Any> safeApiCall(call : suspend()-> Response<T>, error : String) :  T?{
        val result = leaguesApiOutput(call, error)
        var output : T? = null
        when(result){
            is Result_.Success ->
                output = result.data
            is Result_.Error -> Log.e("Error", "The $error and the ${result.exception}")
        }
        return output

    }
    private suspend fun<T : Any> leaguesApiOutput(call: suspend()-> Response<T> , error: String) : Result_<T> {
        val response = call.invoke()
        return if (response.isSuccessful)
            Result_.Success(response.body()!!)
        else
            Result_.Error(IOException("OOps .. Something went wrong due to  $error"))
    }
}