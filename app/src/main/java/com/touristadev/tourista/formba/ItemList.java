package com.touristadev.tourista.formba;

import java.util.ArrayList;

/**
 * Created by Shanyl Jimenez on 3/8/2017.
 */

public class ItemList {

    private int mCount;
    private ArrayList<Integer> mItems;
    private int mSup = 2;

    public ItemList() {
    }

    public ItemList(int c, ArrayList<Integer> i, int s) {
        mCount = c;
        mItems = i;
        mSup = s;
    }
    public int getSupport() {
        return mSup;
    }
    public ArrayList<Integer> getItems() {
        return mItems;
    }
    public int getItem(int index) {
        return mItems.get(index);
    }
    public int getCount() {
        return mCount;
    }
    public boolean isAlreadyExist(ArrayList<ItemList> items) {
        boolean res = false;
        for (int i = 0; i < items.size(); i++) {
            if (Apriori.instance.contain(items.get(i).getItems(), this.getItems())) {
                return true;
            }
        }
        return res;
    }

    public void print() {
        String out = "";
        for(int i = 0; i < mItems.size(); i++) {
            out += mItems.get(i) + ", ";
        }
        //System.out.println("mCount : " + mCount + ", mItems : " + out + ", mSup : " + mSup);
    }

}
