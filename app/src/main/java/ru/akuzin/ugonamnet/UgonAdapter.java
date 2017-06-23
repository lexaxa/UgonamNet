package ru.akuzin.ugonamnet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class UgonAdapter extends RecyclerView.Adapter<UgonHolder> {

    private static final String LOG_TAG = UgonAdapter.class.getSimpleName();
    private List<CloneFactory.Ugon> ugons;

    UgonAdapter(List<CloneFactory.Ugon> ugonList) {
        ugons = ugonList;
    }

    @Override
    public UgonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = li.inflate(R.layout.list_item_ugon, parent, false);
        return new UgonHolder(view, new UgonHolder.IUgonViewHolderClicks(){
            @Override
            public void onClick(View itemView) {
                Log.d(LOG_TAG, "Clicked " + ((TextView)itemView.findViewById(R.id.date)).getText());
            }
        });
    }

    @Override
    public void onBindViewHolder(UgonHolder holder, final int position) {
        CloneFactory.Ugon ugon = ugons.get(position);
        holder.bindCrime(ugon);

       /* holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG, "Clicked onBindViewHolder " + position + "=");
                onUgonClickListener.OnUgonClicked(v, position);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return ugons.size();
    }
}
