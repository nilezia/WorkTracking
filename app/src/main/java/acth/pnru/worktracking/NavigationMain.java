
package acth.pnru.worktracking;

import android.app.Activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import acth.pnru.Utils.Constant;
import acth.pnru.Utils.Utils;
import acth.pnru.adapter.NavigationAdapter;

public class NavigationMain extends ActionBarActivity {

    private int mLastPosition = 0;
    private ListView mListDrawer;

    private DrawerLayout mLayoutDrawer;
    private RelativeLayout mUserDrawer;
    private RelativeLayout mRelativeDrawer;
    private Toolbar toolbar;
    private FragmentManager mFragmentManager;

    private ActionBarDrawerToggleCompat mDrawerToggle;
    private TextView txt_user_lastname_drawer;

    private NavigationAdapter mNavigationAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.navigation_main);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        mListDrawer = (ListView) findViewById(R.id.listDrawer);
        mRelativeDrawer = (RelativeLayout) findViewById(R.id.relativeDrawer);
        mLayoutDrawer = (DrawerLayout) findViewById(R.id.layoutDrawer);
        txt_user_lastname_drawer = (TextView) findViewById(R.id.txt_user_lastname_drawer);

        mUserDrawer = (RelativeLayout) findViewById(R.id.userDrawer);
        mUserDrawer.setOnClickListener(userOnClick);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (mListDrawer != null) {
            // All menus which will contain an accountant should be informed here
            // Counter.put ("POSITION MENU", "VALUE COUNTER");

            mNavigationAdapter = new NavigationAdapter(this, NavigationList.getNavigationAdapter(this, getHeader(), null, null));
        }

        mListDrawer.setAdapter(mNavigationAdapter);
        mListDrawer.setOnItemClickListener(new DrawerItemClickListener());

        mDrawerToggle = new ActionBarDrawerToggleCompat(this, mLayoutDrawer);
        mLayoutDrawer.setDrawerListener(mDrawerToggle);

        if (savedInstanceState != null) {
            setLastPosition(savedInstanceState.getInt(Constant.LAST_POSITION));

            setTitleFragments(mLastPosition);
            mNavigationAdapter.resetarCheck();
            mNavigationAdapter.setChecked(mLastPosition, true);
        } else {
            setFragmentList(mLastPosition);
        }
    }

    private List<Integer> getHeader() {
        // All header menus should be informed here
        // listHeader.add(MENU POSITION)
        List<Integer> mListHeader = new ArrayList<Integer>();
        mListHeader.add(7);

        return mListHeader;
    }

    public void setFragmentList(int posicao) {

        mFragmentManager = getSupportFragmentManager();
        Fragment mFragment = null;
        switch (posicao) {

        }

        if (mFragment != null) {
            setTitleFragments(posicao);
            setLastPosition(posicao);
            mNavigationAdapter.resetarCheck();
            mNavigationAdapter.setChecked(posicao, true);
            mFragmentManager.beginTransaction().replace(R.id.content_frame, mFragment).commit();
        }

    }


    private void setTitleFragments(int position) {
        getSupportActionBar().setIcon(Utils.iconNavigation[position]);
        //setTitleActionBar(Utils.getTitleItem(NavigationMain.this, position));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // TODO Auto-generated method stub
        super.onSaveInstanceState(outState);
        outState.putInt(Constant.LAST_POSITION, mLastPosition);
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case 1:
                if (mLayoutDrawer.isDrawerOpen(mRelativeDrawer)) {
                    mLayoutDrawer.closeDrawer(mRelativeDrawer);
                } else {
                    mLayoutDrawer.openDrawer(mRelativeDrawer);
                }
                return true;
            default:

                if (mDrawerToggle.onOptionsItemSelected(item)) {
                    return true;
                }

                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        //hideMenus(menu, mLastPosition);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    private static long back_pressed;

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()) super.onBackPressed();
        else
            Toast.makeText(getBaseContext(), "Press once again to exit!", Toast.LENGTH_SHORT).show();
        mLayoutDrawer.closeDrawer(mRelativeDrawer);
        back_pressed = System.currentTimeMillis();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    public void setTitleActionBar(CharSequence informacao) {
        getSupportActionBar().setTitle(informacao);
    }

    public void setLastPosition(int posicao) {
        this.mLastPosition = posicao;
    }

    private class ActionBarDrawerToggleCompat extends ActionBarDrawerToggle {

        public ActionBarDrawerToggleCompat(Activity mActivity, DrawerLayout mDrawerLayout) {
            super(
                    mActivity,
                    mDrawerLayout,
                    R.drawable.ic_drawer,
                    R.string.navigation_drawer_open,
                    R.string.navigation_drawer_close);
        }

        @Override
        public void onDrawerClosed(View view) {
            supportInvalidateOptionsMenu();
        }

        @Override
        public void onDrawerOpened(View drawerView) {
            mNavigationAdapter.notifyDataSetChanged();

            supportInvalidateOptionsMenu();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // TODO Auto-generated method stub
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int posicao, long id) {
            setFragmentList(posicao);
            mLayoutDrawer.closeDrawer(mRelativeDrawer);
        }
    }

    private OnClickListener userOnClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            mLayoutDrawer.closeDrawer(mRelativeDrawer);
        }
    };


}
