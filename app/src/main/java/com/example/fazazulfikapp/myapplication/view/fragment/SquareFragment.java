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
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.fazazulfikapp.myapplication.R;
import com.example.fazazulfikapp.myapplication.presenter.SquarePresenter;

/**
 * Dibuat oleh Faza Zulfika Permana Putra
 * Pada Selasa, 19 September 2017
 */

public class SquareFragment extends Fragment {

    private CheckBox cbP;
    private SquarePresenter squarePresenter;
    private TextInputEditText tietP, tietL;
    private TextInputLayout tilP, tilL;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_square, container, false);

        cbP = (CheckBox) view.findViewById(R.id.cb_p);
        cbP.setOnCheckedChangeListener(new IsSquareCheckedListener());

        tietP = (TextInputEditText) view.findViewById(R.id.tiet_p);
        tietL = (TextInputEditText) view.findViewById(R.id.tiet_l);

        tilP = (TextInputLayout) view.findViewById(R.id.til_p);
        tilL = (TextInputLayout) view.findViewById(R.id.til_l);

        view.findViewById(R.id.btn_keliling).setOnClickListener(new OnKelilingClickedListener());
        view.findViewById(R.id.btn_luas).setOnClickListener(new OnLuasClickedListener());

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        squarePresenter = new SquarePresenter(this);
    }

    private boolean checkNull(String p, String l) {
        boolean isPEmpty = p.isEmpty();
        boolean isLEmpty = l.isEmpty();
        boolean isSquare = cbP.isChecked();

        if (isPEmpty) {
            tilP.setErrorEnabled(true);
            tilP.setError("P cannot be empty");
        } else
            tilP.setErrorEnabled(false);

        if (!isSquare && isLEmpty) {
            tilL.setErrorEnabled(true);
            tilL.setError("L cannot be empty");
        } else
            tilL.setErrorEnabled(false);

        return isPEmpty || (!isSquare && isLEmpty);
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
                        tietP.setText(null);
                        tietL.setText(null);
                        dialog.dismiss();
                    }
                });

        AlertDialog alertDialog = builder.create();

        alertDialog.setCancelable(false);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }

    private class IsSquareCheckedListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked)
                tietL.setVisibility(View.GONE);
            else
                tietL.setVisibility(View.VISIBLE);
        }
    }

    private class OnKelilingClickedListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String p = tietP.getText().toString();
            String l = tietL.getText().toString();

            if (!checkNull(p, l)) {
                l = cbP.isChecked() ? p : l;
                squarePresenter.calculateKeliling(Double.parseDouble(p), Double.parseDouble(l));
            }
        }
    }

    private class OnLuasClickedListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String p = tietP.getText().toString();
            String l = tietL.getText().toString();

            if (!checkNull(p, l)) {
                l = cbP.isChecked() ? p : l;
                squarePresenter.calculateLuas(Double.parseDouble(p), Double.parseDouble(l));
            }
        }
    }
}
