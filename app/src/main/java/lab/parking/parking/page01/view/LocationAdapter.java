package lab.parking.parking.page01.view;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lab.parking.parking.R;
import lab.parking.parking.page01.model.Location;

public class LocationAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<Location> mDataSource;

    public LocationAdapter(Context context, List<Location> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.location_item, parent, false);
            holder = new ViewHolder();
            holder.locationNameTextView = (TextView) convertView.findViewById(R.id.location_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Location location = (Location) getItem(position);
        holder.locationNameTextView.setText(location.getName());

        return convertView;
    }

    private static class ViewHolder {
        public TextView locationNameTextView;
    }
}
