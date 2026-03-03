package com.example.contactlistapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.contactlistapp.R;
import com.example.contactlistapp.database.DatabaseHelper;
import com.example.contactlistapp.models.Contact;

public class UpdateContactActivity extends AppCompatActivity {

    Button btnBack;
    EditText etName;
    EditText etPhoneNumber;
    Button updateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        int contactId = (int)  getIntent().getIntExtra("contactId", 0);
        DatabaseHelper databaseHelper = new DatabaseHelper(UpdateContactActivity.this);

        Contact contact = databaseHelper.getContact(contactId);

        btnBack = findViewById(R.id.btnBack);
        etName = findViewById(R.id.etName);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        updateButton = findViewById(R.id.btnAdd);

        etName.setText(contact.getName());
        etPhoneNumber.setText(contact.getPhoneNumber());



        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contact.setName(etName.getText().toString());
                contact.setPhoneNumber(etPhoneNumber.getText().toString());
                databaseHelper.updateContact(contact, contactId);

                Intent intent = new Intent(UpdateContactActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        btnBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateContactActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
}}