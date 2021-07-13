package com.osamaelsh3rawy.graduation.ui.fragment.login

import android.os.Bundle
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
import com.osamaelsh3rawy.graduation.databinding.FragmentSignUpBinding
import com.osamaelsh3rawy.graduation.ui.activity.BaseFragment
import com.osamaelsh3rawy.graduation.ui.activity.HomeActivity
import kotlinx.android.synthetic.main.activity_home.*

class FragmentSignUp : BaseFragment() {
    private lateinit var signUpBinding: FragmentSignUpBinding
    lateinit var navController: NavController
    companion object{
        var ListLogin=ArrayList<loginIn>()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        signUpBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_sign_up,
                container,
                false)

        val homeActivity: HomeActivity = activity as HomeActivity

        return signUpBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        signUpBinding.txSignIn.setOnClickListener {
            navController.navigate(R.id.SignUp_to_Login)
        }
        signUpBinding.btnSignUp.setOnClickListener {
            if(signUpBinding.etEmail.editText?.text.toString().isEmpty() or
                signUpBinding.etFirstName.editText?.text.toString().isEmpty() or
                signUpBinding.etLastName.editText?.text.toString().isEmpty() or
                signUpBinding.etPassword.editText?.text.toString().isEmpty() ){
                Toast.makeText(context,"complete  all fields",Toast.LENGTH_SHORT).show()
            }else{
            var signUp =loginIn(signUpBinding.etEmail.editText.toString(),signUpBinding.etPassword.editText.toString())
            ListLogin.add(signUp)
            Toast.makeText(context,"congratulations",Toast.LENGTH_SHORT).show()
        }}

    }
}
