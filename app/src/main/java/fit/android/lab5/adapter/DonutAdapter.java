package fit.android.lab5.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

import fit.android.lab5.R;
import fit.android.lab5.activity.CustomListViewActivity;
import fit.android.lab5.activity.DeTailDonutActivity;
import fit.android.lab5.model.Donut;

public class DonutAdapter extends BaseAdapter {

    private Context context;
    private int idLayout;
    private List<Donut> listDonuts;
    private int indexSelected = -1;

    public DonutAdapter(Context context, int idLayout, List<Donut> listDonuts) {
        this.context = context;
        this.idLayout = idLayout;
        this.listDonuts = listDonuts;
    }

    @Override
    public int getCount() {
        if(listDonuts.size() != 0 && !listDonuts.isEmpty()) {
            return listDonuts.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int index, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(idLayout, parent, false);
        }

        ImageView imgView = convertView.findViewById(R.id.imgView);
        TextView tvNameDonut = convertView.findViewById(R.id.tvNameDonut);
        TextView tvDescDonut = convertView.findViewById(R.id.tvDescDonut);
        TextView tvPrice = convertView.findViewById(R.id.tvPriceDonut);
        ImageButton btnAdd = convertView.findViewById(R.id.imageButton);
        ConstraintLayout constraintLayout = convertView.findViewById(R.id.itemConStraintLayout);
        Donut donut = listDonuts.get(index);

        if(listDonuts != null && !listDonuts.isEmpty()) {
            tvNameDonut.setText(donut.getName());
            tvDescDonut.setText(donut.getDesc());
            tvPrice.setText(donut.getFormatPrice());
            imgView.setImageResource(listDonuts.get(index).getImage());
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(context, DeTailDonutActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("image", donut.getImage());
                bundle.putString("name", donut.getName());
                bundle.putString("price", donut.getFormatPrice());

                in.putExtras(bundle);
                context.startActivity(in);
            }
        });

        return convertView;
    }
}
