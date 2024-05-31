import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        //ext 값 무엇인지 알기.
        int index = 0;
        switch (ext) {
            case "code": 
                index =  0;
                break;
            case "date": 
                index =  1;
                break;
            case "maximum": 
                index =  2;
                break;
            case "remain": 
                index =  3;
                break;
        }

        //sort_by 값 알기
        int sort_index = 0;
        switch (sort_by) {
            case "code": 
                sort_index =  0;
                break;
            case "date": 
                sort_index =  1;
                break;
            case "maximum": 
                sort_index =  2;
                break;
            case "remain": 
                sort_index =  3;
                break;
        }
        
        //Comparator 재정의 할 때 사용
        final int _index = sort_index;

        //기준값을 만족하는 값 저장 + 정렬
        Set<int[]> _answer = new TreeSet<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[_index]-o2[_index];
            }
        });

        for(int[] temp : data){
            if(temp[index] < val_ext){
                _answer.add(temp);
            }
        }

        int[][] answer = _answer.toArray(new int[0][0]);

        return answer;
    }
}