package com.dream.searchit;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.dream.searchit.models.Contact_info;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewFragment extends Fragment {

    private ArrayList<Contact_info> info;
    private DatabaseHandler handler;
    private Viewlist.CustomAdapter adapter;
    private RecyclerView recycleview;
    public ViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_view, container, false);
        handler= new DatabaseHandler(getActivity());
        info=handler.getcontactlist();

        recycleview = (RecyclerView) layout.findViewById(R.id.recycle_view);
        recycleview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycleview.setHasFixedSize(true);




        adapter = new Viewlist.CustomAdapter(getActivity(),info);
        recycleview.setAdapter(adapter);

        return layout;



    }






    public static class CustomAdapter extends RecyclerView.Adapter<Viewlist.CustomAdapter.ViewHolder>{

        private Context context;
        private LayoutInflater inflater;
        private ArrayList<Contact_info> infos;

        public CustomAdapter(Context context,  ArrayList<Contact_info> infos) {
            this.context = context;
            this.infos = infos;
            inflater=LayoutInflater.from(context);
        }



        @Override
        public Viewlist.CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_viewlist,parent,false);
            Viewlist.CustomAdapter.ViewHolder holder = new Viewlist.CustomAdapter.ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(Viewlist.CustomAdapter.ViewHolder holder, int position) {
            Contact_info info_1 = infos.get(position);
            holder.tv_first.setText(info_1.getName());
            holder.tv_second.setText(String.valueOf(info_1.getNumber()));
            holder.tv_third.setText(info_1.getAddress());

        }

        @Override
        public int getItemCount() {
            return infos.size() ;
        }

        public static class ViewHolder extends RecyclerView.ViewHolder{

            public TextView tv_first;
            public TextView tv_second;
            public TextView tv_third;


            public ViewHolder(View itemView) {
                super(itemView);

                tv_first= (TextView) itemView.findViewById(R.id.text_name);
                tv_second= (TextView) itemView.findViewById(R.id.text_number);
                tv_third= (TextView) itemView.findViewById(R.id.text_address);



            }
        }
    }


}
