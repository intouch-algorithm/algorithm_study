root : [[Leetcode]]
source : https://leetcode.com/problems/group-anagrams/

## 2024-03-29 08:41

### 문제

Given an array of strings `strs`, group **the anagrams** together. You can return the answer in **any order**.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

**Example 1:**

**Input:** strs = ["eat","tea","tan","ate","nat","bat"]
**Output:** [["bat"],["nat","tan"],["ate","eat","tea"]]

**Example 2:**

**Input:** strs = [""]
**Output:** [[""]]

**Example 3:**

**Input:** strs = ["a"]
**Output:** [["a"]]

**Constraints:**

- `1 <= strs.length <= 104`
- `0 <= strs[i].length <= 100`
- `strs[i]` consists of lowercase English letters.

### 아이디어

[정렬을 활용한 anagram 판별]

1. 입력인 string[]를 for문으로 순회하면서 각 index의 string을 unicode 기준으로 정렬한다.
2. 정렬한 값을 해시테이블에 키로 저장하고 값에는 배열형식으로 데이터를 sorted_word가 아닌 word를 저장한다. (이부분을 바로 생각하지 못함.)
3. 해시 테이블에 있는 value를 Object.values()로 이중 배열로 만들면 된다.

[정렬을 활용하지 않고 anagram 판별]

1.  제약 사항에 알파벳 소문자로 이루어졌다는 근거를 활용하여 number[].length가 26으로 초기화한다.
2.  이중 포문 안에서 ord 함수를 활용하여 각 자리에 + 1 을 합니다.
3.  위의 배열을 딕셔너리의 키로 사용해서 (배열은 딕셔너리의 키로 사용하지 못한다?! )
4.  위와 같이 해시 테이블에 있는 value를 Object.values()로 이중 배열로 만들면 된다.

### 놓친 부분

- 해시 테이블의 키와 값을 어떻게 활용할지 감을 잡지 못했다. (key로는 정렬된 string 값은 key로 정렬가능한 목록을 담은 배열을 초기화할 수 있었다.)

### 시간 복잡도

### 내 풀이

소요 시간 : 30분

````python
def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = {}
        for word in strs :
            sorted_word = str(sorted(word))
            if sorted_word not in anagrams :
                anagrams[sorted_word] = []
            anagrams[sorted_word].append(word)
        return anagrams.values()```
### 또 다른 정답
```python
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = {}
        for word in strs :
            counter = [0] * 26
            for char in word :
                counter[ord(char) - ord('a')] += 1
            if tuple(counter) not in anagrams :
                anagrams[tuple(counter)] = []
            anagrams[tuple(counter)].append(word)

        return anagrams.values()
````

### 2번째 풀이 최적화 코드

```python
	from collections import defaultdict

	def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = defaultdict(list)
        for word in strs :
            counter = [0] * 26
            for char in word :
                counter[ord(char) - ord('a')] += 1
            anagrams[tuple(counter)].append(word)

        return anagrams.values()
```

### 관련있는 개념 학습

- **파이썬의 collections 모듈**
  collections 모듈은 데이터 타입을 제공하는 내장 모듈로 보다 데이터 구조를 확장하여 구현되어 있다. 사용할 수 있는 모듈 몇가지만 정리해보면,

1. Counter

```python
from collections import Counter

c = Counter(['apple', 'banana', 'apple', 'pear', 'banana', 'orange'])
print(c)  # Counter({'apple': 2, 'banana': 2, 'pear': 1, 'orange': 1})
```

중복값을 포함하는 이터러블한 데이터를 입력으로 받으면 사전 형태로 중복된 키의 값을 1씩 더해 어떤 키가 몇번 등장했는지 빠르게 알 수 있도록 도와주는 라이브러리이다. 우선 Counter를 쓰지 않고 구현하는것에 익숙해져야한다.

```python
def countLetters(word):
    counter = {}
    for letter in word:
        if letter not in counter:
            counter[letter] = 0
        counter[letter] += 1
    return counter
```

2. defaultdict
   존재하지 않는 키에 대해 기본적으로 자료 구조를 지정할 수 있게 도와준다. 코드 내에서 예외 사항 처리를 줄여줄 수 있다.

```python
from collections import defaultdict

dd = defaultdict(int)  # 기본값으로 int()를 사용 (0을 반환)
dd['key'] += 1
print(dd['key'])  # 1
```

3. deque
   BFS 문제를 풀때 보았던 덱이라는 자료구조는 양쪽 끝에서 빠르게 추가하고 제거할 수 있는 리스트와 유사한 자료구조이다. 리스트보다 빠른 연산 속도를 보장한다.

```python
from collections import deque

d = deque(['a', 'b', 'c'])
d.append('d')  # 오른쪽 끝에 추가
d.appendleft('z')  # 왼쪽 끝에 추가
print(d)  # deque(['z', 'a', 'b', 'c', 'd'])
```

- **튜플**
  배경 : 배열을 키로 사용하려고 하니 에러가 뜬다. 튜플로 구현하면 문제 없이 동작
  내용 : 파이썬에서는 딕셔너리 키는 불변 타입이어야한다. 배열은 가변 타입으로 추가나 삭제 및 변경이 가능하기에 키로 사용할 수 없다. 반면 튜플은 생성 후에 내용 변경이 불가한 불변 타입이다.

> 배열과 튜플의 핵심적인 차이는 불변하다는 것.

- 불변성이란?!
  프로그래밍에서 불변하다는 것은 객체의 상태나 데이터가 생성된 후 변경될 수 없음을 의미한다.

장점

1. 안정성 : 사이드 이팩트가 발생할 가능성이 낮아서 버그 발생 확률이 낮다.
2. 스레드 안전 : 동시성 문제를 신경 쓸 필요가 없다.
3. 해시 가능 : 변경되지 않는 고유한 값인 해시값을 가진다.

단점

1. **메모리 사용 및 성능**: 불변 객체의 상태를 변경하려 할 때마다 새로운 객체가 생성되어야 합니다. 이는 메모리 사용량이 증가하고, 객체를 생성하고 가비지 컬렉션(garbage collection)이 발생하는 데 따른 성능 저하를 일으킬 수 있습니다. 크고 복잡한 객체의 경우, 불변성이 오히려 비효율적일 수 있습니다.

- 리액트에서 useState의 상태인 state는 불변한데 위의 단점을 어떻게 완화하고 있지?!
  **3월 29일 찾아보고 내일 블로그 글 작성하기**
