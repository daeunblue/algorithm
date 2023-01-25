import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int dist, farNode;
    static ArrayList<Node> tree[];
    static boolean[] isVisited;

    public static class Node{ // 위치, 가중치
        int pos;
        int weight;

        Node(int pos, int weight){
            this.pos = pos;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        dist = 0;
        farNode = 0;
        tree = new ArrayList[N+1];
        isVisited = new boolean[N+1];

        // tree 초기화 (하나의 노드에는 두개의 자식이 있는 완전이진트리이기 때문에 ArrayList로 초기값 채워주기)
        for(int i = 0 ; i < N+1; i++){
            tree[i] = new ArrayList<>();
        }

        // input 처리
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[parent].add(new Node(child, weight)); // 부모 노드와 연결
            tree[child].add(new Node(parent,weight)); // 자식 노드와 연결
        }

        // 맨 처음부터 시작해서 -> 가장 거리가 먼 곳을 지정한다. -> 해당 지점에서 가장 거리가 먼 지점까지의 거리가 트리의 지름이 된다.
        isVisited[1] = true; // 첫노드는 방문 처리해주기
        DFS(1,0); // 가장 거리가 먼 노드 찾아내기

        isVisited = new boolean[N+1]; // 방문기록 초기화
        dist = 0; // 거리 초기화
        isVisited[farNode] = true; // 첫노드는 방문 처리해주기
        DFS(farNode, 0);    // 맨 끝이므로 여기서 가장 먼 노드를 찾아내면 된다.

        System.out.println(dist);
    }

    public static void DFS(int nodeNum, int totalDist){
        if(dist < totalDist){   // 최장거리 노드 갱신
            dist = totalDist;
            farNode = nodeNum;
        }

        for(Node nNode : tree[nodeNum]){
            if(isVisited[nNode.pos]) continue; // 중복방문 제거
            isVisited[nNode.pos] = true; // 방문 처리
            DFS(nNode.pos, totalDist+nNode.weight);
        }

    }
}