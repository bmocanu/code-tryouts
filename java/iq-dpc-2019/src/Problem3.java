public class Problem3 {

    public static class Line {

        public static String Tickets(int[] peopleInLine) {
            int billsOf25 = 0;
            int billsOf50 = 0;

            for (int index = 0; index < peopleInLine.length; index++) {
                int currentBill = peopleInLine[index];
                if (currentBill == 25) {
                    billsOf25++;
                } else if (currentBill == 50) {
                    billsOf50++;
                    if (billsOf25 > 0) {
                        billsOf25--;
                    } else {
                        return "NO";
                    }
                } else if (currentBill == 100) {
                    if (billsOf25 > 0 && billsOf50 > 0) {
                        billsOf25--;
                        billsOf50--;
                    } else {
                        if (billsOf25 > 2) {
                            billsOf25 -= 3;
                        } else {
                            return "NO";
                        }
                    }
                }
            }

            return "YES";
        }

    }

    public static void main(String[] args) {
        System.out.println(Line.Tickets(new int[]{25, 25, 50}));
    }
}