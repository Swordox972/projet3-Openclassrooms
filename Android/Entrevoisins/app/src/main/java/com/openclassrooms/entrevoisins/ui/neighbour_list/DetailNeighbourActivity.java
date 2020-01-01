package com.openclassrooms.entrevoisins.ui.neighbour_list;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;



public class DetailNeighbourActivity extends AppCompatActivity {
    Neighbour mNeighbour;
    FloatingActionButton favoriteFab;
    NeighbourApiService mApiService;
    static boolean active;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_neighbour);

        mApiService = DI.getNeighbourApiService();

        //On récupère le neighbour passé en putExtra ici
        mNeighbour = (Neighbour) getIntent().getSerializableExtra("Neighbour");

        ImageView mAvatarVoisin = findViewById(R.id.avatar_voisin);
        Glide.with(this).load(mNeighbour.getAvatarUrl()).into(mAvatarVoisin);


        TextView mNomVoisin = findViewById(R.id.nom_voisin);
        mNomVoisin.setText(mNeighbour.getName());


        TextView mCardViewNom = findViewById(R.id.card_view_nom);
        mCardViewNom.setText(mNeighbour.getName());

        TextView mNumeroVoisin;
        mNumeroVoisin = findViewById(R.id.numero_voisin);
        mNumeroVoisin.setText(mNeighbour.getNumeroVoisin());

        TextView mFacebookNom;
        mFacebookNom = findViewById(R.id.nom_voisin_facebook);
        mFacebookNom.setText("www.facebook.fr/" + mNeighbour.getName().toLowerCase());

        TextView mAProposDeMoi = findViewById(R.id.a_propos_neighbour);
        mAProposDeMoi.setText(mNeighbour.getAProposDeMoi());

        Toolbar mAvatarToolbar = findViewById(R.id.avatar_toolbar);
        setSupportActionBar(mAvatarToolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        favoriteFab = findViewById(R.id.fab_avatar_favorite);
        favoriteFab.setOnClickListener(favoriteButton);
        this.showStar(mNeighbour);

    }

    View.OnClickListener favoriteButton = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            mApiService.verifyNeighbourFavorite(mNeighbour);

            if (mApiService.verifyNeighbourFavorite(mNeighbour) == false) {
                mApiService.addFavoriteNeighbour(mNeighbour);
                showToastAddFavoriteOnClick();
            } else {
                mApiService.deleteFavoriteNeighbour(mNeighbour);
                showToastDeleteFavoriteOnClick();
            }
            showStar(mNeighbour);
        }
    };

    private void showStar(Neighbour neighbour) {

        if (mApiService.verifyNeighbourFavorite(neighbour) == false) {
            favoriteFab.setImageDrawable(getDrawable(R.drawable.ic_star_border_white_24dp));
        } else {
            favoriteFab.setImageDrawable(getDrawable(R.drawable.ic_star_white_24dp));
        }
    }

   private void showToastAddFavoriteOnClick() {
        LayoutInflater layoutInflater = getLayoutInflater();
        View layout = layoutInflater.inflate(R.layout.custom_toast, findViewById(R.id.custom_toast_container));

        TextView toastText = layout.findViewById(R.id.toast_text);
        toastText.setText("Utilisateur ajouté aux favoris");

        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    private void showToastDeleteFavoriteOnClick() {
        LayoutInflater layoutInflater = getLayoutInflater();
        View layout = layoutInflater.inflate(R.layout.custom_toast, findViewById(R.id.custom_toast_container));

        TextView toastText = layout.findViewById(R.id.toast_text);
        toastText.setText("Utilisateur supprimé des favoris");

        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    @Override
    public void onStop() {
        super.onStop();
     active=false;
    }
}
