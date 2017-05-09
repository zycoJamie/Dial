package com.android.zycojamie.callphone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zckya on 2017/5/9.
 */

public class ContactAdapter extends ArrayAdapter<Contacts> {
    private int resourceId;
    public ContactAdapter(Context context, int resourceId, List<Contacts> mlist){
        super(context,resourceId,mlist);
        this.resourceId=resourceId;
    }
    class ViewHolder{
        private TextView text1;
        private TextView text2;
        public ViewHolder(View view){
            text1=(TextView)view.findViewById(R.id.name);
            text2=(TextView)view.findViewById(R.id.number);
        }

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            ViewHolder holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        ViewHolder holder=(ViewHolder)convertView.getTag();
        Contacts contact=getItem(position);
        holder.text1.setText(contact.getName());
        holder.text2.setText(contact.getNumber());
        return convertView;
    }
}
