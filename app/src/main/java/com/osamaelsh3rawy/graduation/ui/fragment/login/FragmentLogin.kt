package com.osamaelsh3rawy.graduation.ui.fragment.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.osamaelsh3rawy.graduation.R
import com.osamaelsh3rawy.graduation.data.model.loginIn
import com.osamaelsh3rawy.graduation.databinding.FragmentLoginBinding
import com.osamaelsh3rawy.graduation.ui.activity.BaseFragment
import com.osamaelsh3rawy.graduation.ui.activity.HomeActivity
import kotlinx.android.synthetic.main.activity_home.*

class FragmentLogin : BaseFragment(), View.OnClickListener {
    lateinit var loginBinding: FragmentLoginBinding
    lateinit var navController: NavController
    var listLogin:ArrayList<loginIn> = FragmentSignUp.ListLogin
    var TAG = "FragmentLogin"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )
        loginBinding.lifecycleOwner = this

//        /////////////////// login cycle visibility /////////////////
//     homeActivity.loginCycleVisibility(View.GONE)


        return loginBinding.root
    }

    private fun setUpLogin() {
        Log.d(TAG,"nummmm "+listLogin.size)
        var email2 = loginBinding.etLoginEmail.editText?.text.toString()
        var pass2 = loginBinding.etLoginPassword.editText?.text.toString()
//        if (email.equals("osama") && pass.equals("123")
//            or email.equals("Osamaelsh3rawy98@gmail.com") && pass.equals("123")
//        ) {
//            navController.navigate(R.id.Login_to_fragmentHome)
//        } else {
//            Toast.makeText(
//                context,
//                "your name or password isn't correct...try again ",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
        for (i in listLogin)
            if (email2 == i.email   && pass2 == i.pass )
                navController.navigate(R.id.Login_to_fragmentHome)
            else {
                Toast.makeText(
                    context,
                    "your name or password isn't correct...try again ",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeActivity = activity as HomeActivity
        navController = Navigation.findNavController(view)
        loginBinding.txSignUp.setOnClickListener(this)
        loginBinding.btnSignIn.setOnClickListener(this)
        loginBinding.etForgetPassword.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.tx_sign_up ->
                navController.navigate(R.id.Login_to_SignUp)
            R.id.btn_sign_in ->
                setUpLogin()
            R.id.et_forget_password ->
                navController.navigate(R.id.login_to_ForgetPassword)
        }
    }
}