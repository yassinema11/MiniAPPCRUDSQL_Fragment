package dev.mobile.miniappcrudsqlfragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ListerFragment extends Fragment
{

    private List<Contact> contactList;
    private RecyclerView.LayoutManager layoutManager;
    private ContactAdapter contactAdapter;

    public ListerFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_lister, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.contact_recyclerview);

        layoutManager = new LinearLayoutManager(getActivity());
        ContactBDD db = new ContactBDD(getActivity());
        contactList = db.getAllContacts();

        // Retrieve the contact list from the database

        contactAdapter = new ContactAdapter(getActivity(), contactList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(contactAdapter);

        return view;
    }
}
