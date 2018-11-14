/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_objects;

import javax.swing.JOptionPane;

/**
 *
 * @author Joe
 */
public class Utility {

    public int GetUserInput() {
        String userInput;
        int userSelection;
        userInput = JOptionPane.showInputDialog("Choose an option (Select a number 1-9)\n"
                + "1  Median Population\n"
                + "2  Median Population By Specific Continent\n"
                + "3  Median Land Size\n"
                + "4  Median Land Size By Specific Continent\n"
                + "5  Show Country - Specify The Name\n"
                + "6  Show Country - Specify ID\n"
                + "7  Show Country Code - Specify Code\n"
                + "8  Show All Countries In A Continent\n"
                + "9  Quit");

        return userSelection = Integer.parseInt(userInput);

    }

    public String GetContinent() {
        String userInput = JOptionPane.showInputDialog("Select A Continent:\n"
                + "1 Africa\n"
                + "2 Antarctica\n"
                + "3 Asia\n"
                + "4 Europe\n"
                + "5 North America\n"
                + "6 Oceania\n"
                + "7 South America\n");

        switch (userInput) {
            case "1":
                return "Africa";
            case "2":
                return "Antarctica";
            case "3":
                return "Asia";
            case "4":
                return "Europe";
            case "5":
                return "North America";
            case "6":
                return "Oceania";
            case "7":
                return "South America";
            default:
                return "Europe";
        }

    }

    public void SelectionSort(Countries[] country, int n, String sortKey) {

        int iOfTempMin;
        for (int i = 1; i < n - 1; i++) {
            iOfTempMin = i;
            for (int index = i + 1; index < n; index++) {
                switch (sortKey) {
                    case ("code"):
                        //System.out.println("hit");
                        if (country[index].getCode().compareTo(country[iOfTempMin].getCode()) < 0) {
                            iOfTempMin = index;
                        }
                        break;
                    case ("name"):
                        if (country[index].getName().compareTo(country[iOfTempMin].getName()) < 0) {
                            iOfTempMin = index;
                        }
                        break;
                    case ("continent"):
                        if (country[index].getContinent().compareTo(country[iOfTempMin].getContinent()) < 0) {
                            iOfTempMin = index;
                        }
                        break;
                    case ("population"):
                        //System.out.println("hit");
                        if (country[index].getPop() < country[iOfTempMin].getPop()) {
                            iOfTempMin = index;
                        }
                        break;
                    case ("size"):
                        if (country[index].getSize() < country[iOfTempMin].getSize()) {
                            iOfTempMin = index;
                        }
                } // end of switch
                Swap(country, i, iOfTempMin);
            } // end of outer for loop
        }// end of theSort method

    }

    private void Swap(Countries[] country, int i1, int i2) {

        Countries tempCountry;
//System.out.println("hit");
        tempCountry = country[i1];
        country[i1] = country[i2];
        country[i2] = tempCountry;

    }

    public int BinarySearchPop(Countries[] country, long target, int n) {

        System.out.println(target);
        int lowI = 1;
        int highI = n;
        int middleI;
        while (lowI <= highI) {
            middleI = (lowI + highI) / 2;
            System.out.println(target);
            System.out.println(middleI);
            if (target == middleI) {
                return middleI;
            } else if (target > middleI) {
                lowI = middleI + 1;
            } else {
                highI = middleI - 1;
            }
        }
        return -1;
    }

    public int[] BinarySearch(Countries[] country, String target, int n) {

        //System.out.println(stringArray.length);
        int lowI = 1;
        int highI = n;
        int middleI;
        int[] intArr = new int[2];
        int numSearches = 0;

        while (lowI <= highI) {
            middleI = (lowI + highI) / 2;
            if (target.equals(country[middleI].getCode())) {
//                System.out.println(middleI);
//                System.out.println(country[middleI].getCode());
                intArr[0] = middleI;
                intArr[1] = numSearches;
                return intArr;
            } else if (target.compareTo(country[middleI].getCode()) > 0) {
                lowI = middleI + 1;
            } else {
                highI = middleI - 1;
            }
            numSearches++;
        }
        return intArr;
    }

    public void LinearSearch(Countries[] country, String target, long targetLong, int n, String search) {
        switch (search) {
            case "population":
                for (int i = 1; i < n; i++) {
                    if (country[i].getPop() == targetLong) {
                        PrintACountry(country, i);
                    }
                }
                break;
            case "code":
                for (int m = 1; m < n; m++) {
                    if (country[m].getCode().equals(target)) {
                        PrintACountry(country, m);
                    }
                }
                break;
            case "name":
                for (int l = 1; l < n; l++) {
                    if (country[l].getName().equals(target)) {
                        PrintACountry(country, l);
                    }
                }
                break;
            case "continent":
                for (int v = 1; v < n; v++) {
                    if (country[v].getContinent().equals(target)) {
                        PrintACountry(country, v);
                    }
                }
                break;
            case "size":
                for (int c = 1; c < n; c++) {
                    if (country[c].getSize() == (targetLong)) {
                        PrintACountry(country, c);
                    }
                }
                break;
        }

    }

    public void PrintACountry(Countries[] country, int id) {

        System.out.printf("%3d %3s - %-15.10s (%-13s) %,10d sq.miles – pop %,14d\n",
                id, country[id].getCode(), country[id].getName(), country[id].getContinent(),
                country[id].getSize(), country[id].getPop());
    }

}
