package fpt.edu.aptcoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

// Xoá import không cần thiết
// import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

// Thêm import cho BadgeDrawable
import com.google.android.material.badge.BadgeDrawable;

import java.util.ArrayList;

import fpt.edu.aptcoffee.adapter.ViewPagerMainAdapter;
import fpt.edu.aptcoffee.dao.ThongBaoDAO;
import fpt.edu.aptcoffee.model.ThongBao;
import fpt.edu.aptcoffee.ui.SignInActivity;

public class MainActivity extends AppCompatActivity {
    private String keyUser = "";
    ViewPager2 vp2Main;
    BottomNavigationView bnvMain;
    // Xoá biến View cũ, thay bằng BadgeDrawable
    BadgeDrawable notificationBadge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initViewPager2Main();
        setKeyUser();
        // Gọi hàm thiết lập badge mới
        setupNotificationBadge();

        bnvMain.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        vp2Main.setCurrentItem(0, false);
                        break;
                    case R.id.menu_search:
                        vp2Main.setCurrentItem(1, false);
                        break;
                    case R.id.menu_notification:
                        vp2Main.setCurrentItem(2, false);
                        break;
                    case R.id.menu_setting:
                        vp2Main.setCurrentItem(3, false);
                        break;
                }
                // Khi chuyển tab, kiểm tra lại trạng thái thông báo
                checkStatusNotification();
                return true;
            }
        });
    }

    private void initView() {
        bnvMain = findViewById(R.id.bnvMain);
        vp2Main = findViewById(R.id.viewPager2Main);
    }

    private void initViewPager2Main() {
        ViewPagerMainAdapter adapter = new ViewPagerMainAdapter(this);
        vp2Main.setUserInputEnabled(false);
        vp2Main.setOffscreenPageLimit(3);
        vp2Main.setAdapter(adapter);
    }

    // (Phương thức cũ showIconNotification() đã được xoá và thay thế bằng phương thức dưới đây)
    /**
     * Khởi tạo và thiết lập Badge cho mục thông báo.
     * Đây là cách làm chính thống được Google khuyến khích.
     */
    private void setupNotificationBadge() {
        // Lấy hoặc tạo một badge cho item menu có id là R.id.menu_notification
        notificationBadge = bnvMain.getOrCreateBadge(R.id.menu_notification);
        // Ban đầu, ẩn badge đi
        notificationBadge.setVisible(false);
        // Bạn có thể tuỳ chỉnh thêm cho badge nếu muốn, ví dụ:
        // notificationBadge.setNumber(5);
        // notificationBadge.setBackgroundColor(getColor(R.color.your_color));

        // Kiểm tra trạng thái thông báo lần đầu
        checkStatusNotification();
    }

    /**
     * Kiểm tra và cập nhật trạng thái hiển thị của badge.
     */
    private void checkStatusNotification() {
        if (notificationBadge == null) {
            return; // Tránh lỗi nếu badge chưa được khởi tạo
        }
        ThongBaoDAO thongBaoDAO = new ThongBaoDAO(this);
        ArrayList<ThongBao> listNotification = thongBaoDAO.getByTrangThaiChuaXem();

        // SỬA LỖI: Sử dụng isEmpty() thay cho size() == 0
        if (listNotification.isEmpty()) {
            // Ẩn badge nếu không có thông báo mới
            notificationBadge.setVisible(false);
        } else {
            // Hiện badge nếu có thông báo mới
            notificationBadge.setVisible(true);
            // Nếu muốn hiện số lượng thông báo, dùng dòng dưới đây
            // notificationBadge.setNumber(listNotification.size());
        }
    }

    private void setKeyUser() {
        Intent intent = this.getIntent();
        keyUser = intent.getStringExtra(SignInActivity.KEY_USER);
    }

    public String getKeyUser() {
        return keyUser;
    }

    @Override
    public void onBackPressed() {
        if (vp2Main.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            vp2Main.setCurrentItem(0, false);
            bnvMain.setSelectedItemId(R.id.menu_home);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Cập nhật lại trạng thái thông báo mỗi khi quay lại MainActivity
        checkStatusNotification();
    }
}