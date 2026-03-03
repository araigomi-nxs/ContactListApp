package com.example.contactlistapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.contactlistapp.R;
import com.example.contactlistapp.database.DatabaseHelper;
import com.example.contactlistapp.functions.ContactListAdapter;
import com.example.contactlistapp.models.Contact;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        DatabaseHelper db = new DatabaseHelper(MainActivity.this);
        //Contact contact = new Contact( 1, "John Doe", "1234567890" , 1);
        //Log.d("MainActivity", "Inserting contact: " + contact.getName());
        //db.insertContact(contact);

        ListView listView = findViewById(R.id.list);
        ContactListAdapter adapter = new ContactListAdapter(MainActivity.this, db.getAllContacts());
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        Button addContactButton = findViewById(R.id.btnAdd);

        addContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ContactFormActivity.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, UpdateContactActivity.class);

                intent.putExtra("contactId", db.getContact(position+1 ).getId());
                startActivity(intent);
        }});
        }
    

    }
