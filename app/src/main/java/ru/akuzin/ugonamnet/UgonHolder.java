package ru.akuzin.ugonamnet;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import ru.akuzin.ugonamnet.CloneFactory.*;

class UgonHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private static final String LOG_TAG = UgonHolder.class.getSimpleName();
    private TextView dateTextView;
    private TextView titleTextView;
    private TextView numberTextView;
    private TextView colorTextView;
    private TextView addressTextView;
    private TextView awardTextView;
    private TextView descTextView;
    private CloneFactory.Ugon ugon;

    public IUgonViewHolderClicks listener;

    public UgonHolder(View itemView, IUgonViewHolderClicks listener) {
        super(itemView);
        this.listener = listener;
        dateTextView = (TextView) itemView.findViewById(R.id.date);
        titleTextView = (TextView) itemView.findViewById(R.id.title);
        numberTextView = (TextView) itemView.findViewById(R.id.number);
        colorTextView = (TextView) itemView.findViewById(R.id.color);
        addressTextView = (TextView) itemView.findViewById(R.id.address);
        awardTextView = (TextView) itemView.findViewById(R.id.award);
        descTextView = (TextView) itemView.findViewById(R.id.desc);
        Log.d(LOG_TAG, "Adding listener");
        itemView.setOnClickListener(this);
    }

    public void bindCrime(Ugon ugon){
        this.ugon = ugon;
        dateTextView.setText(ugon.getDate().toString());
        titleTextView.setText(ugon.getTitle());
        numberTextView.setText(ugon.getNumber());
        colorTextView.setText(ugon.getColor());
        addressTextView.setText(ugon.getAddress());
        awardTextView.setText(ugon.getAward());
        descTextView.setText(ugon.getDescription());
    }

    @Override
    public void onClick(View v) {
        Log.d(LOG_TAG, "Click listener");
        listener.onClick(itemView);
    }



    public interface IUgonViewHolderClicks {
        public void onClick(View itemView);
    }
}
