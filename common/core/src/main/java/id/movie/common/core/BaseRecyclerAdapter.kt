package id.movie.common.core

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

abstract class BaseRecyclerAdapter<T, VB: ViewBinding>(
    @LayoutRes private var layoutLoadingRes: Int = -1,
    @LayoutRes private var layoutEmptyRes: Int = -1,
    private val loadingCount : Int = 5,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var onItemClick: ((T) -> Unit)? = null
    private var items = mutableListOf<T>()
    private var onLoadMoreListener: () -> Unit = {}

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val bindingClass = (this::class.java.genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<VB>
        val inflateMethod = bindingClass.getMethod("inflate",
            LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
        val binding = inflateMethod.invoke(
            null, LayoutInflater.from(parent.context), parent, false) as VB
        return Holder(binding)
    }

    override fun getItemCount() : Int {
        return items.size
    }

    fun getItems() = items


    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items.getOrNull(position)
        if (item != null && holder is Holder<*>) {
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

    abstract fun VB.bind(item: T, position: Int)

    fun setOnLoadableListener(onLoadableListener: () -> Unit) {
        this.onLoadMoreListener = onLoadableListener
    }

    @SuppressLint("NotifyDataSetChanged")
    fun startLoading() {
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(list: List<T>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun add(item: T) {
        items.add(item)
        notifyItemInserted(items.size-1)
    }

    fun setItem(position: Int, item: T) {
        items[position] = item
        notifyItemChanged(position)
    }

    fun removeItem(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun setOnItemClickListener(onItemClick: (T) -> Unit) {
        this.onItemClick = onItemClick
    }

    private class Holder<VB : ViewBinding>(val binding: VB) : RecyclerView.ViewHolder(binding.root)

    private class LoadingHolder(view: View) : RecyclerView.ViewHolder(view)

    private class EmptyHolder(view: View) : RecyclerView.ViewHolder(view)
}