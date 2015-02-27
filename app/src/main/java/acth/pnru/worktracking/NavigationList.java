package acth.pnru.worktracking;

import android.content.Context;
import android.util.SparseIntArray;


import java.util.ArrayList;
import java.util.List;

import acth.pnru.Utils.Utils;
import acth.pnru.adapter.NavigationItemAdapter;

public class NavigationList {

    public static List<NavigationItemAdapter> getNavigationAdapter(
            Context context, List<Integer> listItensHeader, SparseIntArray sparce, List<Integer> listItensHide) {

        List<NavigationItemAdapter> mList = new ArrayList<NavigationItemAdapter>();


        boolean isheader = false;
        boolean isVisible = false;

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Add Task");
        arrayList.add("View My Task");
        arrayList.add("View My Team Task");
        arrayList.add("View Report");
        arrayList.add("Setting");
        arrayList.add("Logout");
        arrayList.add("Addmin");


        for (int i = 0; i < arrayList.size(); i++) {
            int count = -1;
            String title = arrayList.get(i).toString();
            NavigationItemAdapter itemNavigation;

            if (sparce != null) {
                count = sparce.get(i, -1);
            }


            if (listItensHeader != null) {
                isheader = listItensHeader.contains(i);
            }

            if (listItensHide != null) {
                isVisible = listItensHide.contains(i);
            }

            itemNavigation = new NavigationItemAdapter(title, Utils.iconNavigation[i], isheader, count, !isVisible);
            mList.add(itemNavigation);
        }

        return mList;
    }
}
