package adapater;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.model.messagemodel;
import com.myqq.ui.R;

public class my_adapter extends BaseAdapter {

    private List<messagemodel> list;

    private LayoutInflater inflater;

    public my_adapter(Context context, List<messagemodel> list) {
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    public int getCount() {

        return list == null ? 0 : list.size();
    }

    public Object getItem(int arg0) {
        return list == null ? null : list.get(arg0);
    }

    public long getItemId(int arg0) {
        return arg0;
    }

    public View getView(int prvie, View view, ViewGroup arg2) {
        viewholder holder = null;
        if (view == null) {
            holder = new viewholder();

            view = inflater.inflate(R.layout.insert_activity, null);
            holder.portait = (ImageView) view.findViewById(R.id.iv_1);
            holder.logo = (ImageView) view.findViewById(R.id.iv_2);
            holder.tittle = (TextView) view.findViewById(R.id.tv);
            holder.shadow = (TextView) view.findViewById(R.id.top_h);
            holder.shadows = (ImageView) view.findViewById(R.id.iv_3);
            view.setTag(holder);
        } else {
            holder = (viewholder) view.getTag();
        }
        messagemodel m = list.get(prvie);
        holder.portait.setImageResource(m.getPortait());
        holder.logo.setImageResource(m.getLogo());
        holder.tittle.setText(m.getTittle());
        int a = View.VISIBLE;
        int b = View.INVISIBLE;
        Log.i("my_adapter", "a=" + a + ",b=" + b);
        Log.i("my_adapter", "prvie=" + prvie);
        Log.i("my_adapter", "visibility=" + holder.shadow.getVisibility());
        holder.shadow.setVisibility(m.isShadow() ? View.VISIBLE : View.GONE);
        holder.shadows.setVisibility(m.isShadows() ? View.VISIBLE : View.GONE);
        return view;
    }

    class viewholder {
        ImageView portait, logo, shadows;

        TextView tittle, shadow;
    }
}
