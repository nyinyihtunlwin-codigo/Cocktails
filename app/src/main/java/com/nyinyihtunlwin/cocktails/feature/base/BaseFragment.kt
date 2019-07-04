package com.nyinyihtunlwin.cocktails.feature.base

import android.app.ProgressDialog
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment


open class BaseFragment : Fragment() {

    private var mProgressBar: ProgressDialog? = null

    private fun showErrorMsg(errorMsg: String) {
        val builder = AlertDialog.Builder(context!!.applicationContext)
        builder.setTitle("Error in Network Call")
            .setMessage(errorMsg)
            .setCancelable(true)
            .setPositiveButton("Try Again", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {

                }
            })
            .setNegativeButton("Cancel", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    //exitProcess(0)
                    //System.exit(0)
                    activity!!.finish()
                }

            })
        val dialog = builder.create()
        dialog.show()
    }

    protected fun showPromptDialog(errorMsg: String) {
        val alertDialog: AlertDialog? = activity?.let {
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


    protected fun showLoading(message: String) {
        mProgressBar = ProgressDialog.show(context, "", message)
        if (mProgressBar != null) {
            mProgressBar!!.show()
        }
    }

    protected fun dismissLoading() {
        if (mProgressBar != null && mProgressBar!!.isShowing) {
            mProgressBar!!.dismiss()
        }
    }
}