package miha.buildprice;

import android.annotation.SuppressLint;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;

class RecycleCustomAdapter extends RecyclerView.Adapter<RecycleCustomAdapter.ViewHolder> {


     private String[]titles;
     private Listener listener;
     private Context context;
     private static final int [] colors = {R.color.c1,R.color.c2,R.color.c3,R.color.c4,
                                         R.color.c5,R.color.c6,R.color.c7,R.color.c8,
                                         R.color.c9,R.color.c10,R.color.c11,R.color.c12};

    public RecycleCustomAdapter( String[]titles)
    {
      this.titles = titles;
    }

     @NonNull
     @Override
     public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView card = (CardView)LayoutInflater.from(parent.getContext()).inflate(R.layout.card_estimate_item,parent,false);
        context = parent.getContext();
         return new ViewHolder(card);
     }

     @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
     @SuppressLint("ResourceAsColor")
     @Override
     public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
         TextView title_text = cardView.findViewById(R.id.card_title);
         title_text.setText(titles[position]);
         TextView textLogo = cardView.findViewById(R.id.card_logo);
         StringBuilder sb = new StringBuilder();
         sb.append(titles[position].charAt(0));
         textLogo.setText(sb.toString().toUpperCase());

         Drawable circle = null;

         Resources resources = context.getResources();
         try{
                circle = Drawable.createFromXml(resources,resources.getXml(R.xml.circle_xml));
         }catch (Exception e){
             Log.e("Error","Exeption loading drawable");
         }

         if(circle!=null)
         {
             Drawable dWrap = DrawableCompat.wrap(circle).mutate();
             DrawableCompat.setTint(dWrap, ContextCompat.getColor(context,getRandColor()));
             textLogo.setBackground(circle);
         }

         else
             textLogo.setBackgroundResource(R.drawable.circle_drawable);

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

     private int getRandColor() {
        int rand= new Random().nextInt(colors.length);
        return colors[rand];

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
