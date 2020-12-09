package com.example.login.screens.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.login.R
import com.example.login.databinding.FragmentRegistrationBinding
import com.example.login.model.RegisterUserRequest
import com.example.login.model.UserDetailResponse
import com.example.login.network.ServiceBuilder
import com.example.login.sharedPreferences.App
import com.example.login.sharedPreferences.Prefs
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [RegistrationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistrationFragment : Fragment() {
    private val retrofitClient = ServiceBuilder.retrofitClient
    val prefs: Prefs by lazy {
        App.prefs!!
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentRegistrationBinding>(inflater,
            R.layout.fragment_registration,container,false)
//        binding.registerButton.setOnClickListener { view : View ->
//            val fleetId = prefs.userDetails!!.fleetId;
//            val name = binding.username.text.toString()
//            val numberOfTrucks = Integer.parseInt(binding.trucksInput.text.toString())
//            val requestBody = RegisterUserRequest(fleetId,name,numberOfTrucks);
//
//            retrofitClient.registerUser("Token :"+prefs.sessionToken, requestBody).enqueue(object : Callback<UserDetailResponse> {
//                override fun onResponse(call: Call<UserDetailResponse>, response: Response<UserDetailResponse>) {
//                    if(response.isSuccessful){
//                        val userDetails : UserDetailResponse = response.body()!!
//                        prefs.userDetails = userDetails
//                        view.findNavController().navigate(R.id.action_registrationFragment_to_homePageActivity)
//                    }
//                    else{
//                        Toast.makeText(activity?.applicationContext, "Failure: Please try again",Toast.LENGTH_SHORT).show()
//                    }
//                }
//
//                override fun onFailure(call: Call<UserDetailResponse>, t: Throwable) {
//                    Toast.makeText(activity?.applicationContext, "Failure: ${t.message}", Toast.LENGTH_SHORT).show()
//                }
//            })
//        }
//        binding.registerButton.setOnClickListener {view : View -> view.findNavController().navigate(R.id.action_registrationFragment_to_homePageActivity) }
        return binding.root
    }
}