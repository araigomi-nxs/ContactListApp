package com.example.contactlistapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.contactlistapp.R;
import com.example.contactlistapp.database.DatabaseHelper;
import com.example.contactlistapp.models.Contact;

public class ContactFormActivity extends AppCompatActivity {
    EditText namefield;
    EditText phoneNumberfield;
    ImageView imagefield;
    Button addbutton;
    Button backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contact_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        namefield = findViewById(R.id.etName);
        phoneNumberfield = findViewById(R.id.etPhoneNumber);
        imagefield = findViewById(R.id.image);
        addbutton = findViewById(R.id.btnAdd);
        backbutton = findViewById(R.id.btnBack);

        addbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Contact contact = new Contact(0,namefield.getText().toString(), phoneNumberfield.getText().toString(), 0 );
                DatabaseHelper databaseHelper = new DatabaseHelper(ContactFormActivity.this);
                databaseHelper.insertContact(contact);

            }
        } );

    }
}