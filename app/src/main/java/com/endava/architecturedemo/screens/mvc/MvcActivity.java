package com.endava.architecturedemo.screens.mvc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.endava.architecturedemo.R;
import com.endava.architecturedemo.api.MockNetworkApi;
import com.endava.architecturedemo.api.NetworkApi;
import com.endava.architecturedemo.data.domain.User;
import com.endava.architecturedemo.data.repository.UserRepository;
import com.endava.architecturedemo.screens.mvp.MvpActivity;
import com.endava.architecturedemo.screens.viper.ViperActivity;

public class MvcActivity extends AppCompatActivity {

  private TextView mvc;
  private TextView mvp;
  private TextView viper;
  private UserRepository userRepository;
  private NetworkApi networkApi;

  public static void start(Context context) {
    Intent intent = new Intent(context, MvcActivity.class);
    context.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_content);

    userRepository = new UserRepository();
    networkApi = new MockNetworkApi();

    mvc = (TextView) findViewById(R.id.mvc);
    mvp = (TextView) findViewById(R.id.mvp);
    viper = (TextView) findViewById(R.id.viper);

    mvc.setOnClickListener(v -> MvcActivity.start(MvcActivity.this));
    mvp.setOnClickListener(v -> MvpActivity.start(MvcActivity.this));
    viper.setOnClickListener(v -> ViperActivity.start(MvcActivity.this));

    User user = networkApi.getUser("George");
    userRepository.storeUser(user);
  }
}