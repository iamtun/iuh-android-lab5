package fit.android.lab5.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import fit.android.lab5.R;
import fit.android.lab5.adapter.DonutAdapter;
import fit.android.lab5.model.Donut;

public class CustomListViewActivity extends AppCompatActivity {
    private List<Donut> listDonuts;
    private ListView lstView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_listview_donut_activity);

        lstView = findViewById(R.id.idListViewDonut);
        listDonuts = new ArrayList<>();

        listDonuts.add(new Donut(1, "Tasty Donut", "Spicy tasty donut family", 10));
        listDonuts.add(new Donut(2, "Pink Donut", "Spicy tasty donut family", 20));
        listDonuts.add(new Donut(3, "Floating Donut", "Spicy tasty donut family", 30));
        listDonuts.add(new Donut(4, "Red Donut", "Spicy tasty donut family", 40));

        DonutAdapter adapter = new DonutAdapter(this, R.layout.item_donut_activity, listDonuts);
        lstView.setAdapter(adapter);
    }
}
