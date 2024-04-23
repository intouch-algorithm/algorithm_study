root : [[Leetcode]]
url : https://leetcode.com/problems/3sum/description/

## 2024-04-23 15:39

### 문제

Given an integer array nums, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

정수로 이루어진 nums라는 배열이 주어진다면, i는 j와 다르고 k와 다르고 j는 k와 다르며 `nums[i] + nums[j] + nums[k] == 0`하는 `[nums[i], nums[j], nums[k]]` 세 요소를 반환하세요.

Notice that the solution set must not contain duplicate triplets.

**Example 1:**

**Input:** nums = [-1,0,1,2,-1,-4]
**Output:** `[[-1,-1,2],[-1,0,1]]`
**Explanation:**
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

**Example 2:**

**Input:** nums = [0,1,1]
**Output:** []
**Explanation:** The only possible triplet does not sum up to 0.

**Example 3:**

**Input:** nums = [0,0,0]
**Output:** [[0,0,0]]
**Explanation:** The only possible triplet sums up to 0.

**Constraints:**

- `3 <= nums.length <= 3000`
- `-105 <= nums[i] <= 105`

### 아이디어

크흠 어떻게 풀기!? 삼중 포문을 풀 수 있으나 이렇게 풀면 O^3 시간 복잡도가 나온다.

두포인터 문제니깐?! 투 포인터로 가자!! 4. 미자막은 각 인자 정렬해서 set 으로 중복되는 거 없애주면 될까?!

1. 우선 정렬해서 투 포인터 효율적으로 구현할 수 있는 환경 구성
2. triplets라는 세트 자료 구조를 초기화한다.
3. 배열의 각 엘리먼트를 반복하는 루프를 진행, 0부터 마지막에서 2번째까지. 왜냐하면 적어도 3개의 엘리먼트가 필요하기 때문
4.

### 첫번째 풀이

소요 시간 : 25m

```python
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        triplets = set()
        for i in range(len(nums) - 2) :
            firstNum = nums[i]
            j = i + 1
            k = len(nums) - 1
            while j < k :
                secondNum = nums[j]
                thirdNum = nums[k]

                potentialSum = firstNum + secondNum + thirdNum
                if potentialSum > 0 :
                    k -= 1
                elif potentialSum < 0 :
                    j += 1
                else :
                    triplets.add((firstNum, secondNum, thirdNum))
                    j += 1
                    k -= 1
        return triplets
```

### 관련있는 개념
