package org.eval.ui.bmi

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.google.android.material.snackbar.Snackbar
import org.eval.util.ObservableViewModel

open class BmiViewModel : ObservableViewModel() {
    enum class Sex {
        Man, Woman, Unknown
    }

    open val weight: MutableLiveData<String> = MutableLiveData()
    open val height: MutableLiveData<String> = MutableLiveData()
    open val bmiInfo: MutableLiveData<String> = MutableLiveData()
    open val analysis: MutableLiveData<String> = MutableLiveData()
    open var sex: Sex = Sex.Unknown
    open var man: Boolean
        get() = sex == Sex.Man
        set(value) {
            if (value) sex = Sex.Man
        }
    open var woman: Boolean
        get() = sex == Sex.Woman
        set(value) {
            if (value) sex = Sex.Woman
        }

    fun onCal(v: View) {
        try {
            if (weight.value == null || height.value == null) {
                Snackbar.make(v, "体重或身高不可为空", Snackbar.LENGTH_SHORT).show()
                return
            }
            val w = weight.value!!.toDouble()
            val h = height.value!!.toDouble()
            val bmi = w / (h * h)
            bmiInfo.value = "$bmi"
            analysis.value = when (sex) {
                Sex.Man -> when {
                    bmi < 20 -> "体重过轻"
                    bmi < 25 -> "体重正常"
                    bmi < 27 -> "体重超重"
                    bmi < 30 -> "轻度肥胖"
                    bmi < 35 -> "中度肥胖"
                    else -> "重度肥胖"
                }
                Sex.Woman -> when {
                    bmi < 19 -> "体重过轻"
                    bmi < 24 -> "体重正常"
                    bmi < 26 -> "体重超重"
                    bmi < 29 -> "轻度肥胖"
                    bmi < 34 -> "中度肥胖"
                    else -> "重度肥胖"
                }
                else -> "未知"
            }
        } catch (e: Exception) {
            analysis.value = "出现错误"
        }
        notifyChange()
    }

    fun onReset() {
        weight.value = ""
        height.value = ""
        bmiInfo.value = ""
        analysis.value = ""
        notifyChange()
    }

}