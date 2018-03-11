package fjarquellada.es.seccion02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import static android.widget.AdapterView.*;

public class GridActivity extends AppCompatActivity {

    private GridView gridView;
    private List<String> names;
    private int counter = 0;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        this.gridView = findViewById(R.id.gridView);

        /* Datso a mostrar */
        this.names = new LinkedList<String>(){{
            add("Francisco José");
            add("Inma");
            add("Judith");
            add("María");
            add("Teresa");
        }};
        /* Adaptador para el grid view */
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        adapter = new CustomAdapter(this, R.layout.grid_item_layout, names);
        /* Se establece el adaptador en el listview */
        this.gridView.setAdapter(adapter);

        this.gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridActivity.this, "Clicado: "+ names.get(position), Toast.LENGTH_LONG).show();
            }
        });

        /* Se registra el componente que tiene que sacar context menu con un pulso largo */
        registerForContextMenu(this.gridView);
    }

    /* INFLAR EL MENU DE OPCIONES */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar_menu_actions, menu);
        return true;

    }

    /**
     * CAPTURA DE EVENTOS DEL MENU DE OPCIONES
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean res = true;
        switch(item.getItemId()){
            case R.id.addItem:
                this.names.add("Added nº: "+(this.counter++));
                /* Se notifica al adapter que ha habido cambios para que refresque el grid view */
                this.adapter.notifyDataSetChanged();
                res = true;
                break;
            default:
                res = super.onOptionsItemSelected(item);
        }

        return res;

    }

    /**
     * SE INFLA EL LAYOUT DEL CONTEXT MENU
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();

        AdapterContextMenuInfo info = (AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(names.get(info.position));


        inflater.inflate(R.menu.context_menu, menu);
    }

    /**
     * MANEJO DE EVENTOS DEL CONTEXT MENU
     * @param item
     * @return
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
        boolean res = true;

        switch(item.getItemId()){
            case R.id.delete_item:
                res = true;

                this.names.remove(info.position);
                this.adapter.notifyDataSetChanged();
                break;
            default:
                res = super.onContextItemSelected(item);
                break;
        }
        return res;
    }
}
