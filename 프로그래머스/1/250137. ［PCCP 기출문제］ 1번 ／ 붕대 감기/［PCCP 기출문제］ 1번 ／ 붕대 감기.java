class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {

        int time = attacks[attacks.length-1][0];

        int bandage_time = bandage[0];
        int _health = health;
        int index = 0;

        for(int i=1; i<=time; i++){
            if(attacks[index][0] == i){
                _health -= attacks[index][1];
                bandage_time = bandage[0];
                index++;
                if(_health <= 0) return -1; 
            }else{
                bandage_time--;
                if(bandage_time > 0){
                    _health += bandage[1];
                }else{
                    _health += bandage[1] + bandage[2];
                    bandage_time = bandage[0];
                }
                if(_health > health) _health = health;
            }
        }

        return _health;
    }
}