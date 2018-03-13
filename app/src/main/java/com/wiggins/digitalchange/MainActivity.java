package com.wiggins.digitalchange;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.wiggins.digitalchange.base.BaseActivity;
import com.wiggins.digitalchange.utils.UIUtils;
import com.wiggins.digitalchange.widget.NumberRollingView;
import com.wiggins.digitalchange.widget.TitleView;

/**
 * @Description 自定义数字滚动动画的TextView
 * @create 2018-03-13
 */
public class MainActivity extends BaseActivity {

    private TitleView titleView;
    private SwipeRefreshLayout srlRefresh;
    private NumberRollingView tvMoney;
    private NumberRollingView tvNum;
    private NumberRollingView tvNumText;
    private NumberRollingView tvNumTextWithStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        setListener();
    }

    private void initView() {
        titleView = (TitleView) findViewById(R.id.titleView);
        titleView.setAppTitle(UIUtils.getString(R.string.title));
        titleView.setLeftImageVisibility(View.GONE);
        srlRefresh = (SwipeRefreshLayout) findViewById(R.id.srl_refresh);
        srlRefresh.setColorSchemeColors(Color.parseColor("#ff33b5e5"));
        tvMoney = (NumberRollingView) findViewById(R.id.tv_money);
        tvNum = (NumberRollingView) findViewById(R.id.tv_num);
        tvNumText = (NumberRollingView) findViewById(R.id.tv_num_text);
        tvNumTextWithStyle = (NumberRollingView) findViewById(R.id.tv_num_text_with_style);
        tvNumText.setTextType(NumberRollingView.NUM_STRING_TYPE);
        tvNumTextWithStyle.setTextType(NumberRollingView.NUM_STRING_TYPE_WITH_STYLE);
    }

    private void initData() {
        tvMoney.setContent("9999666.86", false);
        tvNum.setContent("99999666", false);
        tvNumText.setContent("108898701", false);
        tvNumTextWithStyle.setContent("200465456",false);
    }

    private void setListener() {
        srlRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                tvMoney.setUseCommaFormat(true);
                tvNum.setUseCommaFormat(true);
                tvNum.setFrameNum(30);
                tvMoney.setContent("9999666.86", false);
                tvNum.setContent("99999666", false);
                tvNumText.setContent("108898701", false);
                tvNumTextWithStyle.setContent("200465456",false);
                srlRefresh.setRefreshing(false);
            }
        });
    }
}
