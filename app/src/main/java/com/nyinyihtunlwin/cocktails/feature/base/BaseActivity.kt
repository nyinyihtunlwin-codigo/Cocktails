package com.nyinyihtunlwin.cocktails.feature.base

import android.app.ProgressDialog
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    protected var isLoading = false
    private var mProgressBar: ProgressDialog? = null

    protected fun showLoading() {
        if (!isLoading) {
            mProgressBar = ProgressDialog.show(this, "", "loading...")
            if (mProgressBar != null) {
                mProgressBar!!.show()
            }
            isLoading = true
        }
    }

    protected fun showLoading(message: String) {
        if (!isLoading) {
            mProgressBar = ProgressDialog.show(this, "", message)
            if (mProgressBar != null) {
                mProgressBar!!.show()
            }
            isLoading = true
        }
    }

    protected fun hideLoading() {
        if (isLoading) {
            if (mProgressBar != null && mProgressBar!!.isShowing) {
                mProgressBar!!.dismiss()
            }
            isLoading = false
        }
    }

    protected fun showPromptDialog(errorMsg: String) {
        val alertDialog: AlertDialog? = this?.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setPositiveButton(
                    "OK"
                ) { dialog, id ->
                    dialog.dismiss()
                }
            }
            builder.create()
        }
        alertDialog!!.setMessage(errorMsg)
        alertDialog!!.show()
    }
}