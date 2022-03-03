package id.movie.common.core

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType


abstract class BaseFragment<T : ViewBinding> : Fragment() {

    lateinit var binding : T

    private var loading: Dialog? = null

    private var back: ImageView? = null
    private var icon: ImageView? = null
    private var title: TextView? = null

    @Suppress("UNCHECKED_CAST")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bindingClass = (this::class.java.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<T>
        val inflateMethod = bindingClass.getMethod("inflate", LayoutInflater::class.java)
        val invokeLayout = inflateMethod.invoke(null, layoutInflater) as T

        invokeLayout.also { binding = it }

        return invokeLayout.root
    }

    override fun onStart() {
        super.onStart()

        binding.initialBinding()
    }

    open fun T.initialBinding() {}

    fun backStack(destId: Int? = null, data: Map<String, String>? = null) {
        findNavController().apply {
            data?.forEach {
                previousBackStackEntry?.savedStateHandle?.set(it.key, it.value)
            }
            if (destId == null) {
                popBackStack()
            } else {
                popBackStack(destId, true)
            }
        }
    }

    fun showMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    fun showLoading() {
        loading?.show()
    }

    fun hideLoading() {
        loading?.dismiss()
    }

    fun navigate(uri: Uri, clearStack: Boolean = false) {
        val navOps = if (clearStack) {
            NavOptions.Builder()
                .setPopUpTo(findNavController().graph.id, true)
                .build()
        } else null

        findNavController().navigate(uri, navOps)
    }



}