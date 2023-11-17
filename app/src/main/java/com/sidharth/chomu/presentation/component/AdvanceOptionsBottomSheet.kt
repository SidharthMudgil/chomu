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
        val binding = SheetAdvancedOptionBinding.inflate(inflater)

        binding.btnCancel.setOnClickListener {
            dismiss()
        }

        binding.btnApply.setOnClickListener {
//            findNavController().previousBackStackEntry?.savedStateHandle?.set(
//
//            )
            dismiss()
        }

        return binding.root
    }

    companion object {

    }

//      TODO(copy paste below code to each fragment where data is needed)
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        findNavController().currentBackStackEntry
//            ?.savedStateHandle
//            ?.getLiveData<Int>(ModalBottomSheet.KEY)
//            ?.observe(viewLifecycleOwner) { collection ->
//                if (args.game != null || game != null) {
//                    userDataViewModel.addGameToCollection(args.game ?: game!!, collection)
//                }
//            }
//    }
}