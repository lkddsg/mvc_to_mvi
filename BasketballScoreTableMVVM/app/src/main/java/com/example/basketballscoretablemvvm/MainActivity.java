package com.example.basketballscoretablemvvm;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.databinding.DataBindingUtil;

import com.example.basketballscoretablemvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    MyViewModel myViewModel;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // 使用 DataBindingUtil 设置内容视图并初始化 binding 对象
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // 获取 ViewModel 实例
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        // 绑定 ViewModel
        binding.setViewModel(myViewModel);
        // 确保 LiveData 能自动更新视图
        binding.setLifecycleOwner(this);
        // 设置窗口插入监听器
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
//注册observe是类似这样的代码。但是由于后面用了databinding双向绑定，这一段也就省去了。
//        viewModel.getLiveData().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String data) {
//                // 更新UI
//                textView.setText(data);
//            }
//        });