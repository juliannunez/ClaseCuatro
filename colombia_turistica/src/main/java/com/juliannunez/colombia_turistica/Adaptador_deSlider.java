package com.juliannunez.colombia_turistica;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Usuario on 25/03/2016.
 */
public class Adaptador_deSlider extends PagerAdapter {
    private int[] image_resources = {R.drawable.escudocopa, R.drawable.sanjuancielo, R.drawable.iglesiapri};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public Adaptador_deSlider(Context ctx){

        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view ==(LinearLayout)object) ;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.slider,container,false);
        ImageView imageview = (ImageView)item_view.findViewById(R.id.imagen_view);
        TextView textView = (TextView)item_view.findViewById(R.id.image_count);
        TextView textView2 = (TextView)item_view.findViewById(R.id.contadorcito);
        imageview.setImageResource(image_resources[position]);
        switch (position){
            case 0:
                textView.setText("Escudo");
                textView2.setText("* . .");
                break;
            case 1:
                textView.setText("Iglesia San Juan\n"+"De la Tasajera");
                textView2.setText(". * .");
                break;
            case 2:
                textView.setText("Iglesia nuestra señora\n"+"De la asunción");
                textView2.setText(". . *");
                break;
            default:
                textView.setText("Error!!!");
                break;
        }
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);

    }


}
