package com.yp.yplib.ext

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import androidx.core.graphics.drawable.toDrawable
import com.yp.yplib.R

private var loadingDialog: Dialog? = null
private fun initDialog(context: Context) {
    loadingDialog = Dialog(context).apply {
        window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
        setContentView(R.layout.view_progress_dialog)
        setCanceledOnTouchOutside(false)
        setCancelable(false)
    }
}

fun Context.showLoadingDialog() {
    if (loadingDialog == null) {
        initDialog(this)
    }
    loadingDialog?.takeIf { !it.isShowing }?.apply { show() }
}

fun dismissLoadingDialog() {
    loadingDialog?.takeIf { it.isShowing }?.apply { dismiss() }
}
