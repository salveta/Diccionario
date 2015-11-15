package com.gumisaurios.diccionarioratonero;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class DetailActivity extends Activity {

    private Note note;
    private TextView titleEditText;
    private TextView contentEditText;
    private Button editarButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Intent intent = this.getIntent();

        titleEditText = (TextView) findViewById(R.id.noteTitle);
        contentEditText = (TextView) findViewById(R.id.noteContent);
        editarButton = (Button) findViewById(R.id.buttonEditar);


            editarButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), EditPalabras.class);
                    intent.putExtra("noteId", note.getId());
                    intent.putExtra("noteTitle", note.getTitle());
                    intent.putExtra("noteContent", note.getContent());
                    startActivity(intent);
                }
            });


        if (intent.getExtras() != null) {
            note = new Note(intent.getStringExtra("noteId"),
                            intent.getStringExtra("noteTitle"),
                            intent.getStringExtra("noteContent"));

            titleEditText.setText(note.getTitle());
            contentEditText.setText(note.getContent());
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
