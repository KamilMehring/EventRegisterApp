package com.example.eventregisteryapp.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.eventregisteryapp.R;
import com.example.eventregisteryapp.databinding.FragmentHomeBinding;
import com.example.eventregisteryapp.ui.SharedDataViewModel;

public class HomeFragment extends Fragment {
    private SharedDataViewModel sd;
    private HomeViewModel homeViewModel;
private FragmentHomeBinding binding;
private static final String TAG = "_DP_";



    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

    binding = FragmentHomeBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sd = new ViewModelProvider(requireActivity()).get(SharedDataViewModel.class);
        sd.setData("Our rules");
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}