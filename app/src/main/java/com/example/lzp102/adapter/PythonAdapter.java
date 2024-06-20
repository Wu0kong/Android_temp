package com.example.lzp102.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.lzp102.R;
import com.example.lzp102.bean.PythonBean;

import java.util.List;

public class PythonAdapter extends BaseQuickAdapter<PythonBean, BaseViewHolder> {
    public PythonAdapter(@Nullable List<PythonBean> data) {
        super(R.layout.item_python, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, PythonBean pythonBean) {
        baseViewHolder.setText(R.id.textView6, pythonBean.getAddress());
        baseViewHolder.setText(R.id.textView7, pythonBean.getContent());
        baseViewHolder.setText(R.id.textView8, pythonBean.getOpen_class());
    }
}
