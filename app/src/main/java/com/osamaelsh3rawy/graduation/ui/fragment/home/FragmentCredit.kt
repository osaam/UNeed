package com.osamaelsh3rawy.graduation.ui.fragment.home

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.osamaelsh3rawy.graduation.R
import com.osamaelsh3rawy.graduation.databinding.CreditcardBinding
import com.osamaelsh3rawy.graduation.ui.activity.BaseFragment
import com.osamaelsh3rawy.graduation.ui.activity.HomeActivity
import kotlinx.android.synthetic.main.activity_home.*


class FragmentCredit : BaseFragment() {
    private lateinit var Binding: CreditcardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { Binding = DataBindingUtil.inflate(inflater, R.layout.creditcard, container, false
            )
        setupCreditCard()



        return Binding.root
    }

    private fun setupCreditCard() {
        Binding.cardform.cardRequired(true)
            .expirationRequired(true)
            .cvvRequired(true)
            .postalCodeRequired(true)
            .mobileNumberRequired(true)
            .mobileNumberExplanation("SMS is required on this number")
            .setup(requireActivity() as AppCompatActivity?)

        Binding.cardform.cvvEditText.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_VARIATION_PASSWORD

        Binding.btnCreditBuynow.setOnClickListener(View.OnClickListener {
            if (Binding.cardform.isValid) {
                val alertBuilder: AlertDialog.Builder = AlertDialog.Builder(context)
                alertBuilder.setTitle("Confirm before purchase")
                alertBuilder.setMessage(
                    """
                            Card number: ${Binding.cardform.cardNumber.toString()}
                            Card expiry date: ${
                        Binding.cardform.expirationDateEditText.text.toString()
                    }
                            Card CVV: ${Binding.cardform.cvv.toString()}
                            Postal code: ${Binding.cardform.postalCode.toString()}
                            Phone number: ${Binding.cardform.mobileNumber}
                            """.trimIndent()
                )
                alertBuilder.setPositiveButton("Confirm",
                    DialogInterface.OnClickListener { dialogInterface, i ->
                        dialogInterface.dismiss()
                        Toast.makeText(context, "Thank you for purchase", Toast.LENGTH_LONG).show()
                    })
                alertBuilder.setNegativeButton("Cancel",
                    DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface.dismiss() })
                val alertDialog: AlertDialog = alertBuilder.create()
                alertDialog.show()
            } else {
                Toast.makeText(context, "Please complete the form", Toast.LENGTH_LONG).show();
            }
        })


    }


}