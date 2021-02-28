package com.example.dardocassignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DataInfoFragment extends Fragment {

  String mAnyData;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            mAnyData = bundle.getString("anydata", "");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        return getRenderedView(inflater,container);
    }

    private View getRenderedView(LayoutInflater inflater, ViewGroup container){
        View view =
                inflater.inflate(R.layout.fragment_data_info, container, false);


        return  view;
    }
}
