package com.untitled.roompractice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.untitled.roompractice.databinding.ItemBinding
import com.untitled.roompractice.entity.Recruitment

internal class RecruitmentAdapter(
    private val recruitments: List<Recruitment>,
) :
    RecyclerView.Adapter<RecruitmentAdapter.RecruitmentViewHolder>() {

    class RecruitmentViewHolder(
        private val binding: ItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(recruitment: Recruitment) {
            binding.recruitment = recruitment
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecruitmentViewHolder {
        return RecruitmentViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return recruitments.size
    }

    override fun onBindViewHolder(
        holder: RecruitmentViewHolder,
        position: Int,
    ) {
        holder.bind(recruitment = recruitments[position])
    }
}