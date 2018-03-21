package com.dream.searchit;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dream.searchit.models.Contact_info;

import static android.R.id.message;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {
    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private ImageView call;
    private ImageView sms;
    private Contact_info info;
    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_first, container, false);

        txt1= (TextView) layout.findViewById(R.id.display_text_1);
        txt2= (TextView) layout.findViewById(R.id.display_text_2);
        txt3= (TextView) layout.findViewById(R.id.display_text_3);
        call= (ImageView) layout.findViewById(R.id.phone_call);
        sms= (ImageView) layout.findViewById(R.id.send_sms);

        Intent i = getActivity().getIntent(); // in case of fragment, write getactivity.getintent to call data from activity!!
        info= (Contact_info) i.getSerializableExtra("Name");

        String name = info.getName().toString();
        final String num = info.getNumber().toString();
        String add = info.getAddress();


        txt1.setText(name);
        txt2.setText(num);
        txt3.setText(add);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+num));
                startActivity(intent);

            }
        });

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:" +num));
                startActivity(sendIntent);

            }
        });


        return layout;



    }

}
