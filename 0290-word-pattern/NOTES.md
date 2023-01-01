map.put return the previosly assign value like if we put first time (a,0) it return -1 becaz 'a' is getting value first time but when we again assign like (a,0) then it will return previouly assign value that is 0.
​
map.putIfAbsent also show same property like put but if do not assign value to key which already have value like if (a,3) then if (a,5) comes then it will not assign 5 to a becaz it already have value.
​
here we are using Integer instead of int(autoboxing see in discuss section of