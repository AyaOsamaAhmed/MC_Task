package com.aya.mc_task.feature.fragment.home.ui.adapter

import com.aya.mc_task.R
import com.aya.mc_task.base.BaseAdapter
import com.aya.mc_task.base.BaseViewHolder
import com.aya.mc_task.databinding.UserItemBinding
import com.aya.mc_task.feature.fragment.home.data.AthletesItem

class HomeAdapter(private val onItemClicked:(AthletesItem)-> Unit,)
    : BaseAdapter<AthletesItem, UserItemBinding>(onItemClicked){

    override fun layoutRes(): Int = R.layout.user_item

    override fun onViewHolderCreated(viewHolder: BaseViewHolder<AthletesItem>) {
        super.onViewHolderCreated(viewHolder)
        mBinding.itemLayout.setOnClickListener {
            mPosition = viewHolder.bindingAdapterPosition
            getItem(mPosition)?.let { item -> onItemClicked.invoke(item) }
        }
    }

    override fun onBindItemBinding(
        binding: UserItemBinding,
        item: AthletesItem,
        position: Int
    ) {
      //  binding.titleAddress.text = item.name

        super.onBindItemBinding(binding, item, position)
    }

}