package stor.ens.ma.stor.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ShareCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import stor.ens.ma.stor.R;
import stor.ens.ma.stor.adapter.StarAdapter;
import stor.ens.ma.stor.service.StarService;

public class ListActivity extends AppCompatActivity {

    private StarAdapter starAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView rv = findViewById(R.id.recycle_view);
        rv.setLayoutManager(new LinearLayoutManager(this));

        // Initialisation de l'adapter avec les données du service
        starAdapter = new StarAdapter(this, StarService.getInstance().findAll());
        rv.setAdapter(starAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // On "gonfle" le menu (search + share)
        getMenuInflater().inflate(R.menu.menu, menu);

        // Récupération du SearchView
        MenuItem menuItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) menuItem.getActionView();

        // Listener de recherche
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true; // rien de spécial à la validation
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (starAdapter != null) {
                    starAdapter.getFilter().filter(newText);  // filtrage dynamique
                }
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Gestion du clic sur l'item "Partager"
        if (item.getItemId() == R.id.share) {

            String txt = "Stars";
            String mimeType = "text/plain";

            ShareCompat.IntentBuilder
                    .from(this)
                    .setType(mimeType)
                    .setChooserTitle("Partager l’application Stars")
                    .setText(txt)
                    .startChooser();
        }

        return super.onOptionsItemSelected(item);
    }
}
