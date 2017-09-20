package com.example.fazazulfikapp.myapplication.view.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fazazulfikapp.myapplication.R;
import com.example.fazazulfikapp.myapplication.presenter.CirclePresenter;

/**
 * Dibuat oleh Faza Zulfika Permana Putra
 * Pada Selasa, 19 September 2017
 */

public class CircleFragment extends Fragment {

    private CirclePresenter circlePresenter;
    private TextInputEditText tietR;
    private TextInputLayout tilR;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_circle, container, false);

        tietR = (TextInputEditText) view.findViewById(R.id.tiet_r);
        tilR = (TextInputLayout) view.findViewById(R.id.til_r);

        view.findViewById(R.id.btn_keliling).setOnClickListener(new OnKelilingClickedListener());
        view.findViewById(R.id.btn_luas).setOnClickListener(new OnLuasClickedListener());

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        circlePresenter = new CirclePresenter(this);
    }

    private boolean checkNull(String r) {
        boolean isEmpty = r.isEmpty();

        if (isEmpty) {
            tilR.setErrorEnabled(true);
            tilR.setError("R cannot be empty");
        } else
            tilR.setErrorEnabled(false);

        return isEmpty;
    }

    public void showResult(double result) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        String title = getString(R.string.result);
        String ok = getString(R.string.ok);

        builder.setTitle(title)
                .setMessage(String.valueOf(result))
                .setNegativeButton(ok, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tietR.setText(null);
                        dialog.dismiss();
                    }
                });

        AlertDialog alertDialog = builder.create();

        alertDialog.setCancelable(false);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }

    private class OnKelilingClickedListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String r = tietR.getText().toString();

            if (!checkNull(r))
                circlePresenter.calculateKeliling(Double.parseDouble(r));
        }
    }

    private class OnLuasClickedListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String r = tietR.getText().toString();

            if (!checkNull(r))
                circlePresenter.calculateLuas(Double.parseDouble(r));
        }
    }
}
