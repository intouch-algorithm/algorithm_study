url : https://leetcode.com/problems/product-of-array-except-self/description/

## 2024-03-30 11:40

### 문제

정수 배열 `nums`가 주어지면, `answer[i]`가 `nums[i]`를 제외한 `nums`의 모든 요소의 곱과 같은 배열 `answer`를 반환합니다. `nums`의 어떤 접두사나 접미사의 곱도 **32비트** 정수에 **반드시** 맞습니다. **나눗셈 연산**을 사용하지 않고 `O(n)` 시간에 실행되는 알고리즘을 작성해야 합니다.

```yaml

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]


Constraints:
- 2 <= nums.length <= 105
- -30 <= nums[i] <= 30
- The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.


Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
```

### 아이디어

- 모든 배열의 값을 곱하고 나누면 바로 구할 수 있는데 문제 조건에 이렇게 하지 말라고 하니 어떻게 하는것이 좋을까?!
- prefix와 postfix 크흠 어떻게 하는게 좋을까?!

### 시간 복잡도

time complexity : O(n)
space complexity : O(1)

### 그림으로 이해해보자

![](https://velog.velcdn.com/images/sharphand1/post/69ab159b-cea4-4616-92a6-cf6762bf1d1f/image.png)

- 1번 방식으로 풀면 가능할 것 같다. 하지만 공간 복잡도를 O(1)로 구현하기 위해 동적으로 계산해서 return 하는 방식을 택했다.
- 우선 시간 복잡도가 O(n)이 되기 위해 동일한 스코프에 for문을 두 번 순회시킨다.
- 첫번째는 앞에서 뒤로 가면서 인덱스의 prefix를 확인하고 해당 nums[i]와 prefix를 곱한 값을 result 배열에 추가한다.
- 총 nums의 배열의 길이 만큼 반복한다.
- 두번째는 뒤에서 앞으로 가면서 인덱스의 postfix를 확인하여 해당 nums[i]와 postfix를 곱한 값을 기존 ressult 배열에 추가한다.
- 결과 배열을 반환한다.

### 내 풀이

소요 시간 : 40분

```python
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        res = [1] * (len(nums))

        prefix = 1
        for i in range(len(nums)):
            res[i] = prefix
            prefix *= nums[i]
        postfix = 1
        for i in range(len(nums) -1,-1 ,-1) :
            res[i] *= postfix
            postfix *= nums[i]
        return res
```

### 최적화 정답

다시 풀어보면서 찾아보자
