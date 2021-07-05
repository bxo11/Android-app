package com.example.zadanie2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class FragmentInput extends Fragment {
    private View view;
    private MainActivity mActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_input, container, false);

        TextView editText = (TextView) view.findViewById(R.id.editText);
        Button buttonProcess = (Button) view.findViewById(R.id.buttonProcess);
        buttonProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = String.valueOf(editText.getText());
                if (input.isEmpty()) {
                    return;
                }
                SimpleTask s = new SimpleTask();
                int[] array = s.prepareData(input);
                if (array.length < 3) {
                    return;
                }
                int result = s.processArray(array);

                mActivity.setResultValue(result);
                Navigation.findNavController(mActivity, R.id.fragmentContainerView).navigate(R.id.action_fragmentInput_to_fragmentOutput);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (MainActivity) context;
    }

}

