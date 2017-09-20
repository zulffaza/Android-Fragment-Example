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
import com.example.fazazulfikapp.myapplication.presenter.TrapezoidalPresenter;

/**
 * Dibuat oleh Faza Zulfika Permana Putra
 * Pada Selasa, 19 September 2017
 */

public class TrapezoidalFragment extends Fragment {

    private TextInputEditText tietA, tietB, tietT;
    private TextInputLayout tilA, tilB, tilT;
    private TrapezoidalPresenter trapezoidalPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trapezoidal, container, false);

        tietA = (TextInputEditText) view.findViewById(R.id.tiet_a);
        tietB = (TextInputEditText) view.findViewById(R.id.tiet_b);
        tietT = (TextInputEditText) view.findViewById(R.id.tiet_t);

        tilA = (TextInputLayout) view.findViewById(R.id.til_a);
        tilB = (TextInputLayout) view.findViewById(R.id.til_b);
        tilT = (TextInputLayout) view.findViewById(R.id.til_t);

        view.findViewById(R.id.btn_keliling).setOnClickListener(new OnKelilingClickedListener());
        view.findViewById(R.id.btn_luas).setOnClickListener(new OnLuasClickedListener());

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        trapezoidalPresenter = new TrapezoidalPresenter(this);
    }

    private boolean checkNull(String a, String b, String t) {
        boolean isAEmpty = a.isEmpty();
        boolean isBEmpty = b.isEmpty();
        boolean isTEmpty = t.isEmpty();

        if (isAEmpty) {
            tilA.setErrorEnabled(true);
            tilA.setError("A cannot be empty");
        } else
            tilA.setErrorEnabled(false);

        if (isBEmpty) {
            tilB.setErrorEnabled(true);
            tilB.setError("B cannot be empty");
        } else
            tilB.setErrorEnabled(false);

        if (isTEmpty) {
            tilT.setErrorEnabled(true);
            tilT.setError("T cannot be empty");
        } else
            tilT.setErrorEnabled(false);

        return isAEmpty || isBEmpty || isTEmpty;
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
                        tietA.setText(null);
                        tietB.setText(null);
                        tietT.setText(null);
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
            String a = tietA.getText().toString();
            String b = tietB.getText().toString();
            String t = tietT.getText().toString();

            if (!checkNull(a, b, t))
                trapezoidalPresenter.calculateKeliling(Double.parseDouble(a), Double.parseDouble(b), Double.parseDouble(t));
        }
    }

    private class OnLuasClickedListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String a = tietA.getText().toString();
            String b = tietB.getText().toString();
            String t = tietT.getText().toString();

            if (!checkNull(a, b, t))
                trapezoidalPresenter.calculateLuas(Double.parseDouble(a), Double.parseDouble(b), Double.parseDouble(t));
        }
    }
}
