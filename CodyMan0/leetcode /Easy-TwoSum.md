## 2024-03-28

### 문제
Given an array of integers `nums` and an integer `target`, return _indices of the two numbers such that they add up to `target`_.

You may assume that each input would have **_exactly_ one solution**, and you may not use the _same_ element twice.

You can return the answer in any order.

--- 
**Example 1:**

**Input:** nums = [2,7,11,15], target = 9
**Output:** [0,1]
**Explanation:** Because nums[0] + nums[1] == 9, we return [0, 1].

**Example 2:**

**Input:** nums = [3,2,4], target = 6
**Output:** [1,2]

**Example 3:**

**Input:** nums = [3,3], target = 6
**Output:** [0,1]
### 아이디어
- 이중 포문으로 i+1번째 부터 j로 이중 순회하여 target 값이 있으면 [i,j] 리턴하면 문제가 해결될 듯하다. 
### 놓친 부분
- 시간 복잡도가 O(n^2)로 1664ms가 걸린다. 이 부분을 해결해야한다. 

### 시간 복잡도
-  O(n^2)

### 내 풀이
소요 시간 : 5분
```python
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)):
            for j in range(i+1, len(nums)) : 
                if nums[i] + nums[j] == target : 
                    return [i,j]
```


### 최적화 정답
도출 아이디어 : 기존 이중 순회 해결한 문제를 Hash-map을 활용하여 이전 값과 인덱스를 가지고 와서 target과 비교하여 문제를 해결할 수 있다. 어떻게 할 수 있을까?!

1. 해시맵을 초기화하자.
2. 해시맵에 무엇을 저장할까?!
	1. 결국 인덱스를 리턴해야하는데 인덱스를 value로 가지고 있으면 어떨까!? 
3. 로직을 조건은 어떻게 할까?!
	1. target - nums[i]가 해시맵에 있으면은 어떤가?! 
		1. 조건을 만족하고  a + b = c를 이항하여 c - b = a 이기에 동일한 조건이라고 생각되어진다.
4. 포문을 돌고 위의 로직을 조건절로 주자. 구현해보자

```python
def twoSum(self, nums: List[int], target: int) -> List[int]:
    dict = {}
    for i in range(len(nums)):
		if target - nums[i] not in dict :
	       dict[nums[i]] = i
         else : 
			return [dict[target - nums[i]], i]
```


### 관련있는 개념


