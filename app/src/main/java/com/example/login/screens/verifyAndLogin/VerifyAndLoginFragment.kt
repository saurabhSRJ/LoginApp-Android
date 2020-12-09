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
import com.example.login.model.*
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

        val mobileNumber = prefs.mobileNumber
        println(mobileNumber)
        val message = "Enter the otp sent to your mobile $mobileNumber"
        binding.apply {  enterOtpMessage.text = message }
        binding.verifyButton.setOnClickListener { view : View ->
            val otp = binding.enterOtp.text.toString()
            if(otp.length == 4){
                verifyOtp(view,otp,mobileNumber)
            }
            else{
                Toast.makeText(activity?.applicationContext,"OTP should be of 4 digits",Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }

    private fun verifyOtp(view : View, otp : String, mobileNumber : String){
        val requestBody = VerifyOtpRequest(otp,mobileNumber)
        retrofitClient.verifyOtp("Token :" + R.string.authorization_token, requestBody).enqueue(object : Callback<VerifyOtpResponse>{
            override fun onResponse(call: Call<VerifyOtpResponse>, response: Response<VerifyOtpResponse>) {
                if(response.isSuccessful){
                    prefs.sessionToken = response.body()!!.sessionKey
                    fetchUserDetails(view,mobileNumber)
                }
                else{
                    Toast.makeText(activity,"Failure: Wrong OTP entered", Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<VerifyOtpResponse>, t: Throwable) {
                Toast.makeText(activity?.applicationContext, "Failure: ${t.message}",Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun fetchUserDetails(view: View, mobileNumber: String){
        val requestBody = FetchUserDetailRequest(mobileNumber)
        retrofitClient.fetchUser("Token :"+prefs.sessionToken, requestBody).enqueue(object :Callback<UserDetailResponse>{
            override fun onResponse(call: Call<UserDetailResponse>, response: Response<UserDetailResponse>) {
                if(response.isSuccessful){
                    val userDetails : UserDetailResponse = response.body()!!
                    prefs.userDetails = userDetails
                    if(userDetails.newUser){
                        view.findNavController().navigate(R.id.action_verifyAndLoginFragment_to_registrationFragment)
                    }
                    else{
                        view.findNavController().navigate(R.id.action_verifyAndLoginFragment_to_homePageActivity)
                    }
                }
                else{
                    Toast.makeText(activity?.applicationContext, "Failure: Please try again",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<UserDetailResponse>, t: Throwable) {
                Toast.makeText(activity?.applicationContext, "Failure: ${t.message}",Toast.LENGTH_SHORT).show()
            }

        })
    }
}