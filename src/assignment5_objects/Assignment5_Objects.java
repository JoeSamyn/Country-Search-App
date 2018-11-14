/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Joe
 */
public class Assignment5_Objects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        //----- Variable Declarations -----
        File inFile = new File("A5WorldData.csv");
        Scanner scan = new Scanner(inFile);

        int MAX_SIZE = 350;
        int n = 1;
        String aLine;
        boolean keepGoing = true;
        String[] Field = new String[8];
        Countries[] countries = new Countries[MAX_SIZE];
        String userInput;
        
        Utility util = new Utility();
        Handler handle = new Handler();

//        Utilities util = new Utilities();
//        QueryHandler handle = new QueryHandler();
        //----- Read Data From File -----
        scan.nextLine();
        //---- Begin File while -----
        while (scan.hasNext()) {
            aLine = scan.nextLine();
            Field = aLine.split(",");
            Countries country = new Countries(Field[0], Field[2], Field[3], Field[5], Field[6]);
            countries[n] = country;
            n++;
        }
        
//        for(int i = 1; i < n; i++){
//            System.out.println(countries[i].getPop());
//        }

        Main(keepGoing, n, util, handle, countries);
    }

    public static void Main(boolean keepGoing, int n, Utility util, Handler handle, Countries[] country) {
        String userInput;
        while (keepGoing) {
            int userSelection = util.GetUserInput();

            switch (userSelection) {
                case 1:
                    handle.FindMedianPop(country, n, util);
                    break;
                case 2:
                    userInput = util.GetContinent();
                    handle.FindMedianPopFromContinent(country, n, util, userInput);
                    break;
                case 3:
                    handle.FindMedSize(country, n, util);
                    break;
                case 4:
                    userInput = util.GetContinent();
                    handle.FindMedSizeByCont(country, n, util, userInput);
                    break;
                case 5:
                    userInput = JOptionPane.showInputDialog("Please Enter A Countries Name"
                            + "You Wish To Find");
                    handle.ShowCountryByName(country, n, util, userInput);
                    break;
                case 6:
                    userInput = JOptionPane.showInputDialog("Please Enter The ID of the "
                            + "Country You Wish To Find");
                    handle.ShowCountryByID(country, n, util, userInput);
                    break;
                case 7:
                    userInput = JOptionPane.showInputDialog("Enter the Code Of A Country"
                            + " You Are Searching For");
                    handle.ShowCountryByCode(country, n, userInput.toUpperCase(), util);
                    break;
                case 8:
                    userInput = util.GetContinent();
                    handle.ShowCountriesByContinent(country, n, util, userInput);
                    break;
                case 9:
                    keepGoing = false;
                    break;
                default:
                    userInput = util.GetContinent();
                    handle.ShowCountriesByContinent(country, n, util, userInput);
                    break;
            }
            System.out.println();
            for (int i = 0; i < 20; i++) {
                System.out.print("*");
            }
            System.out.println();

        }

        //----- End user Query while -----
    }
}


