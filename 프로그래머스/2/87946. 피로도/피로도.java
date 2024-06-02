import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int factorial(int n){
        if(n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }

    public void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r, List<int[]> cases){
        if(depth == r){
            int[] copy = Arrays.copyOf(output, depth);
            cases.add(copy);
        }

        for(int i=0; i<n; i++){
            if(visited[i] != true){
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth+1, n, r, cases);
                visited[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        int answer = 0;

        int n = dungeons.length;
        int[] index_arr = new int[n];
        int[] output = new int[n];
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++){
            index_arr[i] = i;
        }
        List<int[]> cases = new ArrayList<>();

        permutation(index_arr, output, visited, 0, n, n, cases);

        for(int[] each_case : cases){
            int _k = k;
            int count = 0;
            for(int i : each_case){
                if(_k >= dungeons[i][0]){
                    _k -= dungeons[i][1];
                    count++;
                }
                if(_k <= 0) break;
            }
            if(count == n) return n;
            if(count > answer) answer = count;
        }

        return answer;
    }
}
