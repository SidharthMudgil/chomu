package com.sidharth.chomu.presentation.component

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sidharth.chomu.R
import com.sidharth.chomu.databinding.SheetAdvancedOptionBinding
import com.sidharth.chomu.domain.model.Options

class AdvanceOptionsBottomSheet : BottomSheetDialogFragment() {

    private lateinit var sheetAdvancedOptionBinding: SheetAdvancedOptionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        sheetAdvancedOptionBinding = SheetAdvancedOptionBinding.inflate(inflater)

        sheetAdvancedOptionBinding.btnCancel.setOnClickListener {
            dismiss()
        }

        sheetAdvancedOptionBinding.btnApply.setOnClickListener {

            findNavController().previousBackStackEntry?.savedStateHandle?.apply {
                set(
                    KEY_OPTIONS, Options(
                        formality = getFormality(),
                        tone = getTone(),
                        length = getLength(),
                        style = getStyle()
                    )
                )
            }
            dismiss()
        }

        return sheetAdvancedOptionBinding.root
    }

    private fun getFormality(): String {
        return when (sheetAdvancedOptionBinding.cgFormality.checkedChipId) {
            R.id.chip_casual -> "Casual"
            R.id.chip_neutral -> "Neutral"
            R.id.chip_formal -> "Formal"
            else -> "Required"
        }
    }

    private fun getTone(): String {
        return when (sheetAdvancedOptionBinding.cgTone.checkedChipId) {
            R.id.chip_optimistic -> "Optimistic"
            R.id.chip_worried -> "Worried"
            R.id.chip_friendly -> "Friendly"
            R.id.chip_curious -> "Curious"
            R.id.chip_assertive -> "Assertive"
            R.id.chip_encouraging -> "Encouraging"
            R.id.chip_surprised -> "Surprised"
            R.id.chip_engaging -> "Engaging"
            R.id.chip_cooperative -> "Cooperative"
            else -> "Required"
        }
    }

    private fun getLength(): String {
        return when (sheetAdvancedOptionBinding.cgLength.checkedChipId) {
            R.id.chip_short -> "Short"
            R.id.chip_medium -> "Medium"
            R.id.chip_long -> "Long"
            else -> "Required"
        }
    }

    private fun getStyle(): String {
        return when (sheetAdvancedOptionBinding.cgStyle.checkedChipId) {
            R.id.chip_none -> "None"
            R.id.chip_poetic -> "Poetic"
            R.id.chip_philosopher -> "Philosopher"
            R.id.chip_chef -> "Chef"
            R.id.chip_explorer -> "Explorer"
            R.id.chip_scientist -> "Scientist"
            R.id.chip_comedian -> "Comedian"
            R.id.chip_futurist -> "Futurist"
            else -> "required"
        }
    }

    companion object {
        const val KEY_OPTIONS = "resultOptions"
    }
}