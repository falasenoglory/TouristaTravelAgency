package com.touristadev.tourista.formba;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.touristadev.tourista.R;
import com.touristadev.tourista.dataModels.Spots;
import com.touristadev.tourista.dataModels.TouristaPackages;

import java.util.ArrayList;

public class MBAActivity extends AppCompatActivity {

    private ArrayList<TouristaPackages> TransactionList = new ArrayList<>();

    private ArrayList<Spots> SpotsList= new ArrayList<>();
    private ArrayList<Spots> TempSpotsList= new ArrayList<>();

    private ArrayList<Item> FrequentList = new ArrayList<>();
    private ArrayList<Item> NewFrequecyList= new ArrayList<>();
    private ArrayList<Item> CandidateList= new ArrayList<>(); // RULE


    private int candidateListSize=1;
    private double minSup=2;
    private double confidence;


    private ArrayList<ArrayList<String>> ItemSets= new ArrayList();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mba);



        // 1. get Combination
        printCombination(SpotsList, SpotsList.size(), candidateListSize);

        // 2. check if pasay sa min Support
        NewFrequecyList= excecuteApriori(TransactionList, NewFrequecyList);

        // 3. Prune;
        NewFrequecyList= Prune(NewFrequecyList,candidateListSize);



    }



    public void combinationUtil(ArrayList<Spots> spotsList, int n, int r, int index,
                                ArrayList<Spots> tempSpotsList, int i)
    {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            for (int j=0; j<r; j++) {
                tempSpotsList.add(spotsList.get(j));
            }
//            NewFrequecyList.add(new Item(tempSpotsList,0));
            System.out.println("");
            return;
        }

        // When no more elements are there to put in data[]
        if (i >= n)
            return;

        // current is included, put next at next location
        tempSpotsList.get(index).equals(spotsList.get(i));
        combinationUtil(spotsList, n, r, index+1, tempSpotsList, i+1);

        // current is excluded, replace it with next (Note that
        // i+1 is passed, but index is not changed)
        combinationUtil(spotsList, n, r, index, tempSpotsList, i+1);
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    public void printCombination(ArrayList<Spots> arr, int n, int r)
    {
        // A temporary array to store all combination one by one
        ArrayList<Spots> data=new ArrayList<>();

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, n, r, 0, data, 0);
    }

    /*Driver function to check for above function*/
//    public static void main (String[] args) {
//        int arr[] = {1, 2, 3, 4, 5};
//        int r = 3;
//        int n = arr.length;
//        printCombination(arr, n, r);
//    }








    public ArrayList<Item> excecuteApriori(ArrayList<TouristaPackages> transactions, ArrayList<Item> items)
    {

        ArrayList<Item> newitem= new ArrayList<>();
        int m,n,h,i;

        for( m=0; m<items.size(); m++) {

            for (n=0; n<items.get(m).getSpot().size(); n++) {
                int counter = 0;
                for (h = 0; h < transactions.size(); h++) {

                    counter = 0;
                    for ( i = 0; i < transactions.get(i).getPackageItinerary().size(); i++) {


                        if (items.get(m).getSpot().get(n).getSpotName().equals(transactions.get(h).getPackageItinerary().get(i).getSpotName()))
                        {
                            counter++;
                        }

                    }
                    if (counter==items.size())
                    {
                        items.get(i).setSupport(items.get(i).getSupport()+1);
                    }
                }
            }
        }


        newitem=items;
        return newitem;
    }


    public ArrayList<Item> Prune(ArrayList<Item> items, int candidatesize)
    {
        for (int i=0; i<items.size();i++)
        {
            if(items.get(i).getSupport()<candidatesize)
            {
                items.remove(i);
            }
        }


        return items;
    }




}
