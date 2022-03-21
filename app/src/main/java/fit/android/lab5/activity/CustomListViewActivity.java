package fit.android.lab5.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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

        listDonuts.add(new Donut(1, "Tasty Donut", "Spicy tasty donut family", 10, R.drawable.donut_yellow_1));
        listDonuts.add(new Donut(2, "Pink Donut", "Spicy tasty donut family", 20, R.drawable.tasty_donut_1));
        listDonuts.add(new Donut(3, "Floating Donut", "Spicy tasty donut family", 30, R.drawable.green_donut_1));
        listDonuts.add(new Donut(4, "Red Donut", "Spicy tasty donut family", 40, R.drawable.donut_red_1));

        DonutAdapter adapter = new DonutAdapter(this, R.layout.item_donut_activity, listDonuts);
        lstView.setAdapter(adapter);

        //Find Item
        EditText findInput = findViewById(R.id.editTextTextPersonName);
        findInput.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                ArrayList<Donut> listDounutFind = new ArrayList<>();
                if(keyEvent.getAction() == keyEvent.ACTION_DOWN && keyEvent.getKeyCode() == keyEvent.KEYCODE_ENTER) {
                    String dounutName = findInput.getText().toString();
                    if(dounutName.trim().equals("")) {
                        Toast.makeText(CustomListViewActivity.this, "Vui lòng nhập tên bánh để tìm", Toast.LENGTH_SHORT).show();
                        return false;
                    }else {
                        for(Donut item : listDonuts) {
                            if(item.getName().equals(dounutName)) {
                                listDounutFind.add(item);
                            }
                        }
                    }

                    DonutAdapter adapter = new DonutAdapter(CustomListViewActivity.this, R.layout.item_donut_activity, listDounutFind);
                    lstView.setAdapter(adapter);
                    return true;
                }
                return false;
            }
        });

    }
}
