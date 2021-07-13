package com.osamaelsh3rawy.graduation.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.osamaelsh3rawy.graduation.R
import com.osamaelsh3rawy.graduation.databinding.FragmentFavBinding
import com.osamaelsh3rawy.graduation.databinding.FragmentSupportBinding
import com.osamaelsh3rawy.graduation.ui.activity.BaseFragment
import kotlinx.android.synthetic.main.activity_home.*


class FragmentSupport : BaseFragment() {
    private lateinit var supportBinding: FragmentSupportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        supportBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_support,
                container,
                false)




        return supportBinding.root
    }
}