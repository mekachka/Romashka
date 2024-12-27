// MainActivity.java
package com.example.romashka;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.romashka.R;


public class MainActivity extends AppCompatActivity {

    private WebView myWebView;
    private EditText editTextIP;
    private Button buttonLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Находим наши элементы
        myWebView = findViewById(R.id.webView);
        editTextIP = findViewById(R.id.editTextIP);
        buttonLoad = findViewById(R.id.buttonLoad);

        // Включаем поддержку JavaScript в WebView
        myWebView.getSettings().setJavaScriptEnabled(true);

        // Обрабатываем нажатие на кнопку "Загрузить"
        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ipAddress = editTextIP.getText().toString(); // Получаем IP-адрес из поля ввода
                if (!ipAddress.isEmpty()) {
                    // Формируем URL, добавляя HTTP протокол, если это требуется
                    String url = "http://" + ipAddress;
                    myWebView.setWebViewClient(new WebViewClient()); // Открываем сайт внутри приложения
                    myWebView.loadUrl(url); // Загружаем сайт
                }
            }
        });
    }
}
