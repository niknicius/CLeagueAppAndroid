package tk.cleague.app;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView wv = null;
    private FloatingActionButton fabBack,fabHome,fabTeams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.wv = findViewById(R.id.principalWB);

        this.fabBack = findViewById(R.id.buttonBack);
        this.fabHome = findViewById(R.id.buttonHome);
        this.fabTeams = findViewById(R.id.buttonTeams);
        final Context context = getApplicationContext();

        this.wv.setWebViewClient(new WebViewClient());

        WebSettings ws = this.wv.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setSupportZoom(false);

        this.wv.loadUrl("https://cleague.tk");

        this.fabBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(wv.getUrl().equalsIgnoreCase("https://cleague.tk/start")){
                    CharSequence text = "Não tem mais para onde voltar!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {
                    wv.goBack();
                }
            }
        });

        this.fabTeams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://cleague.tk/teams";

                if(wv.getUrl().equalsIgnoreCase(url)){
                    CharSequence text = "Você já está na pagina do calendário!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {
                    wv.loadUrl(url);
                }
            }
        });

        this.fabHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://cleague.tk/start";

                if(wv.getUrl().equalsIgnoreCase(url)){
                    CharSequence text = "Você já está na home!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {
                    wv.loadUrl(url);
                }
            }
        });
    }

}
