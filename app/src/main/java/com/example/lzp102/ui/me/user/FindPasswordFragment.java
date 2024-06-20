package com.example.lzp102.ui.me.user;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.lzp102.R;
import com.example.lzp102.base.BaseFragment2;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;


public class FindPasswordFragment extends BaseFragment2 {
    private EditText editText6;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =inflater.inflate(R.layout.fragment_find_password, container, false);
        editText6=root.findViewById(R.id.editText6);
        Button button2=root.findViewById(R.id.button4);
        button2.setOnClickListener(this::resetPasswordByEmail);
        return root;
    }
    /**
     * 邮箱重置密码
     */
    private void resetPasswordByEmail(View view) {
        String email = editText6.getText().toString();
        if(TextUtils.isEmpty(email)){
            editText6.setError("邮箱不能为空");
            return;
        }

        BmobUser.resetPasswordByEmail(email, new UpdateListener() {

            @Override
            public void done(BmobException e) {
                if (e == null) {
                    Snackbar.make(view, "重置密码请求成功，请到" + email + "邮箱进行密码重置操作", Snackbar.LENGTH_LONG).show();
                    Navigation.findNavController(view).navigateUp();
                } else {
                    Log.e("BMOB", e.toString());
                    Snackbar.make(view, Objects.requireNonNull(e.getMessage()), Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}