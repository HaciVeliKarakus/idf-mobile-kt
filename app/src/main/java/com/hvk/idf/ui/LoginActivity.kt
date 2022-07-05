package com.hvk.idf.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.hvk.idf.databinding.ActivityLoginBinding
import com.hvk.idf.data.models.Token
import com.hvk.idf.data.models.UserLogin
import com.hvk.idf.data.service.LoginService
import com.hvk.idf.data.service.ServiceGenerator
import com.hvk.idf.utils.TokenManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        val tokenManager = TokenManager(this@LoginActivity)
        val api = ServiceGenerator("", isAuthNeed = false).buildService(LoginService::class.java)

        val btn = binding.btnClick
        btn.setOnClickListener {
            val username = binding.editTextAuthUsername.text.toString()
            val password = binding.editTextAuthPassword.text.toString()
            val userData = UserLogin(username, password)

            api.getAuthToken(userData).also {
                it.enqueue(object : Callback<Token> {
                    override fun onFailure(call: Call<Token>, t: Throwable) {
                        Log.e(
                            "MainActivity",
                            "onFailure: " + t.message
                        )
                        alertError()
                    }

                    override fun onResponse(
                        call: Call<Token>,
                        response: Response<Token>
                    ) {
                        if (response.isSuccessful) {
                            val authResponse = response.body()
                            if (authResponse != null) {
                                TokenManager(this@LoginActivity).saveAuthToken(authResponse.token)
                                Log.i(
                                    "MainActivity",
                                    "onResponse: " + authResponse.token
                                )
                                val intent = Intent(
                                    this@LoginActivity,
                                    HomeActivity::class.java
                                )
                                startActivity(intent)
                            } else {
                                alertError()
                            }

                        } else {
                            Log.e(
                                "MainActivity",
                                "onResponse: " + response.errorBody()?.string()
                            )
                            alertError()
                        }
                    }
                })
            }
        }
    }

    private fun alertError() {
        val builder = AlertDialog.Builder(
            this@LoginActivity
        ).apply {
            setTitle("Error")
            setMessage("Invalid username or password")
        }
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        builder.show()
    }
}