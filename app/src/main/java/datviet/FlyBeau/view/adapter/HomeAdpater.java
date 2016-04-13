package datviet.FlyBeau.view.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import datviet.FlyBeau.R;
import datviet.FlyBeau.model.Home;
import datviet.FlyBeau.utils.lazylist.BitmapBorderTransformation;
import datviet.FlyBeau.utils.lazylist.ImageLoader;

/**
 * Created by NamNgo on 12/04/2016.
 */
public class HomeAdpater extends BaseAdapter {

    Context context;
    private String[] data;
    private static LayoutInflater inflater = null;

    public datviet.FlyBeau.utils.lazylist.ImageLoader imageLoader;
    ArrayList<Home> lstHome;

    public HomeAdpater(Context context, ArrayList<Home> lstHome) {
        //activity = a;
        this.context = context;
        this.lstHome = lstHome;
        imageLoader = new ImageLoader(this.context.getApplicationContext());
    }

    class Holder {
        ImageView iv, avatar;
        TextView tvGroupName;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return lstHome.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder;
        if (convertView == null) {
            holder = new Holder();
            inflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.home_item, null);
            holder.iv = (ImageView) convertView.findViewById(R.id.imgHome);
            holder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            holder.tvGroupName = (TextView) convertView.findViewById(R.id.tvGroupName);
            convertView.setTag(holder);

        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.tvGroupName.setText(lstHome.get(position).name);
//        Picasso.with(context)
//                .load(lstHome.get(position).avatarSRC)
//                .transform(new RoundedTransformation(100, 0))
//                .fit().centerCrop()
//                .into(holder.avatar);
        Picasso.with(context)
                .load(lstHome.get(position).avatarSRC)
                .transform(new BitmapBorderTransformation(0, 100, Color.BLUE))
                .fit().centerCrop()
                .into(holder.avatar);
        //imageLoader.DisplayImage(lstVideo.get(position).url, holder.iv);
        holder.iv.setImageResource(lstHome.get(position).imageSRC);
        return convertView;
    }


}