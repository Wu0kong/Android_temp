package com.example.lzp102.ui.chart.bar;

import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lzp102.R;
import com.example.lzp102.base.BaseFragment2;
import com.example.lzp102.ui.chart.line.LineViewModel;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class BarFragment extends BaseFragment2 {



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_bar, container, false);
        BarChart chart=root.findViewById(R.id.barChart);
        BarViewModel barViewModel = new ViewModelProvider(this).get(BarViewModel.class);
        barViewModel.getBarList().observe(getViewLifecycleOwner(),barBeans -> {
            List<BarEntry> entries1 = new ArrayList<>();
            List<BarEntry> entries2 = new ArrayList<>();
            for (int i = 0; i < barBeans.size(); i++) {
                entries1.add(new BarEntry(i, barBeans.get(i).getLineBean1().getSalaries()));
                entries2.add(new BarEntry(i, barBeans.get(i).getLineBean2().getSalaries()));
            }
            BarDataSet dataSet1 = new BarDataSet(entries1,"Java工资");
            dataSet1.setColor(Color.BLUE);
            dataSet1.setValueTextColor(Color.RED);
            dataSet1.setValueTextSize(10f);
            BarDataSet dataSet2 = new BarDataSet(entries2,"Php工资");
            dataSet2.setColor(Color.YELLOW);
            dataSet2.setValueTextColor(Color.GREEN);
            dataSet2.setValueTextSize(10f);
            BarData barData = new BarData(dataSet1,dataSet2);
            barData.setBarWidth(0.45f);
            chart.setData(barData);
            chart.groupBars(-0.5f,0.04f,0.03f);
            chart.invalidate();
            XAxis xAxis = chart.getXAxis();
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            xAxis.setTextColor(Color.BLACK);
            xAxis.setAxisLineColor(Color.BLACK);
            xAxis.setAxisLineWidth(3f);
            xAxis.enableGridDashedLine(10f,10f,0f);
// set a custom value formatter
            xAxis.setValueFormatter(new ValueFormatter() {
                @Override
                public String getFormattedValue(float value) {
                    return barBeans.get((int)value).getLineBean1().getYear();
                }
            });
            chart.getAxisRight().setEnabled(false);
            YAxis yAxis = chart.getAxisLeft();
            yAxis.setTextColor(Color.BLACK);
            yAxis.setAxisLineColor(Color.BLACK);
            yAxis.setAxisLineWidth(3f);
            yAxis.enableGridDashedLine(10f,10f,0f);
            yAxis.setAxisMinimum(0f); // start at zero
            yAxis.setSpaceTop(38.2f); // the axis maximum is 100
            yAxis.setTextColor(Color.BLACK);
            LimitLine limitLine=new LimitLine(10000f,"厦门市平均工资");
            limitLine.setLineColor(Color.MAGENTA);
            limitLine.setLineWidth(2f);
            yAxis.addLimitLine(limitLine);
            Legend l =chart.getLegend();
            l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
            l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
            Description description = chart.getDescription();
            description.setText("Java工程师经验与工资的对应情况");
            description.setTextSize(16f);
            description.setTextAlign(Paint.Align.CENTER);
            description.setPosition(540f,100f);
            chart.animateXY(5000,5000);
        });
        return root;
    }


}