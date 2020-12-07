package com.example.login.screens.getStarted

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.login.R
import com.example.login.databinding.FragmentGetStartedBinding
import com.example.login.model.SendOtpRequest
import com.example.login.model.SendOtpResponse
import com.example.login.network.ServiceBuilder
import com.example.login.network.LoginApiService
import com.example.login.sharedPreferences.App
import com.example.login.sharedPreferences.Prefs
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [GetStartedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GetStartedFragment : Fragment() {
    private val retrofitClient = ServiceBuilder.retrofitClient
    val prefs: Prefs by lazy {
        App.prefs!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentGetStartedBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_get_started,container,false);
        binding.continueButton.setOnClickListener { view : View ->
            val mobileNumber = binding.enterMobileNumber.text.toString()
            prefs.mobileNumber = mobileNumber
            if(mobileNumber.length == 10){
                val request = SendOtpRequest("otp", mobileNumber)

                retrofitClient.sendOtp("Token :" + R.string.authorization_token, request).enqueue(object : Callback<SendOtpResponse>{
                    override fun onResponse(call: Call<SendOtpResponse>, response: Response<SendOtpResponse>) {
                        if(response.isSuccessful) {
                            view.findNavController().navigate(
                                GetStartedFragmentDirections.actionGetStartedFragmentToVerifyAndLoginFragment()
                                    .setMobileNumber(mobileNumber)
                            )
                        }
                        else{
                            Toast.makeText(activity, "Failure: $response", Toast.LENGTH_SHORT ).show()
                        }
                    }
                    override fun onFailure(call: Call<SendOtpResponse>, t: Throwable) {
                        Toast.makeText(activity, "Failure: " + t.message, Toast.LENGTH_SHORT ).show()
                    }
                })
            }
            else{
                Toast.makeText(activity?.applicationContext, "mobile number should have 10 digits", Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }
}