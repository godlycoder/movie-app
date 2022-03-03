package id.movie.common.core

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.lang.reflect.ParameterizedType


/**
 * Created by Muhamad Ribani on 23/11/21.
 */


abstract class BaseDialog<T : ViewBinding>(context: Context) : AlertDialog(context) {

    lateinit var binding : T

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bindingClass = (this::class.java.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<T>
        val inflateMethod = bindingClass.getMethod("inflate", LayoutInflater::class.java)
        val invokeLayout = inflateMethod.invoke(null, layoutInflater) as T
        setContentView(invokeLayout.root)

        window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        invokeLayout.also {
            binding = it
        }
    }

    override fun onStart() {
        super.onStart()
        binding.initialBinding()
    }

    open fun T.initialBinding() {}

    fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}