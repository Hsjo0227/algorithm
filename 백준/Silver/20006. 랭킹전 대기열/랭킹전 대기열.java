import java.io.*;
import java.util.*;

public class Main {
    static class Room {
        int levelFrom;
        List<Player> players;
        
        public Room(int level) {
            this.levelFrom = level-10;
            this.players = new ArrayList<>();
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if(players.size() == m) {
                sb.append("Started!\n");
            } else {
                sb.append("Waiting!\n");
            }
            
            Collections.sort(players);
            for(Player p : players) {
                sb.append(p.toString()).append("\n");
            }
            return sb.toString();
        }
        
    }
    
    static class Player implements Comparable<Player> {
        int level;
        String name;
        
        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }
        
        @Override
        public int compareTo(Player o) {
            return this.name.compareTo(o.name);
        }
        
        @Override
        public String toString() {
            return this.level + " " + this.name;
        }
    }
    
    static int m;
    static List<Room> rooms;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        rooms = new ArrayList<>();
        
        for(int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            
            add(level, name);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(Room room : rooms) {
            sb.append(room.toString());
        }
        
        System.out.println(sb);
    }
    
    public static void add(int level, String name) {
        Player p = new Player(level, name);
        for(Room room : rooms) {
            if(level < room.levelFrom || room.levelFrom+20 < level) continue;
            if(room.players.size() >= m) continue;
            room.players.add(p);
            return;
        }
        
        Room room = new Room(level);
        room.players.add(p);
        rooms.add(room);
    }
    
}