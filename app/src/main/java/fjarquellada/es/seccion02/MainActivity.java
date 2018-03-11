package fjarquellada.es.seccion02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listView = findViewById(R.id.listView);

        /* Datso a mostrar */
        final List<String>names = new LinkedList<String>(){{
            add("Francisco José");
            add("Inma");
            add("Judith");
            add("María");
            add("Teresa");add("Francisco José");
            add("Inma");
            add("Judith");
            add("María");
            add("Teresa");add("Francisco José");
            add("Inma");
            add("Judith");
            add("María");
            add("Teresa");add("Francisco José");
            add("Inma");
            add("Judith");
            add("María");
            add("Teresa");add("Francisco José");
            add("Inma");
            add("Judith");
            add("María");
            add("Teresa");           add("Francisco José");
            add("Inma");
            add("Judith");
            add("María");
            add("Teresa");add("Francisco José");
            add("Inma");
            add("Judith");
            add("María");
            add("Teresa");add("Francisco José");
            add("Inma");
            add("Judith");
            add("María");
            add("Teresa");add("Francisco José");
            add("Inma");
            add("Judith");
            add("María");
            add("Teresa");add("Francisco José");
            add("Inma");
            add("Judith");
            add("María");
            add("Teresa");
        }};
        /* Adaptador para el list view */
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        CustomAdapter adapter = new CustomAdapter(this, R.layout.list_item_layout_fj, names);
        /* Se establece el adaptador en el listview */
        this.listView.setAdapter(adapter);

        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Clicado: "+ names.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }
}

