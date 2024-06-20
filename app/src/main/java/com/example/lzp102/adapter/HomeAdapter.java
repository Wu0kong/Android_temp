package com.example.lzp102.adapter;

import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.lzp102.R;
import com.example.lzp102.bean.NewsBean;
import com.example.lzp102.utils.NetUtils;

import java.util.List;

public class HomeAdapter extends BaseMultiItemQuickAdapter<NewsBean, BaseViewHolder> {

    public HomeAdapter(List<NewsBean> data) {
        super(data);
        // 绑定 layout 对应的 type
        addItemType(1, R.layout.item_home1);
        addItemType(2, R.layout.item_home2);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, NewsBean item) {
        // 根据返回的 type 分别设置数据
        switch (helper.getItemViewType()) {
            case 1:
                helper.setText(R.id.textView20,item.getNewsName());
                helper.setText(R.id.textView21,item.getNewsName());
                Glide.with(getContext()).load(NetUtils.BASE_URL+item.getImg1())
                        .into((ImageView) helper.getView(R.id.imageView2));
                break;
            case 2:
                helper.setText(R.id.textView22,item.getNewsName());
                helper.setText(R.id.textView23,item.getNewsName());
                Glide.with(getContext()).load(NetUtils.BASE_URL+item.getImg1())
                        .into((ImageView) helper.getView(R.id.imageView3));
                Glide.with(getContext()).load(NetUtils.BASE_URL+item.getImg2())
                        .into((ImageView) helper.getView(R.id.imageView4));
                Glide.with(getContext()).load(NetUtils.BASE_URL+item.getImg3())
                        .into((ImageView) helper.getView(R.id.imageView5));

                break;
            default:
                break;
        }
    }
}