package com.example.lzp102.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lzp102.R;
import com.example.lzp102.adapter.HomeAdapter;
import com.example.lzp102.adapter.ImageAdapter;
import com.example.lzp102.adapter.ImageTitleNumAdapter;
import com.example.lzp102.bean.NewsBean;
import com.example.lzp102.databinding.FragmentHomeBinding;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.transformer.ZoomOutPageTransformer;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;
    private HomeAdapter homeAdapter;
    private Banner<?, BannerAdapter<?,?>> banner;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        RefreshLayout refreshLayout = root.findViewById(R.id.refreshLayout);
        RecyclerView recyclerView =root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        homeAdapter = new HomeAdapter(null);
        recyclerView.setAdapter(homeAdapter);
        homeAdapter.setEmptyView(R.layout.empty_home);
        View headerview = inflater.inflate(R.layout.header_home,container,false);
        homeAdapter.addHeaderView(headerview);
        homeAdapter.setHeaderWithEmptyEnable(true);
        banner = headerview.findViewById(R.id.banner);
        banner.addBannerLifecycleObserver(this)//添加生命周期观察者
//                .setPageTransformer(new ZoomOutPageTransformer());
                .setBannerGalleryMZ(20,0.8f);
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(R.drawable.pic_item_list_default);
        }
        banner.setAdapter(new ImageAdapter(list));
        refreshLayout.setOnRefreshListener(refresh -> {
            refresh.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            getAdList();
            getNewsList();
        }
        );
        refreshLayout.setOnLoadMoreListener(refresh -> {
            refresh.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            Toast.makeText(getActivity(),"没有更多数据了",Toast.LENGTH_SHORT).show();
        });
        getAdList();
        getNewsList();
        LinearLayout linearLayout_python = headerview.findViewById(R.id.linearLayout_python);
        linearLayout_python.setOnClickListener(v -> Navigation.findNavController(v)
                .navigate(R.id.action_navigation_home_to_pythonFragment));
        homeAdapter.setOnItemClickListener((adapter, view, position) -> {
            Bundle bundle = new Bundle();
            bundle.putString("url",homeAdapter.getData().get(position).getNewsUrl());
            Navigation.findNavController(view)
                    .navigate(R.id.action_navigation_home_to_webFragment,bundle);
        });
        return root;
    }

    private void getAdList() {
        homeViewModel.getAdList().observe(getViewLifecycleOwner(), newsBeans -> {
            banner.setAdapter(new ImageTitleNumAdapter(newsBeans));
            banner.setOnBannerListener((data, position) -> {
                Bundle bundle = new Bundle();
                bundle.putString("url",((NewsBean)data).getNewsUrl());
                Navigation.findNavController(banner)
                        .navigate(R.id.action_navigation_home_to_webFragment,bundle);
            });
        });
    }

    private void getNewsList() {
        homeViewModel.getNewsList().observe(getViewLifecycleOwner(), newsBeans -> {
            homeAdapter.setList(newsBeans);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}