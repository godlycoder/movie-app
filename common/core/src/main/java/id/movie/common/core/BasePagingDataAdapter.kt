package id.movie.common.core

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

abstract class BasePagingDataAdapter<T : Any, VB : ViewBinding>(itemCallback: CustomDiffUtil<T>) :
    PagingDataAdapter<T, RecyclerView.ViewHolder>(itemCallback) {

    private var onItemClick: ((T) -> Unit)? = null

    abstract fun VB.bind(item: T, position: Int)

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        if (holder is Holder<*> && item != null) {
            (holder as Holder<VB>).apply {
                binding.bind(item, position)
                if (onItemClick != null) holder.itemView.setOnClickListener {
                    onItemClick?.let {
                            listener ->
                        listener(item)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val bindingClass = (this::class.java.genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<VB>
        val inflateMethod = bindingClass.getMethod("inflate", LayoutInflater::class.java)
        val binding = inflateMethod.invoke(null, LayoutInflater.from(parent.context)) as VB
        return Holder(binding)
    }

    class Holder<VB : ViewBinding>(val binding: VB) : RecyclerView.ViewHolder(binding.root)


    abstract class CustomDiffUtil<T> : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return doCompareContentsTheSame(oldItem, newItem)
        }

        abstract fun doCompareContentsTheSame(oldItem: T, newItem: T) : Boolean
    }
}