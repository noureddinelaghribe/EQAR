package com.noureddine.eqar.Dialog

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.FrameLayout
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.chip.Chip
import com.google.android.material.textfield.TextInputEditText
import com.noureddine.eqar.Adapter.ChatAdapter
import com.noureddine.eqar.Model.ChatMessage
import com.noureddine.eqar.R

class ChatBotDialog : BottomSheetDialogFragment() {

    private var listener: OnClickListener? = null
    private lateinit var recyclerViewChat: RecyclerView
    private lateinit var etMessage: TextInputEditText
    private lateinit var btnSend: MaterialButton
    private lateinit var btnBack: ImageButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_chat_bot, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews(view)
        setupClickListeners()
        setupQuickSuggestions(view)
    }

    private fun initializeViews(view: View) {
        btnBack = view.findViewById(R.id.btnBack)
        etMessage = view.findViewById(R.id.etMessage)
        btnSend = view.findViewById(R.id.btnSend)
        recyclerViewChat = view.findViewById(R.id.recyclerViewChat)
        recyclerViewChat.layoutManager = LinearLayoutManager(requireContext())

        val adapter = ChatAdapter()
        recyclerViewChat.adapter = adapter

        adapter.addMessage(ChatMessage("سلام! كيفاش نقدر نعاونك اليوم؟", false))
        adapter.addMessage(ChatMessage("أهلا، راني نحوس على شقة للإيجار في العاصمة", true))
        adapter.addMessage(ChatMessage("وش من شقة تحتاج بالضبط؟ صغيرة، كبيرة، عدد الغرف...؟", false))
        adapter.addMessage(ChatMessage("شقة فيها زوج غرف وصالون، وقريبة للمترو إذا ممكن", true))
        adapter.addMessage(ChatMessage("يعطيك الصحة على التفاصيل. يمكنك مشاهدة هده النتائج!", false))


        if (adapter.itemCount > 0) {
            recyclerViewChat.smoothScrollToPosition(adapter.itemCount - 1)
        }

    }

    private fun setupClickListeners() {
        btnBack.setOnClickListener {
            dismiss()
        }

        btnSend.setOnClickListener {
            val msg = etMessage.text?.toString()?.trim()
            if (!msg.isNullOrEmpty()) {
                listener?.onItemClickSendMsg(msg)
                etMessage.text?.clear()
            }
        }
    }

    private fun setupQuickSuggestions(view: View) {
        val chipHelp = view.findViewById<Chip>(R.id.chipHelp)
        val chipInfo = view.findViewById<Chip>(R.id.chipInfo)
        val chipServices = view.findViewById<Chip>(R.id.chipServices)
        val chipSettings = view.findViewById<Chip>(R.id.chipSettings)

        chipHelp.setOnClickListener {
            listener?.onItemClickSendMsg("كيف يمكنك مساعدتي؟")
        }

        chipInfo.setOnClickListener {
            listener?.onItemClickSendMsg("معلومات عنك")
        }

        chipServices.setOnClickListener {
            listener?.onItemClickSendMsg("الخدمات المتاحة")
        }

        chipSettings.setOnClickListener {
            listener?.onItemClickSendMsg("الإعدادات")
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog

        dialog.setOnShowListener { dialogInterface ->
            val bottomSheetDialog = dialogInterface as BottomSheetDialog
            val bottomSheet = bottomSheetDialog.findViewById<FrameLayout>(
                com.google.android.material.R.id.design_bottom_sheet
            )

            bottomSheet?.let {
                val behavior = BottomSheetBehavior.from(it)
                // Set the peek height (initial height when dialog appears)
                behavior.peekHeight = (resources.displayMetrics.heightPixels * 0.8).toInt()
                // Allow the dialog to be expanded to full height if needed
                behavior.state = BottomSheetBehavior.STATE_COLLAPSED
                // Enable dragging
                behavior.isDraggable = true
                // Prevent the dialog from being dismissed by swiping down
                behavior.isHideable = false
            }
        }

        return dialog
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.apply {
            // Set the layout parameters
            setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            // Make the background transparent to show rounded corners
            setBackgroundDrawableResource(android.R.color.transparent)
            isCancelable = false
        }
    }

    fun setOnClickListener(listener: OnClickListener) {
        this.listener = listener
    }

    interface OnClickListener {
        fun onItemClickSendMsg(msg: String?)
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var dialogInstance: ChatBotDialog? = null

        fun show(fragmentManager: androidx.fragment.app.FragmentManager, listener: OnClickListener) {
            // Dismiss any existing instance
            dialogInstance?.dismiss()

            dialogInstance = ChatBotDialog().apply {
                setOnClickListener(listener)
            }
            dialogInstance?.show(fragmentManager, "ChatBotDialog")
        }

        fun dismiss() {
            dialogInstance?.dismiss()
            dialogInstance = null
        }
    }
}