import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    public class DirReduction {

        public boolean opposite(String dir1, String dir2) {
            return (dir1.equals("NORTH") && dir2.equals("SOUTH")) ||
                   (dir1.equals("SOUTH") && dir2.equals("NORTH")) ||
                   (dir1.equals("WEST") && dir2.equals("EAST")) ||
                   (dir1.equals("EAST") && dir2.equals("WEST"));
        }

        public String[] dirReduc(String[] arr) {
            List<String> finalDirs = new ArrayList<>();
            for (String currentDir : arr) {
                if (finalDirs.isEmpty() || !opposite(currentDir, finalDirs.get(finalDirs.size() - 1))) {
                    finalDirs.add(currentDir);
                } else {
                    finalDirs.remove(finalDirs.size() - 1);
                }
            }
            return finalDirs.toArray(new String[0]);
        }
    }

}
