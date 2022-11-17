import java.util.*;
// 현재 좌표 x,y
class Point{
    int x; 
    int y;
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int answer = -1;
        int row = maps.length-1;
        int col = maps[0].length -1;
        
        bfs(row+1, col+1, maps);
                
        return maps[row][col];
    }
    
    public void bfs(int x, int y, int[][] maps){
        Queue<Point> que = new LinkedList<>();
        boolean[][] isVisited = new boolean[x][y];
        
        que.add(new Point(0,0));
        isVisited[0][0] = true;
        
        while(!que.isEmpty()){
            Point point = que.poll();
            for(int i=0; i<4; i++){
                int nr = point.x + dr[i];
                int nc = point.y + dx[i];
                if(nr < 0 || nr >= x || nc < 0 || nc >= y) continue; // 맵 범위 체크
                if(isVisited[nr][nc] != true && maps[nr][nc] != 0){ // 방문 여부 + 벽 체크
                    maps[nr][nc] = maps[point.x][point.y] + 1;
                    if(nr == x-1 && nc == y-1){  // 적 진영 도착시 return 
                        return;
                    }
                    isVisited[nr][nc] = true;   // 방문 체크
                    que.add(new Point(nr,nc));  // 다음 탐색 범위 추가
                    
                }
                
            }
        }
        maps[x-1][y-1] = -1;    // 상대 팀 진영에 도달하지 못하는 경우
    }
}
