# [Bronze III] Dishonest Lottery - 32500 

[문제 링크](https://www.acmicpc.net/problem/32500) 

### 성능 요약

메모리: 22232 KB, 시간: 256 ms

### 분류

구현

### 제출 일자

2025년 10월 11일 16:53:11

### 문제 설명

<p>You suspect your local lottery of cheating! Some numbers are coming up too often!</p>

<p>Each week, the lottery randomly selects five numbers in the range from one to fifty. So, each number should appear about $10\%$ of the time if the numbers are truly chosen randomly. If a number appears far more than that, it’s suspicious!</p>

<p>Determine if a set of lottery drawings is suspicious by listing all numbers that appear too often. To allow for random error, you’ll need to flag any number that appears more than $20\%$ of the time.</p>

### 입력 

 <p>The first line of input contains a single integer $n$ ($1≤n≤1\,000$). There will be $10 \cdot n$ lottery results for you to analyze.</p>

<p>Each of the next $10 \cdot n$ lines contains $5$ integers $x$ ($1≤x≤50$). Each line represents a drawing. All values on a line are unique.</p>

### 출력 

 <p>On a single line, output all numbers that appear strictly more than $2 \cdot n$ times in the list. If there is more than one, output them space-separated, in sorted order from smallest to largest. If there aren’t any, output $-1$.</p>

