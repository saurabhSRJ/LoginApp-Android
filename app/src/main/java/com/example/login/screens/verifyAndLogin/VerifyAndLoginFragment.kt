package com.example.login.screens.verifyAndLogin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.login.R
import com.example.login.databinding.FragmentVerifyAndLoginBinding
import com.example.login.model.SendOtpResponse
import com.example.login.model.VerifyOtpRequest
import com.example.login.model.VerifyOtpResponse
import com.example.login.network.ServiceBuilder
import com.example.login.sharedPreferences.App
import com.example.login.sharedPreferences.Prefs
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [VerifyAndLoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VerifyAndLoginFragment : Fragment() {
    private val retrofitClient = ServiceBuilder.retrofitClient
    val prefs: Prefs by lazy {
        App.prefs!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentVerifyAndLoginBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_verify_and_login,container,false)
        //use safeArgs to pass mobile number between fragments
//        val mobileNumber = VerifyAndLoginFragmentArgs.fromBundle(requireArguments()).mobileNumber
        val mobileNumber = prefs.mobileNumber
        val message = "Enter the otp sent to your mobile $mobileNumber"
        binding.apply {  enterOtpMessage.text = message }
        binding.verifyButton.setOnClickListener { view : View ->
            val otp = binding.enterOtp.text.toString()
            if(otp.length == 4){
                val requestBody = VerifyOtpRequest(otp,mobileNumber)
                retrofitClient.verifyOtp("Token :" + R.string.authorization_token, requestBody).enqueue(object : Callback<VerifyOtpResponse>{
                    override fun onResponse(call: Call<VerifyOtpResponse>, response: Response<VerifyOtpResponse>) {
                        TODO("Not yet implemented")
                    }

                    override fun onFailure(call: Call<VerifyOtpResponse>, t: Throwable) {
                        TODO("Not yet implemented")
                    }
                })

            }
            else{
                Toast.makeText(activity?.applicationContext,"OTP should be of 4 digits",Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }
}