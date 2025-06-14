package com.noureddine.eqar.Dialog

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.noureddine.eqar.R

class ForgotPasswordDialog : BottomSheetDialogFragment() {

    private var listener: OnClickListener? = null

    //lateinit var etEmail: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_forgot_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etEmail = view.findViewById<TextInputEditText>(R.id.etEmail)
        val btnCancel = view.findViewById<MaterialButton>(R.id.btnCancel)
        val btnSend = view.findViewById<MaterialButton>(R.id.btnSend)

        btnCancel.setOnClickListener {
            dismiss()
        }

        btnSend.setOnClickListener {
            val email = etEmail.text?.toString()
            listener?.onItemClickSendLink(email)
            //dismiss()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    interface OnClickListener {
        fun onItemClickSendLink(email: String?)
    }



    companion object {

        @SuppressLint("StaticFieldLeak")
        lateinit var etEmail: EditText
        
        @SuppressLint("StaticFieldLeak")
        private var dialogInstance: ForgotPasswordDialog? = null

        fun show(fragmentManager: androidx.fragment.app.FragmentManager, listener: OnClickListener) {
            dialogInstance = ForgotPasswordDialog()
            dialogInstance?.listener = listener
            dialogInstance?.show(fragmentManager, "ForgotPasswordDialog")
        }


        fun showErrorDialog(error: String){
            etEmail.error = error
        }

        fun dismiss() {
            dialogInstance?.dismiss()
            dialogInstance = null
        }

    }
} 