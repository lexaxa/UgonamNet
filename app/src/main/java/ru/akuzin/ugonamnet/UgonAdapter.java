package ru.akuzin.ugonamnet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

class UgonAdapter extends RecyclerView.Adapter<UgonHolder> {

    private List<CloneFactory.Ugon> ugons;

    UgonAdapter(List<CloneFactory.Ugon> ugonList) {
        ugons = ugonList;
    }

    @Override
    public UgonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = li.inflate(R.layout.list_item_ugon, parent, false);
        return new UgonHolder(view);
    }

    @Override
    public void onBindViewHolder(UgonHolder holder, int position) {
        CloneFactory.Ugon ugon = ugons.get(position);
        holder.bindCrime(ugon);
    }

    @Override
    public int getItemCount() {
        return ugons.size();
    }
}
