public class Problem2 {

    public static class Dartboard {

        /*
Bull's eye: `12.70 mm`
Bull: `31.8 mm`
Triple ring inner circle: `198 mm`
Triple ring outer circle: `214 mm`
Double ring inner circle: `324 mm`
Double ring outer circle: `340 mm`
         */

        public double dist(double x, double y) {
            return Math.sqrt(x * x + y * y);
        }

        public double angle(double radius, double x, double y) {
            return (2 * Math.atan2(y + radius, x)) * 180 / Math.PI;
        }

        public String getScore(double x, double y) {
            System.out.println("-------------");
            System.out.println("X=" + x + ", Y=" + y);
            double distToCenter = dist(x, y);
            System.out.println("dist=" + distToCenter);
            if (distToCenter > 340d / 2) {
                return "X";
            }
            if (distToCenter <= 12.70d) {
                return "DB";
            }
            if (distToCenter <= 31.80d) {
                return "SB";
            }

            int multiplier = 1;
            if (distToCenter >= 324d / 2 && distToCenter < 340d / 2) {
                multiplier = 2;
            }
            if (distToCenter >= 198d / 2 && distToCenter < 214d / 2) {
                multiplier = 3;
            }

            int[] values = new int[]{20, 1, 18, 4, 13, 6, 10, 15, 2, 17, 3, 19, 7, 16, 8, 11, 14, 9, 12, 5, 20};
            int angle = (int) Math.round(angle(distToCenter, x, y));
            System.out.println("angle=" + angle);
            int point = (angle) / 18;

            return "" + values[point] * multiplier;
        }
    }


    public static void main(String[] args) {
        Dartboard db = new Dartboard();
        System.out.println(db.getScore(-133.69, -147.38));
        System.out.println(db.getScore(4.06, 0.71));
        System.out.println(db.getScore(2.38, -6.06));
        System.out.println(db.getScore(-5.43, 117.95));
        System.out.println(db.getScore(-73.905, -95.94));
        System.out.println(db.getScore(55.53, -87.95));
        System.out.println(db.getScore(-145.19, 86.53));

    }

}
