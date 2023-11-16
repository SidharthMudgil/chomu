package com.sidharth.chomu.presentation.component

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sidharth.chomu.databinding.SheetAdvancedOptionBinding

class AdvanceOptionsBottomSheet : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return SheetAdvancedOptionBinding.inflate(inflater).root
    }
}