package co.edu.unipiloto.mymessenger;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class ReceiveMessageActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);

        // Si se recibe un mensaje, mostrarlo
        Intent intent = getIntent();
        String messageText = intent.getStringExtra(EXTRA_MESSAGE);
        if (messageText != null) {
            TextView messageView = (TextView) findViewById(R.id.mensage);
            messageView.setText(messageText);
        }
    }

    public void onSendMessage(View view) {
        EditText messageView = (EditText) findViewById(R.id.messageInput);
        String messageText = messageView.getText().toString();
        Intent intent = new Intent(this, CreateMessageActivity.class);
        intent.putExtra(CreateMessageActivity.EXTRA_MESSAGE, messageText);
        startActivity(intent);
    }

}
