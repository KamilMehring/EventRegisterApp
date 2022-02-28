package com.example.eventregisteryapp.ui.rules;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.eventregisteryapp.R;
import com.example.eventregisteryapp.databinding.FragmentHomeBinding;
import com.example.eventregisteryapp.databinding.FragmentRulesBinding;
import com.example.eventregisteryapp.ui.SharedDataViewModel;
import com.example.eventregisteryapp.ui.home.HomeViewModel;
import org.jetbrains.annotations.NotNull;

public class RulesFragment extends Fragment {

    private SharedDataViewModel sd;
    private RulesViewModel rulesViewModel ;
    private FragmentRulesBinding binding;
    private static final String TAG = "_DP_";

    public void onCreate(@Nullable Bundle savedInstatnceState) {
        super.onCreate(savedInstatnceState);
        Log.i(TAG, "CREATE FRAGMENT");
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "CREATE VIEW");
        rulesViewModel = new ViewModelProvider(this).get(RulesViewModel.class);

    binding = FragmentRulesBinding.inflate(inflater, container, false);
    View root = binding.getRoot();
        WebView webView = binding.docView;
        webView.loadUrl("file:///android_asset/docs/doc1.html");
        final TextView textView = binding.docTitle;
        rulesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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
        Log.i(TAG, "VIEW CREATED");
        sd = new ViewModelProvider(requireActivity()).get(SharedDataViewModel.class);
        String doIt = "x " + sd.getData();
        Log.i(TAG, doIt);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "DESTROY VIEW");
        binding = null;
    }
}