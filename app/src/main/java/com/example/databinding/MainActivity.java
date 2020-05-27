package com.example.databinding;
//https://juejin.im/post/5b02cf8c6fb9a07aa632146d
//https://www.youtube.com/watch?v=Q-pjoyEj_p8
//DataBinding 是谷歌官方發布的一個框架，顧名思義即為數據綁定，是 MVVM 模式在 Android 上的一種實現，用於降低佈局和邏輯的耦合性，使代碼邏輯更加清晰。
//MVVM 相對於 MVP，其實就是將 Presenter 層替換成了 ViewModel 層。 DataBinding 能夠省去我們一直以來的findViewById()
//步驟，大量減少Activity 內的代碼，數據能夠單向或雙向綁定到layout 文件中，有助於防止內存洩漏，而且能自動進行空檢測以避免空指針異常
//啟用 DataBinding 的方法是在對應 Model 的 build.gradle 文件裡加入以下代碼，同步後就能引入對 DataBinding 的支持

//和原始佈局的區別在於多出了一個layout 標籤將原佈局包裹了起來，data 標籤用於聲明要用到的變量以及變量類型，要實現MVVM 的ViewModel 就需要把數據（Model）與UI（View）進行綁定，data 標籤的作用就像一個橋樑搭建了View 和Model 之間的通道

//1.bulid.gradle
//android {
//        ...
//        dataBinding {
//        enabled = true
//        }
//        }

//2.在xml外層包一層 <layout></Layout>
//3.DataBindingUtil.setContentView(this,R.layout.activity_main);
//4.宣告 ActivityMainBinding binding; //宣告被layout包起來的元件
//5.創建一個Mode User
//6.在xml配置 <data> 綁定的資料
//              <variable
//            name="user" model name
//            type="com.example.databinding.User" /> model類別
//          </data>
//7.android:text="@{user.strName}"  //直接取得user getStarName  == getStrName()的值;
//8.binding.setUser(new User("Hank")): //直接設定新的物件name上去
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    //4.
    ActivityMainBinding binding; //宣告被layout包起來的元件
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //3.
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        //5.
        binding.setUser(new User("Hank"));
    }
}
