package com.example.lzp102.ui.me.user;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.navigation.Navigation;

import com.example.lzp102.R;
import com.example.lzp102.base.BaseFragment2;
import com.example.lzp102.bean.User;
import com.google.android.material.snackbar.Snackbar;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;


public class LoginFragment extends BaseFragment2{
    private EditText editText;
    private EditText editText2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_login, container, false);
        editText=root.findViewById(R.id.editText);
        editText2=root.findViewById(R.id.editText2);
        TextView textView=root.findViewById(R.id.textView11);
        textView.setOnClickListener(v -> Navigation.findNavController(v)
                .navigate(R.id.action_loginFragment_to_registerFragment));
        TextView textView2=root.findViewById(R.id.textView12);
        textView2.setOnClickListener(v -> Navigation.findNavController(v)
                .navigate(R.id.action_loginFragment_to_findPasswordFragment));
            Button button2=root.findViewById(R.id.button2);
            button2.setOnClickListener(this::login);
        return root;
    }
    /**
     * 账号密码登录
     */
    private void login(final View view) {
        String name = editText.getText().toString();
        String password = editText2.getText().toString();
        final User user = new User();
        //此处替换为你的用户名
        user.setUsername(name);
        //此处替换为你的密码
        user.setPassword(password);
        user.login(new SaveListener<User>() {
            @Override
            public void done(User bmobUser, BmobException e) {
                if (e == null) {
                    User user = BmobUser.getCurrentUser(User.class);
                    Snackbar.make(view, "登录成功：" + user.getUsername(), Snackbar.LENGTH_LONG).show();
                    Navigation.findNavController(view).navigateUp();
                } else {
                    Snackbar.make(view, "登录失败：" + e.getMessage(), Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}