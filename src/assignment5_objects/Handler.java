/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_objects;

import java.util.Arrays;

/**
 *
 * @author Joe
 */
public class Handler {

    public void FindMedianPop(Countries[] country, int n, Utility util) {
        int index;

        Countries[] countryCopy = Arrays.copyOf(country, n);
        util.SelectionSort(countryCopy, n, "population");
        index = util.BinarySearchPop(countryCopy, n / 2, n);
        System.out.print(countryCopy[index].getPop() + " - " + countryCopy[index].getName());
    }

    public void FindMedianPopFromContinent(Countries[] country, int n, Utility util, String search) {

        Countries[] contSearchCountry = new Countries[n];
        int index = 1;
        int id;

        for (int i = 1; i < n; i++) {
            if (country[i].getContinent().equals(search)) {
                //System.out.println(country[i].getContinent());
                contSearchCountry[index] = country[i];
                index++;
            }
        }

        Countries[] countryCopy = Arrays.copyOf(contSearchCountry, n);
        util.SelectionSort(countryCopy, index, "population");
        id = util.BinarySearchPop(countryCopy, index / 2, n);
        System.out.print(countryCopy[id].getPop() + " - " + countryCopy[id].getName());

    }

    public void FindMedSize(Countries[] country, int n, Utility util) {
        int index;

        Countries[] countryCopy = Arrays.copyOf(country, n);
        util.SelectionSort(countryCopy, n, "size");
        index = util.BinarySearchPop(countryCopy, n / 2, n);
        System.out.print(countryCopy[index].getPop() + " - " + countryCopy[index].getName());

    }

    public void FindMedSizeByCont(Countries[] country, int n, Utility util, String search) {

        Countries[] contSearchCountry = new Countries[n];
        int index = 1;
        int id;

        for (int i = 1; i < n; i++) {
            if (country[i].getContinent().equals(search)) {
                //System.out.println(country[i].getContinent());
                contSearchCountry[index] = country[i];
                index++;
            }
        }

        Countries[] countryCopy = Arrays.copyOf(contSearchCountry, n);
        util.SelectionSort(countryCopy, index, "size");
        id = util.BinarySearchPop(countryCopy, index / 2, n);
        System.out.print(countryCopy[id].getPop() + " - " + countryCopy[id].getName());
    }

    public void ShowCountryByName(Countries[] country, int n, Utility util, String search) {
        int index;
        util.LinearSearch(country, search, 9, n, "name");
    }

    public void ShowCountryByID(Countries[] country, int n, Utility util, String search) {

        int index = Integer.parseInt(search);

        util.PrintACountry(country, index);

    }

    public void ShowCountryByCode(Countries[] country, int n, String search, Utility util) {

        int index = 1;
        int[] id;

        Countries[] countryCopy = Arrays.copyOf(country, n);
        util.SelectionSort(countryCopy, n, "code");
        id = util.BinarySearch(countryCopy, search, n);
        System.out.print(countryCopy[id[0]].getPop() + " - " + countryCopy[id[0]].getName());
        System.out.printf("\nSEARCH >> %d PASSES", id[0]);
    }
    
    public void ShowCountriesByContinent(Countries[] country, int n,Utility util, String search){
        util.LinearSearch(country, search, n, n, "continent");
    }

}
