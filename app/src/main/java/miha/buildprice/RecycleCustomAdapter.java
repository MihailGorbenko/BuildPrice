package miha.buildprice;

import android.app.LauncherActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

 class RecycleCustomAdapter extends RecyclerView.Adapter<RecycleCustomAdapter.ViewHolder> {


     private String[]titles;
     private Listener listener;

    public RecycleCustomAdapter( String[]titles)
    {
      this.titles = titles;
    }

     @NonNull
     @Override
     public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView card = (CardView)LayoutInflater.from(parent.getContext()).inflate(R.layout.card_estimate_item,parent,false);
         return new ViewHolder(card);
     }

     @Override
     public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
         TextView title_text = (TextView)cardView.findViewById(R.id.card_title);
         title_text.setText(titles[position]);
         TextView textLogo = cardView.findViewById(R.id.card_logo);
         StringBuilder sb = new StringBuilder();
         sb.append(titles[position].charAt(0));
         textLogo.setText(sb.toString().toUpperCase());

         cardView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(listener!=null)
                 {
                     listener.onClick(position);
                 }
             }
         });

     }

     @Override
     public int getItemCount() {
         return titles.length;
     }

     public class ViewHolder extends RecyclerView.ViewHolder
    {
        private CardView cardView;
        public ViewHolder(CardView cv)
        {
            super(cv);
            cardView = cv;
        }
    }

    public interface Listener
    {
        void onClick(int position);
    }
}
