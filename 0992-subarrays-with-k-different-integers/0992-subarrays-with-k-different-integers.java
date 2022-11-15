class Solution {
     public int countSubstringForK(int[] arr,int k){
        int i = -1;
        int j = -1;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        while(true){
            while(i<arr.length-1){
                i++;
                int c = arr[i];
                map.put(c,map.getOrDefault(c,0)+1);
                if(map.size()<=k){
                    count += i-j;
                    continue;
                }else{
                    break;
                }
            }

            if(i==arr.length-1 && map.size()<=k){
                break;
            }

            while(j<i){
                j++;
                int c = arr[j];
                if(map.get(c)==1){
                    map.remove(c);
                }else{
                    map.put(c,map.get(c)-1);
                }
                if(map.size()>k){
                    continue;
                }else{
                    count += i-j;
                    break;
                }
            }
        }
        return count;
    }

    public int countSubstringForK2(int []arr,int k){
        int i = -1;
        int j = -1;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        while(true){
            while(i<arr.length-1){
                i++;
                int c = arr[i];
                map.put(c,map.getOrDefault(c,0)+1);
                if(map.size()<=k-1){
                    count += i-j;
                    continue;
                }else{
                    break;
                }
            }

            if(i==arr.length-1 && map.size()<=k-1){
                break;
            }

            while(j<i){
                j++;
                int c = arr[j];
                if(map.get(c)==1){
                    map.remove(c);
                }else{
                    map.put(c,map.get(c)-1);
                }
                if(map.size()>k-1){
                    continue;
                }else{
                    count += i-j;
                    break;
                }
            }
        }
        return count;
    }
    
    public int subarraysWithKDistinct(int[] arr, int k) {
    
        return (countSubstringForK(arr,k)-countSubstringForK2(arr,k));

    }
}