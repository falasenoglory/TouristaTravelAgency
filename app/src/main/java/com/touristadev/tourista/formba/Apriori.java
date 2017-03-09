package com.touristadev.tourista.formba;

import com.touristadev.tourista.dataModels.Spots;
import com.touristadev.tourista.dataModels.TouristaPackages;

import java.util.ArrayList;

/**
 * Created by Shanyl Jimenez on 3/7/2017.
 */

public class Apriori {


    private ArrayList<Spots> spotList= new ArrayList<>();
    private ArrayList<TouristaPackages> transactionList= new ArrayList<>();
    private TouristaPackages basePackage= new TouristaPackages();

    public static Apriori instance;
    private ArrayList<ArrayList<Integer>> mTransaction = new ArrayList();
    private int mMinSup = 2;
    private int mMinConf;

    ItemList itemList = new ItemList();



    public ArrayList<TouristaPackages>getRecommendedPackages(TouristaPackages pg) {
        ArrayList<TouristaPackages> recommendedPackages= new ArrayList<>();

        this.basePackage=pg;
        // this.spotList= get all spotlist here;
        // this.transactionList= get all transactionlist;
        instance = new Apriori();
        instance.initializeValues();
        instance.executeApriori();


        return recommendedPackages;
    }

    /*
        1 - Badian
        2 - Alcantara
        3 - Moal Boal
        4 - Oslob
        5 - Naga
        6 - Carcar
     */

    private void initializeValues() {

        ArrayList<Integer> item= new ArrayList<>();
        for(int i=0;i<transactionList.size();i++ ) // for getting the current transaction
        {
            for (int k=0;k<transactionList.get(i).getPackageItinerary().size();k++) // getting the current itinerary
            {
                for (int j = 0; j < spotList.size(); j++) {

                    if(transactionList.get(i).getPackageItinerary().get(k).getSpotName().equals(spotList.get(j).getSpotName()))
                    {
                        item.add(j);
                    }
                }
            }
            mTransaction.add(item);
        }
//        int[] item1 = {1, 2};
//        int[] item2 = {1, 3, 4, 5};
//        int[] item3 = {2, 3, 4, 6};
//        int[] item4 = {1, 2, 3, 4};
//        int[] item5 = {1, 2, 3, 6};
//
//        mTransaction.add(item1);
//        mTransaction.add(item2);
//        mTransaction.add(item3);
//        mTransaction.add(item4);
//        mTransaction.add(item5);

        printArray(mTransaction);
    }

    public void executeApriori() {
        ArrayList<ItemList> first = generateCandidateFromTransaction();
        System.out.println("\nFirst State");
        printItemList(first);
        while(true) {
            ArrayList<ItemList> second = generateCandidateFromList(first);
            ArrayList<ItemList> second_2 = generateNextListFromCandidate(second);
            System.out.println("\nAfter Generate Second");
            printItemList(second_2);
            if (second_2.size() <= 1) {
                System.out.println("\n\ndone");
                break;
            }
            first = second_2;
        }
    }

    private int countAppearance(ArrayList<ArrayList<Integer>> set, ArrayList<Integer> target) {
        int ret = 0;
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i)== target) {
                ret++;
            }
        }
        return ret;
    }

    public boolean contain(ArrayList<Integer> source, ArrayList<Integer> find) {
        boolean ret = false;
        int match = 0;
        for (int i = 0; i < find.size(); i++) {
            for (int j = 0; j < source.size(); j++) {
                if (source.get(j) == find.get(i)) {
                    match++;
                }
            }
        }
        if(match == find.size()) {
            ret = true;
        }
        return ret;
    }

    private ArrayList<ItemList> generateCandidateFromTransaction() {
        ArrayList<ItemList> ret = new ArrayList<ItemList>();
        ArrayList<Integer> items = new ArrayList<Integer>();
        for (int i = 0; i < mTransaction.size(); i++) {
            ArrayList<Integer> temp_items = mTransaction.get(i);
            for (int j = 0; j < temp_items.size(); j++) {
                Integer data = new Integer(temp_items.get(j));
                if (!items.contains(data)) {
                    items.add(data);
                }
            }
        }
        for (int ii = 0; ii < items.size(); ii++) {
            ArrayList<Integer> temp= new ArrayList<>();
            temp.add(items.get(ii));
            ret.add(new ItemList(1, temp, countAppearance(mTransaction, temp)));
        }
        return ret;
    }

    private ArrayList<ItemList> generateCandidateFromList(ArrayList<ItemList> list) {
        ArrayList<ItemList> candidate = new ArrayList<ItemList>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSupport() >= mMinSup) {
                if (!list.get(i).isAlreadyExist(candidate)) {
                    candidate.add(list.get(i));
                }
            }
        }
        return candidate;
    }

    private ArrayList<ItemList> generateNextListFromCandidate(ArrayList<ItemList> candidate) {
        ArrayList<ItemList> list = new ArrayList<ItemList>();
        for (int i = 0; i < candidate.size(); i++) {
            for (int j = i; j < candidate.size(); j++) {
                System.out.println("\ngenerateNextListFromCandidate");
                printItemList(candidate);
                if (distance(candidate.get(i), candidate.get(j)) == 1) {
                    System.out.println("i:" + i + ", j:" + j);
                    candidate.get(i).print();
                    candidate.get(j).print();

                    ArrayList<Integer> items = pickItems(candidate.get(i), candidate.get(j));
                    ItemList temp = new ItemList(candidate.get(0).getCount() + 1, items, countAppearance(mTransaction, items));
                    temp.print();
                    list.add(temp);
                }
            }
        }
        return list;
    }

    private int distance(ItemList one, ItemList another) {
        int ret = one.getCount();
        for (int i = 0; i < one.getCount(); i++) {
            for (int j = 0; j < another.getCount(); j++) {
                if (one.getItem(i) == another.getItem(j)) {
                    ret--;
                }
            }
        }
        return ret;
    }

    private ArrayList<Integer> pickItems(ItemList one, ItemList another) {
        ArrayList<Integer> shan= new ArrayList<>();
        int[] ret = new int[one.getCount() + 1];
        int i = 0;
        int j = 0;
        int index = 0;
        //System.out.println("pickItems");
        one.print();
        another.print();
        while((i < one.getCount()) || (j < another.getCount())) {
            if (one.getCount() == i) {
                System.out.println("1");
                ret[index++] = another.getItem(j);
                j++;
            } else if (another.getCount() == j) {
                System.out.println("2");
                ret[index++] = one.getItem(i);
                i++;
            } else if (one.getItem(i) < another.getItem(j)) {
                System.out.println("3");
                ret[index++] = one.getItem(i);
                i++;
            } else if (one.getItem(i) > another.getItem(j)) {
                System.out.println("4");
                ret[index++] = another.getItem(j);
                j++;
            } else {
                System.out.println("5");
                ret[index++] = one.getItem(i);
                i++;
                j++;
            }
        }

        for (int s=0;s<ret.length;s++)
        {
            shan.add(ret[s]);
        }
        return shan;
    }

    private void printArray(ArrayList<ArrayList<Integer>> array) {
        for (int i = 0; i < array.size(); i++) {
            String out = "";
            ArrayList<Integer> buf = array.get(i);
            for (int j = 0; j < buf.size(); j++) {
                out += buf.get(j) + ", ";
            }
            System.out.println("transactionId : " + i + " - items : " + out);
        }
    }

    private void printItemList(ArrayList<ItemList> list) {
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> items = list.get(i).getItems();
            System.out.print("ID : " + i + " - Items : ");
            for (int j = 0; j < items.size(); j++) {
                System.out.print(items.get(j) + ", ");
            }
            System.out.println("MinSupport : " + list.get(i).getSupport());
        }
    }

}
