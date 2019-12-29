package com.openclassrooms.entrevoisins.service;

import android.util.EventLog;
import android.view.View;

import com.openclassrooms.entrevoisins.events.OpenNeighbourEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;

import org.greenrobot.eventbus.EventBus;


public class Presenter {
    private View view;
    private Neighbour mNeighbour;
    ListNeighbourActivity mActivity= new ListNeighbourActivity();

    public Presenter(View view) {
        this.view=view;
    }

    public void onItemSelected(Neighbour neighbour) {
        itemSelected();
    }

    public void itemSelected() {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EventBus.getDefault().post(new OpenNeighbourEvent(mNeighbour));
            }
        });
    }

}
