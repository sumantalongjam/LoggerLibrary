package example.uncaughtexception;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondaty);
        Button exeBtn = (Button)findViewById(R.id.exeBtn);
        exeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = 10/0;
            }
        });
    }
}
