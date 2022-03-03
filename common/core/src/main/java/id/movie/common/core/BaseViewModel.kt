package id.movie.common.core

import androidx.lifecycle.*
import id.movie.common.resources.Resource


/**
 * Created by Muhamad Ribani on 23/01/22.
 */

open class BaseViewModel : ViewModel() {

    fun <T> observe(block: suspend () -> Resource<T>) = liveData {
        emit(Resource.loading())
        emit(block())
        emit(Resource.finish())
    }

}