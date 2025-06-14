package com.noureddine.eqar.Fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.noureddine.eqar.Activity.HomeActivity
import com.noureddine.eqar.R
import com.noureddine.eqar.databinding.FragmentLoginBinding
import com.noureddine.eqar.databinding.FragmentSigninBinding
import com.noureddine.kotlin2.Interface.FragmentNavigationListener
import kotlin.jvm.java


class SigninFragment : Fragment() {

    private var _binding: FragmentSigninBinding? = null
    private val binding get() = _binding!!
    private var navigationListener: FragmentNavigationListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSigninBinding.inflate(inflater, container, false)
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
        binding.btnRegister.setOnClickListener {
            val email = binding.etEmailRegister.text.toString()
            val password = binding.etPasswordRegister.text.toString()
            val confirmPassword = binding.etConfirmPassword.text.toString()
            val fullName = binding.etFullName.text.toString()

            if (validateInput(fullName, email, password, confirmPassword)) {
                performLogin(email, password)
            }
        }

        binding.btnGoogleRegister.setOnClickListener {
            navigateToHome()
        }

        binding.tvLogin.setOnClickListener {
            // الانتقال لصفحة التسجيل
            navigateToLogin()
        }

    }

    private fun setupUI() {
        // إعداد واجهة المستخدم
        binding.tvRegisterTitle.text = getString(R.string.register_title)
        binding.etFullName.hint = getString(R.string.full_name)
        binding.etEmailRegister.hint = getString(R.string.email)
        binding.etPasswordRegister.hint = getString(R.string.password)
        binding.etConfirmPassword.hint = getString(R.string.confirm_password)
        binding.tvIAgree.text = getString(R.string.i_agree)
        binding.tvPrivacy.text = getString(R.string.privacy)
        binding.tvAnd.text = getString(R.string.and)
        binding.tvTerms.text = getString(R.string.terms)
        binding.btnRegister.text = getString(R.string.register)
        binding.tvOr.text = getString(R.string.or)
        binding.btnGoogleRegister.text = getString(R.string.register_with_google)
        binding.tvLogin.text = getString(R.string.login_here)
        binding.tvHaveAccount.text = getString(R.string.have_account)

    }

    private fun validateInput(fullName: String,email: String, password: String,confirmPassword: String): Boolean {
        return when {
            fullName.isEmpty() -> {
                binding.etFullName.error = "الاسم الكامل مطلوب"
                false
            }
            email.isEmpty() -> {
                binding.etEmailRegister.error = "البريد الإلكتروني مطلوب"
                false
            }
            password.isEmpty() -> {
                binding.etPasswordRegister.error = "كلمة المرور مطلوبة"
                false
            }
            password.length < 6 -> {
                binding.etPasswordRegister.error = "كلمة المرور يجب أن تكون 6 أحرف على الأقل"
                false
            }
            !confirmPassword.equals(password) ->{
                binding.etConfirmPassword.error = "تاكيد كلمة المرور يجب أن تكون نفس كلمة المرور"
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

    private fun navigateToLogin() {
        try {
            findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        } catch (e: Exception) {
            Log.e("Navigation", "فشل في الانتقال: ${e.message}")
            // يمكنك إظهار رسالة خطأ للمستخدم
            Toast.makeText(context, "حدث خطأ في الانتقال", Toast.LENGTH_SHORT).show()
        }
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