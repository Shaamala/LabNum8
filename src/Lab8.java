//
//* Abduljabbar Shaamala
//* Lab Number 8
//

import java.util.Scanner;

    public class Lab8 {

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            System.out.println("Welcome to Batting Average Calculator!");
            System.out.println();
            int count = 0; // bat counter
            int batNum; // bat input
            double sumResult = 0; // sum of bat result
            double avg; // batting average
            double slug; // slugging percentage
            String cont = "y"; // loop condition

            while ("y".equalsIgnoreCase(cont)) {

                System.out.print("Enter number of times at bat: ");
                /* validate and assign the input a */
                batNum = getInt(scan);

                System.out.println();
                System.out.println("0=out, 1=single, 2=double, 3=triple, 4=home run");
                System.out.println();
                /* assign results array */
                int[] result = new int[batNum];
                // loop to accept result
                for (int i = 0; i < batNum; i++) {

                    System.out.print("Result for at-bat" + i + ": ");
                    int input = 0;
                    // validate and assign input results
                    result[i] = getIntRang(scan, input);
                    count +=i; // counter
                }
                // loop to sum the result from array
                for (int temp:result) sumResult += temp;
                // average
                avg = sumResult / count;
                //slugging
                slug = sumResult / batNum;

                System.out.println();
                System.out.printf("Batting average: %.3f \n", avg);
                System.out.printf("Slugging Percentage: %.3f", slug);
                System.out.println();

                // ask user of continue
                System.out.println("Another batter? y/n");
                String input = scan.nextLine();
                // check answer
                if ("y".equalsIgnoreCase(input)) {
                    cont = "y";
                } else {
                    cont = "n";
                }
            }

            // the program has end
            System.out.println("Goodbye!");
            scan.close();

        }
        // input validation
        private static int getInt(Scanner sc) {
            int input = 0;
            boolean isValid = false;
            while (!isValid) {

                if (sc.hasNextInt()) { // check integer number
                    input = sc.nextInt();
                    if (input > 0) { // check positive number greater than 0
                        isValid = true;}
                    else {
                        System.out.println("only positive number, try again!");
                        sc.nextLine();
                    }

                } else {
                    isValid = false;
                    System.out.println("Error! Invalid integer value. Try again.");
                    sc.nextLine();
                }
            }
            return input;
        }
        // bat-result input validation method
        private static int getIntRang(Scanner sc, int input) {

            boolean isValid = false;
            while (!isValid) {

                if (!sc.hasNextInt()) { // check if not integer number
                    isValid = false;
                    System.out.println("Not a number. Please input integer number 0-4.");
                    sc.next();
                } else { // its integer number
                    input = sc.nextInt();
                    // check the min and max range
                    if (input <= 4 && !(input < 0)) {
                        isValid = true;
                    } else {
                        isValid = false;
                        System.out.println("Error! Not in range. Please input number 0-4.");
                    }
                    sc.nextLine();
                }
            }
            return input;
        }
    }


