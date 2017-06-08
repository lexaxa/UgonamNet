package ru.akuzin.ugonamnet;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import ru.akuzin.ugonamnet.CloneFactory.*;

class UgonHolder extends RecyclerView.ViewHolder{

    private TextView dateTextView;
    private TextView titleTextView;
    private TextView numberTextView;
    private TextView colorTextView;
    private TextView addressTextView;
    private TextView awardTextView;
    private TextView descTextView;
    private CloneFactory.Ugon ugon;

    public UgonHolder(View itemView) {
        super(itemView);
        dateTextView = (TextView) itemView.findViewById(R.id.date);
        titleTextView = (TextView) itemView.findViewById(R.id.title);
        numberTextView = (TextView) itemView.findViewById(R.id.number);
        colorTextView = (TextView) itemView.findViewById(R.id.color);
        addressTextView = (TextView) itemView.findViewById(R.id.address);
        awardTextView = (TextView) itemView.findViewById(R.id.award);
        descTextView = (TextView) itemView.findViewById(R.id.desc);
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
}
