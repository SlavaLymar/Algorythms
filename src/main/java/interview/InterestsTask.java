package interview;

import java.util.HashMap;
import java.util.Map;

public class InterestsTask {

    public static void main(String[] args) {
        final String gym = "gym";
        final String school = "school";
        final String store = "store";
        HashMap<String, Boolean> block1 = new HashMap<>() {{
            put(gym, false);
            put(school, true);
            put(store, false);
        }};
        HashMap<String, Boolean> block2 = new HashMap<>() {{
            put(gym, true);
            put(school, false);
            put(store, false);
        }};
        HashMap<String, Boolean> block3 = new HashMap<>() {{
            put(gym, true);
            put(school, true);
            put(store, false);
        }};
        HashMap<String, Boolean> block4 = new HashMap<>() {{
            put(gym, false);
            put(school, true);
            put(store, false);
        }};
        HashMap<String, Boolean> block5 = new HashMap<>() {{
            put(gym, false);
            put(school, true);
            put(store, true);
        }};

        System.out.println(
                getBlockByInterest(
                        new HashMap[]{block1, block2, block3, block4, block5}, new String[]{gym, school, store}
                )
        );
    }

    public static int getBlockByInterest(Map<String, Boolean>[] blocks, String[] req) {
        int minDistance = Integer.MAX_VALUE, idx = -1;

        for (int i = 0; i < blocks.length; i++) {
            Map<String, Boolean> block = blocks[i];
            int distance = 0;
            for (String rq : req) {
                if (!block.get(rq)) {
                    int up = i - 1, down = i + 1;
                    while (up >= 0 || down < blocks.length) {
                        if (up >= 0) {
                            Map<String, Boolean> blockUp = blocks[up];
                            distance += Math.abs(up - i) * Math.abs(up - i);
                            if (blockUp.get(rq)) {
                                break;
                            }
                            up--;
                        }
                        if (down < blocks.length) {
                            Map<String, Boolean> blockDown = blocks[down];
                            distance += Math.abs(down - i) * Math.abs(down - i);
                            if (blockDown.get(rq)) {
                                break;
                            }
                            down++;
                        }
                    }
                }
            }
            if (distance < minDistance) {
                idx = i;
                minDistance = distance;
            }
        }
        return idx;
    }
}
