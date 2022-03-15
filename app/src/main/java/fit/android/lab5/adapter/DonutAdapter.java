package fit.android.lab5.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

import fit.android.lab5.R;
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

        ConstraintLayout constraintLayout = convertView.findViewById(R.id.itemConStraintLayout);
        Donut donut = listDonuts.get(index);

        if(listDonuts != null && !listDonuts.isEmpty()) {
            tvNameDonut.setText(donut.getName());
            tvDescDonut.setText(donut.getDesc());
            tvPrice.setText(donut.getFormatPrice());

            int idDonut = donut.getId();

            switch (idDonut) {
                case 1: imgView.setImageResource(R.drawable.donut_yellow_1); break;
                case 2: imgView.setImageResource(R.drawable.tasty_donut_1); break;
                case 3: imgView.setImageResource(R.drawable.green_donut_1); break;
                case 4: imgView.setImageResource(R.drawable.donut_red_1); break;
            }
        }

        convertView.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(context, donut.getName(), Toast.LENGTH_SHORT).show();
                indexSelected = index;
                notifyDataSetChanged();
            }
        });

        if(indexSelected == index) {
            constraintLayout.setBackgroundColor(Color.CYAN);
        } else {
            constraintLayout.setBackgroundColor(Color.WHITE);
        }

        return convertView;
    }
}
