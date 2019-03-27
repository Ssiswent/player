package vvfgaa.player;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;

import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipe_refresh_layout;
    private FlowingDrawer mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new PlayAdapter(getPlaysource()));

        swipe_refresh_layout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);//找到刷新对象
        swipe_refresh_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {//设置刷新监听器
            @Override
            public void onRefresh()
            {
                new Handler().postDelayed(new Runnable() {//模拟耗时操作
                    @Override
                    public void run() {
                        swipe_refresh_layout.setRefreshing(false);//取消刷新

                    }
                },2000);
            }
        });


        mDrawer = (FlowingDrawer) findViewById(R.id.drawerlayout);
        mDrawer = (FlowingDrawer) findViewById(R.id.drawerlayout);
        mDrawer.setTouchMode(ElasticDrawer.TOUCH_MODE_BEZEL);
    }

    private List<Playsource> getPlaysource(){
        List<Playsource> playsources=new ArrayList<>();
        playsources.add(new Playsource("CCTV-1","http://223.110.241.139:6610/gitv/live1/G_CCTV-1-HQ/G_CCTV-1-HQ.m3u8"));
        playsources.add(new Playsource("CCTV-2","http://223.110.241.139:6610/gitv/live1/G_CCTV-2-HD/G_CCTV-2-HD.m3u8"));
        playsources.add(new Playsource("CCTV-3","http://223.110.241.139:6610/gitv/live1/G_CCTV-3-HQ/G_CCTV-3-HQ.m3u8"));
        playsources.add(new Playsource("CCTV-4","http://223.110.241.139:6610/gitv/live1/G_CCTV-4-HQ/G_CCTV-4-HQ.m3u8"));
        playsources.add(new Playsource("CCTV-5","http://223.110.241.139:6610/gitv/live1/G_CCTV-5-HQ/G_CCTV-5-HQ.m3u8"));
        playsources.add(new Playsource("CCTV-5+","http://223.110.241.139:6610/gitv/live1/G_CCTV-5PLUS-HQ/G_CCTV-5PLUS-HQ.m3u8"));
        playsources.add(new Playsource("CCTV-6","http://223.110.241.139:6610/gitv/live1/G_CCTV-6-HQ/G_CCTV-6-HQ.m3u8"));
        playsources.add(new Playsource("CCTV-7","http://223.110.241.139:6610/gitv/live1/G_CCTV-7-HQ/G_CCTV-7-HQ.m3u8"));
        playsources.add(new Playsource("CCTV-8","http://223.110.241.139:6610/gitv/live1/G_CCTV-8-HQ/G_CCTV-8-HQ.m3u8"));
        playsources.add(new Playsource("江苏卫视","http://223.110.241.139:6610/gitv/live1/G_JIANGSU-CQ/G_JIANGSU-CQ.m3u8"));
        return playsources;
    }
}
