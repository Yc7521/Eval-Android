package org.eval.ui.eval

import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import org.eval.BR
import org.eval.util.ObservableViewModel
import org.eval.util.Util
import java.math.BigDecimal

open class EvalViewModel : ObservableViewModel() {
    @Bindable
    open val expression: MutableLiveData<StringBuffer> = MutableLiveData(StringBuffer())

    @Bindable
    open val currExpr: MutableLiveData<StringBuffer> = MutableLiveData(StringBuffer("0"))

    private var canDot: Boolean = true
    private var input: Boolean = true
    private var needReset: Boolean = false
    private val expr: StringBuffer
        get() = expression.value!!
    private val curr: StringBuffer
        get() = currExpr.value!!

    /**
     * Submit the currExpr to expression
     * reset canDot, input
     */
    private fun submit(op: Char? = null) {
        canDot = true
        curr.apply {
            if (endsWith('.')) {
                deleteCharAt(length - 1)
            }
            expr.append(this)
            op?.let {
                expr.append(it)
            }
            needReset = true
        }

        notifyPropertyChanged(BR.expression)
    }

    /**
     * Clear current block
     * reset canDot, input
     */
    open fun onCE() {
        needReset = false
        canDot = true
        input = true
        curr.apply {
            delete(0, length)
            append('0')
        }
        notifyPropertyChanged(BR.currExpr)
    }

    /**
     * Clear all
     */
    open fun onC() {
        onCE()
        expr.apply {
            delete(0, length)
        }
        notifyPropertyChanged(BR.expression)
    }

    /**
     * Delete a char
     */
    open fun onDel() {
        needReset = false
        curr.apply {
            deleteCharAt(length - 1)
            if (isEmpty()) {
                append('0')
            }
        }
        notifyPropertyChanged(BR.currExpr)
    }

    /**
     * Eval
     */
    open fun onEq() {
        try {
            submit()
            val eval =
                with(Util.eval(expr.toString() + '\n')) {
                    toPlainString()
                }
            curr.apply {
                delete(0, length)
                append(eval)
                if (endsWith(".0"))
                    delete(length - 2, length)
                canDot = !contains('.')
            }
            expr.apply {
                delete(0, length)
            }
            input = true
            needReset = true
            notifyPropertyChanged(BR.currExpr)
        } catch (e: Exception) {
            Log.e("eval", "error", e)
        }
    }

    open fun onOp(op: Char) {
        if (input) {
            submit(op)
            input = false
            needReset = true
        } else {
            expr.apply {
                deleteCharAt(length - 1)
                append(op)
            }
            notifyPropertyChanged(BR.expression)
        }
    }

    /**
     * Input a number
     */
    fun onNum(num: Int) {
        if (needReset) {
            onCE()
            needReset = false
        }
        curr.apply {
            if (startsWith('0') && length < 2)
                deleteCharAt(0)
            input = true
            append(num)
        }
        notifyPropertyChanged(BR.currExpr)
    }

    /**
     * input a dot
     */
    open fun onDot() {
        needReset = false
        if (canDot) {
            canDot = false
            input = true
            curr.append('.')
            notifyPropertyChanged(BR.currExpr)
        }
    }
}