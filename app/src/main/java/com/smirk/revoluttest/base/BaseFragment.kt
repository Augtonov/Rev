package com.smirk.revoluttest.base


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.smirk.revoluttest.R
import com.smirk.revoluttest.binding.FragmentDataBindingComponent
import com.smirk.revoluttest.di.Injectable
import com.smirk.revoluttest.utils.autoCleared
import javax.inject.Inject


/**
 * Created by Tony Augustine on 09,September,2019
 * tonyaugustine47@gmail.com
 */

/**
 * A simple [Fragment] subclass.
 */
abstract class BaseFragment<T : ViewDataBinding> : Fragment(), Injectable {

    private var mActivity: BaseActivity? = null

    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    @Inject
    protected lateinit var mViewModelFactory: ViewModelProvider.Factory

    var mBinding by autoCleared<T>()

    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(),
            container, false, dataBindingComponent)
        return mBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) {
            this.mActivity = context
        }
    }


    fun <V : ViewModel> getViewModel(clazz: Class<V>): V {
        return  ViewModelProviders.of(this, mViewModelFactory).get(clazz)

    }

    fun <V : ViewModel> getViewModelShared(activity: FragmentActivity, clazz: Class<V>): V {
        return  ViewModelProviders.of(activity, mViewModelFactory).get(clazz)

    }

    fun showSnackBar(message: String, duration: Int = Snackbar.LENGTH_LONG) {
        Snackbar.make(mBinding.root, message, duration).show()
    }

    fun showActionSnackBar(message: String, firstAction: String = "Retry",
                           iActionSnackBarListener: IActionSnackBarListener,
                           duration: Int = Snackbar.LENGTH_LONG) {
        val actionSnackBar: Snackbar = Snackbar.make(mBinding.root, message, duration)
        actionSnackBar.setAction(firstAction) {
            iActionSnackBarListener.onActionClicked()
        }
        actionSnackBar.setActionTextColor(ContextCompat.getColor(activity!!, R.color.colorAccent))
        actionSnackBar.show()
    }

    interface IActionSnackBarListener {
        fun onActionClicked()
    }


}
