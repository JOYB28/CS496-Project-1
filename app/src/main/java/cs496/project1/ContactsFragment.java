package cs496.project1;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
class Contact {
    public String name;
    public String number;

    public Contact(String prop1, String prop2) {
        this.name = prop1;
        this.name = prop2;
    }
}

class ContactAdapter extends ArrayAdapter<Contact> {
    private Context context;
    private ArrayList<Contact> contacts;
    private ViewHolder viewHolder;

    public class ViewHolder {
        TextView name;
        TextView number;
    }

    public ContactAdapter(Context context, ArrayList<Contact> contacts) {
        super(context, 0, contacts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contact contact = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_contacts_fragment,parent,false);
        }

        viewHolder = new ViewHolder();
        viewHolder.name = (TextView) convertView.findViewById(R.id.name);
        viewHolder.number = (TextView) convertView.findViewById(R.id.number);

        viewHolder.name.setText(contact.name);
        viewHolder.number.setText(contact.number);
        return convertView;
    }
}
*/

public class ContactsFragment extends ListFragment {

    String a = "a";
    String b = "b";
    String c = "c", d="d",e="e",f="f";

    private ContactsDataSource dataSource;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        List<HashMap<String,String>> contacts = new ArrayList<>();
        dataSource = new ContactsDataSource(getActivity());
        dataSource.open();

        List<Contact> values = dataSource.getAllContacts();
/*
        for(Contact c : values) {
            HashMap<String,String> nhm = new HashMap<>();
            nhm.put("name", c.getName());
            nhm.put("number", c.getNumber());
            contacts.add(nhm);
        }

        HashMap<String,String> ab = new HashMap<>();
        ab.put("name", a);
        ab.put("number",b);
        contacts.add(ab);

        String[] from = {"name","number"};
        int[] to = {R.id.name,R.id.number};*/

        ArrayAdapter<Contact> adapter = new ArrayAdapter<Contact>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);

        return super.onCreateView(inflater,container,savedInstanceState);
    }

    public void onClick(View view){
        SimpleAdapter adapter = (SimpleAdapter) getListAdapter();
        Contact contact = null;
        switch (view.getId()){
            case R.id.add:
                break;
            case R.id.delete:
                break;
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        dataSource.open();
        super.onResume();
    }

    @Override
    public void onPause() {
        dataSource.close();
        super.onPause();
    }
}


