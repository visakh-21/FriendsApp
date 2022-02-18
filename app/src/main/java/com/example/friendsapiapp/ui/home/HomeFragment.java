package com.example.friendsapiapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.friendsapiapp.R;
import com.example.friendsapiapp.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    EditText e1,e2;
    AppCompatButton b1;
    String getName,getRollNo;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        e1=(EditText) root.findViewById(R.id.nm);
        e2=(EditText) root.findViewById(R.id.rlno);
        b1=(AppCompatButton) root.findViewById(R.id.subtn);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getName=e1.getText().toString();
                getRollNo=e2.getText().toString();
                Toast.makeText(getActivity(),getName, Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(),getRollNo, Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), "Submitted", Toast.LENGTH_SHORT).show();
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}