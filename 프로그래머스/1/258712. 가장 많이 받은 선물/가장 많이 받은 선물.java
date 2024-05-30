import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        //friends 문자열 배열을 list로 만들어주기 -> gifts 파싱할 때, 인덱스 사용하기 위해
        List<String> friendsList = Arrays.asList(friends);

        //선물지수를 저장하기 위한 map 객체 생성
        Map<String, Integer> points = new HashMap<>();
        for(String temp : friends){
            points.put(temp, 0);
        }
        
        //표 만들기
        int[][] giverReciever = new int[friends.length][friends.length];

        for(String event : gifts){
            String[] temp = event.split(" ");
            giverReciever[friendsList.indexOf(temp[0])][friendsList.indexOf(temp[1])]++;

            //선물지수 값 구하기
            points.compute(temp[0], (k, v) -> v+1);
            //points.put(temp[0], points.get(temp[0])++); 이거랑 어떤게 더 좋은걸까?
            points.compute(temp[1], (k, v) -> v-1);
        }

        //선물주기
        int[] result = new int[friends.length];
        for(int i=0; i<result.length; i++){
            for(int j=i+1; j<result.length; j++){
                if(giverReciever[i][j] < giverReciever[j][i]){
                    result[j]++;
                    continue;
                }
                if(giverReciever[i][j] > giverReciever[j][i]){
                    result[i]++;
                    continue;
                }

                if(points.get(friends[i]) == points.get(friends[j])){
                    continue;
                }
                else{
                    if(points.get(friends[i]) > points.get(friends[j])){
                        result[i]++;
                    }else{
                        result[j]++;
                    }
                }
            }
        }

        for(int i : result){
            if(i > answer) answer = i;
        }

        return answer;
    }
}
