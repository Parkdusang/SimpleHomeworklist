package com.example.parkdusang.homework2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyCustomAdapter extends BaseAdapter {

    Context ctx;
    int layout;
    ArrayList<MyCustomDTO> list;
    LayoutInflater inf;
    //만들었던 list_row와 listview안에 들어갈 내용의 어레이를 저장합니다
    public MyCustomAdapter(Context ctx, int layout, ArrayList<MyCustomDTO> list) {
        this.ctx = ctx;
        this.layout = layout;
        this.list = list;

        inf = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inf.inflate(layout, null);
        }
        TextView txtTitle = (TextView) convertView.findViewById(R.id.txtTitle);
        TextView txtContent = (TextView) convertView.findViewById(R.id.txtContent);
        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.imgIcon);
        // MycustomDTO에 저장해놨던 정보들을 가져와서 지정해줍니다.
        MyCustomDTO dto = list.get(position);
        txtTitle.setText(dto.getTitle());
        txtContent.setText(dto.getContent());
        imgIcon.setImageResource(dto.getImgIcon());
        return convertView;
    }

}
