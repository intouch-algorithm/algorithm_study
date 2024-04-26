root : [[Leetcode]]
url : https://leetcode.com/problems/daily-temperatures/

## 2024-04-26 15:20

### 문제

Given an array of integers `temperatures` represents the daily temperatures, return *an array* `answer` *such that* `answer[i]` *is the number of days you have to wait after the* `ith` *day to get a warmer temperature*. If there is no future day for which this is possible, keep `answer[i] == 0` instead.

**Example 1:**

**Input:** temperatures = [73,74,75,71,69,72,76,73]
**Output:** [1,1,4,2,1,1,0,0]

**Example 2:**

**Input:** temperatures = [30,40,50,60]
**Output:** [1,1,1,0]

**Example 3:**

**Input:** temperatures = [30,60,90]
**Output:** [1,1,0]

### 아이디어

1. 이중포문으로 풀면 되는데?! stack을 사용해서 어떻게 풀지?!

### 놓친 부분

O(n^2) 로 풀 순 있는데 Stack으로 어떻게 풀어야할지 모르겠다....

### 시간 복잡도

### 내 풀이

소요 시간 :

```python
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        res = [0] * len(temperatures)
        stack = [] # [temp,index]
        for i, t in enumerate(temperatures) :
            while stack and t > stack[-1][0] :
                stackT, stackInd = stack.pop()
                res[stackInd] = (i - stackInd)
            stack.append([t,i])
        return res
```

### 최적화 정답

```python

```

### 관련있는 개념
