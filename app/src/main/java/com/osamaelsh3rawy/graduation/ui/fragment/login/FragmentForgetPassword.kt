package com.osamaelsh3rawy.graduation.ui.fragment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.osamaelsh3rawy.graduation.R
import com.osamaelsh3rawy.graduation.databinding.FragmentForgetPasswordBinding
import com.osamaelsh3rawy.graduation.ui.activity.BaseFragment
import com.osamaelsh3rawy.graduation.ui.activity.HomeActivity
import kotlinx.android.synthetic.main.activity_home.*

class FragmentForgetPassword: BaseFragment() {
    private lateinit var forgetPasswordBinding: FragmentForgetPasswordBinding
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        forgetPasswordBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_forget_password,
                container,
                false
            )

        return forgetPasswordBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        forgetPasswordBinding.etSignUp.setOnClickListener {
            navController.navigate(R.id.ForgetPassword_to_SignUp)
        }
        forgetPasswordBinding.btnResetPass.setOnClickListener {
            navController.navigate(R.id.ForgetPassword_to_ResetPassword)
        }
    }
}