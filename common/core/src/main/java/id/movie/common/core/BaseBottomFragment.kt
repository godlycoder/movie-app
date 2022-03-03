package id.movie.common.core

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.FrameLayout
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.lang.reflect.ParameterizedType

abstract class BaseBottomFragment<T : ViewBinding> : BottomSheetDialogFragment() {

    lateinit var binding : T

    private var loading: Dialog? = null

    @Suppress("UNCHECKED_CAST")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val displayMetrics = requireActivity().resources.displayMetrics
        val bindingClass = (this::class.java.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<T>
        val inflateMethod = bindingClass.getMethod("inflate", LayoutInflater::class.java)
        val invokeLayout = inflateMethod.invoke(null, layoutInflater) as T

        invokeLayout.also {
            binding = it
            binding.root.layoutParams = ViewGroup.LayoutParams(displayMetrics.widthPixels,
                displayMetrics.heightPixels)
        }

        return invokeLayout.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        view.viewTreeObserver.addOnGlobalLayoutListener(object :
//            ViewTreeObserver.OnGlobalLayoutListener {
//            override fun onGlobalLayout() {
//                view.viewTreeObserver.removeOnGlobalLayoutListener(this)
//                val dialog = dialog as BottomSheetDialog?
//                val bottomSheet =
//                    dialog?.findViewById<View>(R.id.design_bottom_sheet) as FrameLayout?
//                val behavior = BottomSheetBehavior.from<View?>(bottomSheet!!)
//                behavior.state = BottomSheetBehavior.STATE_EXPANDED
//                behavior.isDraggable = false
//                behavior.peekHeight = 0
//            }
//        })
    }

    override fun onStart() {
        super.onStart()

        binding.initialBinding()
    }

    open fun T.initialBinding() {}

    fun backStack(destId: Int? = null, data: Map<String, *>? = null) {
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
}