package com.example.lzp102.ui.me.user;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.lzp102.R;
import com.example.lzp102.base.BaseFragment2;
import com.example.lzp102.bean.User;
import com.google.android.material.snackbar.Snackbar;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;


public class InfoFragment extends BaseFragment2 {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_info, container, false);
        TextView textView=root.findViewById(R.id.textView25);
        TextView textView2=root.findViewById(R.id.textView21);
        TextView textView3=root.findViewById(R.id.textView22);
        TextView textView4=root.findViewById(R.id.textView23);
        TextView textView5=root.findViewById(R.id.textView24);
        if (BmobUser.isLogin()){
            User user=BmobUser.getCurrentUser(User.class);
            textView.setText(user.getUsername());
            textView.setText(user.getNickName());
            textView.setText(user.isSex()?"男":"女");
            textView.setText(user.getEmail());
            textView.setText(user.getInfo());
        }
        Button button5=root.findViewById(R.id.button5);
        button5.setOnClickListener(this::logOut);
        return root;
    }

    private void logOut(View view) {
        BmobUser.logOut();
        Navigation.findNavController(view).navigateUp();
        Snackbar.make(view, "退出登录：" , Snackbar.LENGTH_LONG).show();
    }
}