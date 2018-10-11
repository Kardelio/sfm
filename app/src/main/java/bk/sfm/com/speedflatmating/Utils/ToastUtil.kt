package bk.sfm.com.speedflatmating.Utils

import android.content.Context
import android.widget.Toast

class ToastUtil{
    companion object {
        fun displayToast(context: Context, message: String){
            val toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}