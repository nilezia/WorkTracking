package acth.pnru.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



import java.util.List;

import acth.pnru.worktracking.R;

public class NavigationAdapter extends BaseAdapter {

    private final Context mcontext;

    public int mMapsCounter = 0;
    public int mDownloadsCounter = 0;
    private List<NavigationItemAdapter> mList;

    public NavigationAdapter(Context context, List<NavigationItemAdapter> list) {
        this.mList = list;
        this.mcontext = context;
    }

    public void setmList(List<NavigationItemAdapter> mList) {
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public NavigationItemAdapter getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).isHeader ? 0 : 1;
    }

    @Override
    public boolean isEnabled(int position) {
        return !getItem(position).isHeader;
    }

    public void setChecked(int pos, boolean checked) {
        mList.get(pos).checked = checked;
        notifyDataSetChanged();
    }

    public void resetarCheck() {
        for (int i = 0; i < mList.size(); i++) {
            mList.get(i).checked = false;
        }
        this.notifyDataSetChanged();
    }


    public void setDownloadsCounter(int count) {
        mDownloadsCounter = count;
        //mList.get(Constant.MENU_NEWJOB).counter = mDownloadsCounter;
        notifyDataSetChanged();
    }

    public void setMapsCounter(int count) {
        mMapsCounter = count;
       // mList.get(Constant.MENU_NEWJOB).counter = mMapsCounter;
        notifyDataSetChanged();
    }

    class ViewHolder {
        public TextView title;
        public TextView counter;
        public ImageView icon;
        public LinearLayout colorLinear;
        public View viewNavigation;

        public ViewHolder() {
        }
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        NavigationItemAdapter item = mList.get(position);
        ViewHolder holder = null;

        if (convertView == null) {
            holder = new ViewHolder();

            int layout = R.layout.navigation_item_counter;


            convertView = LayoutInflater.from(mcontext).inflate(layout, null);

            holder.title = (TextView) convertView.findViewById(R.id.title);

            holder.icon = (ImageView) convertView.findViewById(R.id.icon);
            holder.viewNavigation = (View) convertView.findViewById(R.id.viewNavigation);

            holder.colorLinear = (LinearLayout) convertView.findViewById(R.id.ns_menu_row);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (holder.title != null) {
            holder.title.setText(item.title);
        }

        if (holder.counter != null) {
            if (item.counter >= 0) {
                holder.counter.setVisibility(View.VISIBLE);
                holder.counter.setText(item.counter + "");
            } else {
                holder.counter.setVisibility(View.GONE);
            }

            if (position == 3 || position == 4 || position == 5 || position == 6 || position == 7) {
               // holder.counter.setBackgroundColor(this.mcontext.getResources().getColor(R.color.transparent));
               // holder.counter.setTextColor(this.mcontext.getResources().getColor(R.color.navigation_items));
            } else {
               // holder.counter.setBackgroundColor(this.mcontext.getResources().getColor(R.color.Teal));
               // holder.counter.setTextColor(this.mcontext.getResources().getColor(R.color.white));
            }
        }

        if (holder.icon != null) {
            if (item.icon != 0) {
                holder.icon.setVisibility(View.VISIBLE);
                holder.icon.setImageResource(item.icon);
            } else {
                holder.icon.setVisibility(View.GONE);
            }
        }

        if (!item.isHeader) {
            if (item.checked) {
                holder.viewNavigation.setVisibility(View.GONE);
               // holder.colorLinear.setBackgroundColor(this.mcontext.getResources().getColor(R.color.select_navdraw));

            } else {
                holder.viewNavigation.setVisibility(View.GONE);
               // holder.colorLinear.setBackgroundColor(this.mcontext.getResources().getColor(R.color.transparent));

            }
        }

        return convertView;
    }

}
