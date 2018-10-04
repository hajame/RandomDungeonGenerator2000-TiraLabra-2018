package dungeongenerator.domain;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Main class
 *
 * @author hajame
 */
public class Main {

    public static void main(String[] args) {

        
        // PARAMETERS
        // over 500x500 will take a lot of time
        // also increase roomPlacementAttempts on bigger maps (for speed)
        int dungeonHeight = 75;
        int dungeonWidth = 125;

        // max and min values for room edges
        int roomMin = 5;
        int roomMax = 10;
        // no. of attempts to place rooms.
        int roomPlacementAttempts = 50;
        
        
        long time = System.currentTimeMillis();
        ArrayList<Long> times = new ArrayList();
        Generator generator = new Generator(dungeonHeight, dungeonWidth, 
                roomMin, roomMax, roomPlacementAttempts);
        generator.generateDungeon();
        time = System.currentTimeMillis() - time;
        Dungeon dungeon = generator.getDungeon();
        char[][] map = dungeon.getMap();
        dungeon.print();
        System.out.println("Creation time \t\t" + time + " ms");
        System.out.println("Height \t\t\t" + dungeonHeight);
        System.out.println("Width \t\t\t" + dungeonWidth);
        System.out.println("Room side len. \t\t"+roomMin+"-"+roomMax);
        System.out.println("Room placement attempts "+roomPlacementAttempts);
        
        System.out.println("RoomList, size: "+dungeon.getRooms().size());

        // Uncomment code below to run tests! Feel free to change
        

//        int n = 10;
//        long sum = 0;        
//        
//        for (int i = 0; i < n; i++) {
//            time = System.currentTimeMillis();
//            generator = new Generator(dungeonHeight, dungeonWidth,
//                    roomMin, roomMax, roomPlacementAttempts);
//            generator.generateDungeon();
//            time = System.currentTimeMillis() - time;
//            sum += time;
//            times.add(time);
//        }
//        times.sort(Comparator.naturalOrder());
//        System.out.println("\n\nTEST RESULTS (ms), n = "+n);
//        System.out.println(times.toString());
//        System.out.println("Avg duration: " + sum / n+" ms");
    }

}
