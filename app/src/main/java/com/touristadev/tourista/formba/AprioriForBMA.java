package com.touristadev.tourista.formba;

import com.touristadev.tourista.dataModels.Itinerary;
import com.touristadev.tourista.dataModels.TouristaPackages;

import java.util.ArrayList;

/**
 * Created by Shanyl Jimenez on 3/7/2017.
 */

public class AprioriForBMA {
        public static AprioriForBMA instance;
        private ArrayList<TouristaPackages> mTransaction = new ArrayList();
        private int mMinSup = 2;
        private int mMinConf;

        Item itemList = new Item();

        public static void main(String[] args) {
            instance = new AprioriForBMA();
            instance.initializeValues();
            instance.executeApriori();
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
//            int[] item1 = {1, 2};
//            int[] item2 = {1, 3, 4, 5};
//            int[] item3 = {2, 3, 4, 6};
//            int[] item4 = {1, 2, 3, 4};
//            int[] item5 = {1, 2, 3, 6};
//
//            mTransaction.add(item1);
//            mTransaction.add(item2);
//            mTransaction.add(item3);
//            mTransaction.add(item4);
//            mTransaction.add(item5);
            printArray(mTransaction);
        }

        public void executeApriori() {
            ArrayList<Item> first = generateCandidateFromTransaction();
            System.out.println("\nFirst State");
            printItemList(first);
            while(true) {
                ArrayList<Item> second = generateCandidateFromList(first);
                ArrayList<Item> second_2 = generateNextListFromCandidate(second);
                System.out.println("\nAfter Generate Second");
                printItemList(second_2);
                if (second_2.size() <= 1) {
                    System.out.println("\n\ndone");
                    break;
                }
                first = second_2;
            }
        }

        private int countAppearance(ArrayList<TouristaPackages> set, ArrayList<Itinerary> target) {
            int ret = 0;
            for (int i = 0; i < set.size(); i++) {
                if (contain(set.get(i).getPackageItinerary(), target)) {
                    ret++;
                }
            }
            return ret;
        }

        public boolean contain(ArrayList<Itinerary> source, ArrayList<Itinerary> find) {
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

        private ArrayList<Item> generateCandidateFromTransaction() {
            ArrayList<Item> ret = new ArrayList<Item>();
            ArrayList<Itinerary> items = new ArrayList<Itinerary>();
            ArrayList<Itinerary> temp= new ArrayList<>();
            for (int i = 0; i < mTransaction.size(); i++) {
                ArrayList<Itinerary> temp_items = mTransaction.get(i).getPackageItinerary();
                for (int j = 0; j < temp_items.size(); j++) {
                    Itinerary data = temp_items.get(j);
                    if (!items.contains(data)) {
                        items.add(data);
                    }
                }
            }
            for (int ii = 0; ii < items.size(); ii++) {
                temp.add(items.get(ii));
                ret.add(new Item(1, temp, countAppearance(mTransaction, temp)));
            }
            return ret;
        }

        private ArrayList<Item> generateCandidateFromList(ArrayList<Item> list) {
            ArrayList<Item> candidate = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getSupport() >= mMinSup) {
                    if (!list.get(i).equals(candidate)) {
                        candidate.add(list.get(i));
                    }
                }
            }
            return candidate;
        }

        private ArrayList<Item> generateNextListFromCandidate(ArrayList<Item> candidate) {
            ArrayList<Item> list = new ArrayList();
            for (int i = 0; i < candidate.size(); i++) {
                for (int j = i; j < candidate.size(); j++) {
                    System.out.println("\ngenerateNextListFromCandidate");
                    printItemList(candidate);
                    if (distance(candidate.get(i), candidate.get(j)) == 1) {
                        System.out.println("i:" + i + ", j:" + j);
//                        candidate.get(i).print();
//                        candidate.get(j).print();

                        ArrayList<Itinerary> items = pickItems(candidate.get(i), candidate.get(j));
                        Item temp = new Item(candidate.get(0).getCount() + 1, items, countAppearance(mTransaction, items));
                      //  temp.print();
                        list.add(temp);
                    }
                }
            }
            return list;
        }

        private int distance(Item one, Item another) {
            int ret = one.getCount();
            for (int i = 0; i < one.getCount(); i++) {
                for (int j = 0; j < another.getCount(); j++) {
                    if (one.getSpot().get(i) == another.getSpot().get(j)) {
                        ret--;
                    }
                }
            }
            return ret;
        }

        private ArrayList<Itinerary> pickItems(Item one, Item another) {
            ArrayList<Itinerary> ret = new ArrayList<>();
            int i = 0;
            int j = 0;
            int index = 0;
            //System.out.println("pickItems");
//            one.print();
//            another.print();
            while((i < one.getCount()) || (j < another.getCount())) {
                if (one.getCount() == i) {
                    System.out.println("1");
                    ret.add(another.getSpot().get(j));
                    j++;
                } else if (another.getCount() == j) {
                    System.out.println("2");
                    ret.add(one.getSpot().get(i));
                    i++;
                }
//                else if (one.getItem(i) < another.getItem(j)) {
//                    System.out.println("3");
//                    ret[index++] = one.getItem(i);
//                    i++;
//                } else if (one.getItem(i) > another.getItem(j)) {
//                    System.out.println("4");
//                    ret[index++] = another.getItem(j);
//                    j++;
//                }
                else {
                    System.out.println("5");
                    ret.add(one.getSpot().get(i));
                    i++;
                    j++;
                }
            }
            return ret;
        }

        private void printArray(ArrayList<TouristaPackages> array) {
            for (int i = 0; i < array.size(); i++) {
                String out = "";
                ArrayList<Itinerary> buf = array.get(i).getPackageItinerary();
                for (int j = 0; j < buf.size(); j++) {
                    out += buf.get(j).getSpotName() + ", ";
                }
                System.out.println("transactionId : " + i + " - items : " + out);
            }
        }

        private void printItemList(ArrayList<Item> list) {
            ArrayList<Item> items= new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                items.add(list.get(i));
                System.out.print("ID : " + i + " - Items : ");
                for (int j = 0; j < items.size(); j++) {
                    System.out.print(items.get(j) + ", ");
                }
                System.out.println("MinSupport : " + list.get(i).getSupport());
            }
        }

}
