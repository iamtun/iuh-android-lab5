package fit.android.lab5.activity;

import androidx.appcompat.app.AppCompatActivity;
import fit.android.lab5.R;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DeTailDonutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_donut_activity);

        ImageView imgView = findViewById(R.id.imgDonut);
        TextView tvName = findViewById(R.id.tvNameDonutDetails);
        TextView tvPrice = findViewById(R.id.tvPriceDonutDetails);

        Intent in = getIntent();
        int idImage = in.getIntExtra("image",0);
        String nameDonut = in.getStringExtra("name");
        String priceDonut = in.getStringExtra("price");

        imgView.setImageResource(idImage);
        tvName.setText(nameDonut);
        tvPrice.setText(priceDonut);
    }
}