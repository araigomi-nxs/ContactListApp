package com.example.contactlistapp.functions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.contactlistapp.R;
import com.example.contactlistapp.models.Contact;

import java.util.List;

public class ContactListAdapter extends ArrayAdapter<Contact> {

    private Context context;
    private List<Contact> contacts;
    public ContactListAdapter(@NonNull Context context, List<Contact> contacts) {
        super(context, 0, contacts);
        this.context = context;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View contactview = convertView;

        if(contactview == null)
        {
            contactview = LayoutInflater.from(context).inflate(R.layout.contact_list_card, parent, false);

        }
        Contact currentContact = contacts.get(position);

        TextView nametv = contactview.findViewById(R.id.tvName);
        TextView phoneNumtv = contactview.findViewById(R.id.tvPhoneNumber);
        //ImageView imageView = contactview.findViewById(R.id.image);

        nametv.setText(currentContact.getName());
        phoneNumtv.setText(currentContact.getPhoneNumber());
        //imageView.setImageResource(currentContact.getImage());

        return contactview;

    }
}
