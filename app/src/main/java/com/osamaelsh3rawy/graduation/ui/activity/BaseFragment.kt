package com.osamaelsh3rawy.graduation.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment

open class BaseFragment :Fragment() {

    lateinit var homeActivity:HomeActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeActivity  = requireActivity() as HomeActivity
    }
}