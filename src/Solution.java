
public class Solution {

    public static int solution(int[] numbers) {

        /**
         * Calcula la menor cantidad de rotaciones necesarias para que todos los dados muestren la misma cara,
         * en base a los valores que recibe desde el array de int.
         * En caso de que alguno de esos valores no se corresponda con alguna de las 6 caras de un dado, 
         * emite un mensaje de error y un código de error.
         */

        int errorCode = 0;

        int evenPipsCounter = 0;

        int oddPipsCounter = 0;

        int count1 = 0;

        int count2 = 0;

        int count3 = 0;

        int count4 = 0;

        int count5 = 0;

        int count6 = 0;

        int rotationCounter = 0;

        for (int pip : numbers) {

            if (pip < 1 || pip > 6) { 
                errorCode = -1;

                Solution.showError(errorCode);

                return errorCode;

            } else {}

            if ((pip % 2) == 0) {

                evenPipsCounter++;

                if (pip == 2) {

                    count2++;

                } else if (pip == 4) {

                    count4++;

                } else {

                    count6++;
                }

            } else {

                oddPipsCounter++;

                if (pip == 1) {

                    count1++;

                } else if (pip == 3) {

                    count3++;

                } else {

                    count5++;
                }
            }

        }

        if (evenPipsCounter == numbers.length) {

            if (count2 == numbers.length || count4 == numbers.length || count6 == numbers.length) {

                rotationCounter = 0;

            } else {

                if (count2 > count4 && count2 > count6) {

                    rotationCounter = numbers.length - count2;

                } else if (count4 > count2 && count4 > count6) {

                    rotationCounter = numbers.length - count4;

                } else {

                    rotationCounter = numbers.length - count6;
                }

            }

        } else if (oddPipsCounter == numbers.length) {

            if (count1 == numbers.length || count3 == numbers.length || count5 == numbers.length) {

                rotationCounter = 0;

            } else {

                if (count1 > count3 && count1 > count5) {

                    rotationCounter = numbers.length - count1;

                } else if (count3 > count1 && count3 > count5) {

                    rotationCounter = numbers.length - count3;

                } else {

                    rotationCounter = numbers.length - count5;
                }
            }

        } else {

            if ((count1 >= count2 || count1 >= count3 || count1 >= count4 || count1 >= count5) && (count1 > count6)) {

                rotationCounter = (numbers.length + count6) - count1;

            } else if ((count2 >= count1 || count2 >= count3 || count2 >= count4 || count2 >= count6)
                    && (count2 > count5)) {

                rotationCounter = (numbers.length + count5) - count2;

            } else if ((count3 >= count1 || count3 >= count2 || count3 >= count6 || count3 >= count5)
                    && (count3 > count4)) {

                rotationCounter = (numbers.length + count4) - count3;

            } else if ((count4 >= count1 || count4 >= count2 || count4 >= count6 || count4 >= count5)
                    && (count4 > count3)) {

                rotationCounter = (numbers.length + count3) - count4;

            } else if ((count5 >= count1 || count5 >= count6 || count5 >= count3 || count5 >= count4)
                    && (count5 > count2)) {

                rotationCounter = (numbers.length + count2) - count5;

            } else if ((count6 >= count5 || count6 >= count2 || count6 >= count3 || count6 >= count4)
                    && (count6 > count1)) {

                rotationCounter = (numbers.length + count1) - count6;

            } else if (count1 == count2 && count2 == count3 && count3 == count4 && count4 == count5
                    && count5 == count6) {

                rotationCounter = numbers.length;

            }
        }

        return rotationCounter;

    }

    public static void showError(int errorCode) {

        //Imprime un mensaje de error por pantalla cuando recibe el código de error;

        String error = "";

        if (errorCode == -1) {

            error = "Die pip number missmatch!\nError Code: ";
        }

        System.out.println("" + error + "");

    }

}
