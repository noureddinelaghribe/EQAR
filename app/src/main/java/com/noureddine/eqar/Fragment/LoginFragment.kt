package com.noureddine.eqar.Fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.noureddine.eqar.Activity.HomeActivity
import com.noureddine.eqar.Dialog.ForgotPasswordDialog
import com.noureddine.eqar.R
import com.noureddine.eqar.databinding.FragmentLoginBinding
import com.noureddine.kotlin2.Interface.FragmentNavigationListener


class LoginFragment : Fragment() {

    // إعلان View Binding
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    //private var navigationListener: FragmentNavigationListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // الآن يمكنك استخدام العناصر مباشرة
        setupClickListeners()
        setupUI()
    }

    private fun setupClickListeners() {
        // استخدام العناصر من الـ binding
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (validateInput(email, password)) {
                performLogin(email, password)
            }
        }

        binding.btnGoogleLogin.setOnClickListener {
            navigateToHome()
        }

        binding.tvRegister.setOnClickListener {
            // الانتقال لصفحة التسجيل
            navigateToSignup()
        }

        binding.tvForgotPassword.setOnClickListener {
            // نسيان كلمة المرور
            handleForgotPassword()

        }

    }

    private fun setupUI() {
        // إعداد واجهة المستخدم
        binding.tvWelcome.text = getString(R.string.welcome)
        binding.tvSubtitle.text = getString(R.string.login_subtitle)
        binding.etEmail.hint = getString(R.string.email)
        binding.etPassword.hint = getString(R.string.password)
        binding.tvForgotPassword.text = getString(R.string.forgot_password)
        binding.btnLogin.text = getString(R.string.login)
        binding.tvOr.text = getString(R.string.or)
        binding.btnGoogleLogin.text = getString(R.string.login_with_google)
        binding.tvNoAccount.text = getString(R.string.no_account)
        binding.tvRegister.text = getString(R.string.create_account)
    }

    private fun validateInput(email: String, password: String): Boolean {
        return when {
            email.isEmpty() -> {
                binding.etEmail.error = "البريد الإلكتروني مطلوب"
                false
            }
            password.isEmpty() -> {
                binding.etPassword.error = "كلمة المرور مطلوبة"
                false
            }
            password.length < 6 -> {
                binding.etPassword.error = "كلمة المرور يجب أن تكون 6 أحرف على الأقل"
                false
            }
            else -> true
        }
    }

    private fun performLogin(email: String, password: String) {
        // إظهار شريط التحميل
        //binding.progressBar.visibility = View.VISIBLE
        //binding.loginButton.isEnabled = false

        // تنفيذ عملية تسجيل الدخول
        // viewModel.login(email, password)

        navigateToHome()

    }

    private fun navigateToSignup() {
        try {
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        } catch (e: Exception) {
            Log.e("Navigation", "فشل في الانتقال: ${e.message}")
            // يمكنك إظهار رسالة خطأ للمستخدم
            Toast.makeText(context, "حدث خطأ في الانتقال", Toast.LENGTH_SHORT).show()
        }
    }


    private fun handleForgotPassword() {

        ForgotPasswordDialog.show(parentFragmentManager, object : ForgotPasswordDialog.OnClickListener {
            override fun onItemClickSendLink(email: String?) {
                // Handle the email submission here
                if (!email.isNullOrEmpty()) {
                    // Send password reset email
                    //sendPasswordResetEmail(email)
                    Toast.makeText(requireContext(), "تم إرسال رابط إعادة تعيين كلمة المرور إلى بريدك الإلكتروني", Toast.LENGTH_SHORT).show()
                    ForgotPasswordDialog.dismiss()
                } else {
                    // Handle empty email case
                    showError("يرجى إدخال بريد إلكتروني صالح")
                }
            }
        })

    }

    private fun showError(message: String) {
        ForgotPasswordDialog.showErrorDialog(message)
    }


    private fun navigateToHome() {
        var  i = Intent(activity, HomeActivity::class.java)
        startActivity(i)
        requireActivity().finish()
    }

    // تنظيف الـ binding عند تدمير الـ Fragment
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}