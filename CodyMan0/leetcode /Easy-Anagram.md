MOC(Map of content ): 알고리즘 포스트가 쌓이면 추가할 예정
source : https://leetcode.com/problems/valid-anagram/description/

## 2024-03-28

### 문제

Given two strings `s` and `t`, return `true` *if* `t` *is an anagram of* `s`*, and* `false` *otherwise*.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

### 아이디어

1. s와 t의 길이가 다르면 무조건 False 값을 얼리 리턴한다.
2. s와 t 각각 for문으로 string 내부 하나의 문자를 순회하면서 해당 문자의 유니코드를 빈 배열에 append 한다.
3. 각각 append된 배열을 오름차순으로 정렬한다.
4. 정려한 배열을 for문으로 순회하면서 두개의 배열에 같은 인덱스가 같은 값인지 확인하고 다르면 False를 리턴하도록 구현한다.

### 리팩터링 부분

- 자료구조 : unicode로 변환한 값을 배열에 각각 추가하는 것이 효과적인 것일까!?
- 마지막 비교 로직 : 정렬한 두개의 비열을 일일이 비교하고 다르면 False 를 반환하는게 좋은 로직일까!?

### 시간 복잡도

n + n + n = O(n)

### 내 풀이

소요 시간 : 15분

```python
 def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t) :
            return False

        sumOfS = []
        sumOfT = []

        for i in range(len(s)) :
            sumOfS.append(ord(s[i]))

        for j in range(len(t)) :
            sumOfT.append(ord(t[j]))

        sumOfS.sort()
        sumOfT.sort()

        for k in range(len(s)) :
            if(sumOfS[k] != sumOfT[k]) :
                return False
        return True
```

- 정답 결과
  ![](https://velog.velcdn.com/images/sharphand1/post/8b0b46e4-3e11-401e-9816-246e6a891c50/image.png)

### 최적화 정답을 찾아가는 과정

1. 자료구조 : unicode로 변환한 값을 배열에 각각 추가하는 것이 효과적인 것일까!?
2. 마지막 비교 로직 : 정렬한 두개의 비열을 일일이 비교하고 다르면 False 를 반환하는게 좋은 로직일까!?

1번 보완 : 배열이 아니라 객체에 담아서 알파벳의 존재 여부를 파악할 수 있다.
2번 보완 : 객체의 키값이 없거나 키값은 있는데 0이라는 의미는 s 문자열에는 있지만 t에 없거나 그 반대를 거르는 로직이다. 그럴 경우 False로 반환하고 동일할 경우 객체해서 해당 key를 -1 해준다. 그렇게 for 문을 순회한다.

```python

# input : "rat"
def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        counter = {}

        for char in s:
            counter[char] = counter.get(char, 0) + 1
        # print (counter) # {'r': 1, 'a': 1, 't': 1}

        for char in t:
            if char not in counter or counter[char] == 0:
                return False
            counter[char] -= 1

        return True
```

![](https://velog.velcdn.com/images/sharphand1/post/ebd04c06-8e41-454f-ad32-1f7cb939f82a/image.png)

### 관련있는 개념

파이썬, JS의 배열의 시간 복잡도를 살펴보자.

- 탐색 : O(1)
- 삽입/삭제 : O(N)

파이썬, JS의 해시맵, 객체의 시간 복잡도를 살펴보자.

- 탐색 : O(N)
- 삽입/삭제 : O(1)
