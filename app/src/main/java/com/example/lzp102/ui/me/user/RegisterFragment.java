package com.example.lzp102.ui.me.user;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.lzp102.R;
import com.example.lzp102.base.BaseFragment2;
import com.example.lzp102.bean.User;
import com.google.android.material.snackbar.Snackbar;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;


public class RegisterFragment extends BaseFragment2 {
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_register, container, false);
        editText3=root.findViewById(R.id.editText3);
        editText4=root.findViewById(R.id.editText4);
        editText5=root.findViewById(R.id.editText5);
        Button button3=root.findViewById(R.id.button3);
        button3.setOnClickListener(this::signUp);
        return root;
    }
    private void signUp(final View view) {
        String name = editText3.getText().toString();
        String password = editText4.getText().toString();
        String email = editText5.getText().toString();
        if(TextUtils.isEmpty(name)){
            editText3.setError("账号不能为空");
            return;
        }if(TextUtils.isEmpty(password)){
            editText4.setError("密码不能为空");
            return;
        }if(TextUtils.isEmpty(email)){
            editText5.setError("邮箱不能为空");
            return;
        }
        final User user = new User();
        user.setUsername(name);
        user.setPassword(password);
        user.setNickName(name);
        user.setSex(true);
        user.setEmail(email);
        user.setInfo("空");
        user.signUp(new SaveListener<User>() {
            @Override
            public void done(User user, BmobException e) {
                if (e == null) {
                    Snackbar.make(view, "注册成功", Snackbar.LENGTH_LONG).show();
                    Navigation.findNavController(view).navigateUp();
                } else {
                    Snackbar.make(view, "尚未失败：" + e.getMessage(), Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}