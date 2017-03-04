package com.neonidapps.fuityworld.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.neonidapps.fuityworld.R;
import com.neonidapps.fuityworld.adapters.FruitsAdapter;
import com.neonidapps.fuityworld.models.Fruta;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listViewFruits;
    private GridView gridViewFruits;
    private List<Fruta> frutas;

    private FruitsAdapter listViewfruitsAdapter;
    private FruitsAdapter gridViewFruitsAdapter;

    private int contador = 0;

    private final int LIST_VIEW = 0;
    private final int GRID_VIEW = 1;

    private int vistaActiva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setIcon(R.mipmap.ic_customlauncher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        this.vistaActiva = LIST_VIEW;

        this.frutas = new ArrayList<>();

        this.frutas.add(new Fruta("Platano", "Canarias", R.mipmap.ic_banana));
        this.frutas.add(new Fruta("Fresa", "Huelva", R.mipmap.ic_strawberry));
        this.frutas.add(new Fruta("Orange", "Sevilla", R.mipmap.ic_orange));
        this.frutas.add(new Fruta("Apple", "Madrid", R.mipmap.ic_apple));
        this.frutas.add(new Fruta("Cherry", "Galicia", R.mipmap.ic_cherry));
        this.frutas.add(new Fruta("Pera", "Zaragoza", R.mipmap.ic_pear));
        this.frutas.add(new Fruta("Uvas", "Barcelona", R.mipmap.ic_raspberry));


        this.listViewFruits = (ListView) findViewById(R.id.listViewFruits);
        this.gridViewFruits = (GridView) findViewById(R.id.gridViewFruits);

        this.listViewfruitsAdapter = new FruitsAdapter(this, R.layout.item_list_fruits, frutas);
        this.gridViewFruitsAdapter = new FruitsAdapter(this, R.layout.item_grid_fruits, frutas);

        this.listViewFruits.setAdapter(this.listViewfruitsAdapter);
        this.gridViewFruits.setAdapter(this.gridViewFruitsAdapter);


        AdapterView.OnItemClickListener adapterViewClick = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "La fruta seleccionada es: " + frutas.get(position).getName() + ", cuyo origen es: " + frutas.get(position).getOrigin(), Toast.LENGTH_SHORT).show();

            }
        };

        listViewFruits.setOnItemClickListener(adapterViewClick);
        gridViewFruits.setOnItemClickListener(adapterViewClick);

        registerForContextMenu(listViewFruits);
        registerForContextMenu(gridViewFruits);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.action_bar_menu, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menuOptionAddItem:
                this.frutas.add(new Fruta("added fruit nº " + (++contador), "unknow", R.mipmap.ic_newfruit));
                this.listViewfruitsAdapter.notifyDataSetChanged();
                this.gridViewFruitsAdapter.notifyDataSetChanged();
                return true;

            case R.id.menuOptionChangeView:
                if (vistaActiva == LIST_VIEW) {
                    this.listViewFruits.setVisibility(View.INVISIBLE);
                    this.gridViewFruits.setVisibility(View.VISIBLE);
                    this.vistaActiva = GRID_VIEW;
                    item.setIcon(android.R.drawable.ic_menu_sort_by_size);
                } else {
                    this.listViewFruits.setVisibility(View.VISIBLE);
                    this.gridViewFruits.setVisibility(View.INVISIBLE);
                    this.vistaActiva = LIST_VIEW;
                    item.setIcon(android.R.drawable.ic_dialog_dialer);
                }
            default:
                return super.onOptionsItemSelected(item);
        }

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.item_context_menu, menu);

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

        menu.setHeaderIcon(frutas.get(info.position).getRefIcon());
        menu.setHeaderTitle(frutas.get(info.position).getName());

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {

            case R.id.contextMenuOptionDeleteItem:
                this.frutas.remove(info.position);
                this.listViewfruitsAdapter.notifyDataSetChanged();
                this.gridViewFruitsAdapter.notifyDataSetChanged();

            default:
                return super.onContextItemSelected(item);
        }

    }

}
