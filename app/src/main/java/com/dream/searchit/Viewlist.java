package com.dream.searchit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dream.searchit.models.Contact_info;

import java.util.ArrayList;

public class Viewlist extends AppCompatActivity {

    private ArrayList<Contact_info> info;
    private DatabaseHandler handler;
    private CustomAdapter adapter;
    private RecyclerView recycleview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewlist);

        handler = new DatabaseHandler(this);
        info = handler.getcontactlist();

        recycleview = (RecyclerView) findViewById(R.id.recycle);
        recycleview.setLayoutManager(new LinearLayoutManager(this));
        recycleview.setHasFixedSize(true);


        adapter = new CustomAdapter(this, info);
        recycleview.setAdapter(adapter);


    }

    public static class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

        private Context context;
        private LayoutInflater inflater;
        private ArrayList<Contact_info> infos;

        public CustomAdapter(Context context, ArrayList<Contact_info> infos) {
            this.context = context;
            this.infos = infos;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_viewlist, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Contact_info info_1 = infos.get(position);
            int pos = position + 1;
            holder.tv_first.setText(info_1.getName());
            holder.tv_second.setText(String.valueOf(info_1.getNumber()));
            holder.tv_third.setText(info_1.getAddress());
            holder.tv_fourth.setText(+pos + ". ");
            pos++;

        }

        @Override
        public int getItemCount() {
            return infos.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {

            public TextView tv_first;
            public TextView tv_second;
            public TextView tv_third;
            public TextView tv_fourth;

            public ViewHolder(View itemView) {
                super(itemView);

                tv_first = (TextView) itemView.findViewById(R.id.text_name);
                tv_second = (TextView) itemView.findViewById(R.id.text_number);
                tv_third = (TextView) itemView.findViewById(R.id.text_address);
                tv_fourth = (TextView) itemView.findViewById(R.id.text_sn);



            }


        }
    }
}
