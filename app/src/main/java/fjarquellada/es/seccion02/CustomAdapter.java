package fjarquellada.es.seccion02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String>names;

    public CustomAdapter(Context context, int layout, List<String>names){
        this.context = context;
        this.layout = layout;
        this.names = names;
    }

    @Override
    public int getCount() {
        return this.names.size();
    }

    @Override
    public Object getItem(int position) {
        return this.names.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = null;

        /* VIEW HOLDER PATTERN */
        ViewHolder holder = null;
        if(convertView == null){
            holder = new ViewHolder();
            inflater = LayoutInflater.from(this.context);
            convertView = inflater.inflate(this.layout, null);
            convertView.setTag(holder);
            holder.textViewItemName = convertView.findViewById(R.id.textViewItemName);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        String currentName = this.names.get(position);

        holder.textViewItemName.setText(currentName);

        return convertView;
    }
    private static class ViewHolder{
        private TextView textViewItemName;
    }
}
