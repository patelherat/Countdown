# Countdown

A player is given 100 random 1 digit numbers and a random 4 digit target. They must create an arithmetic expression involving all 100 numbers using [+, -, *, /] that produces a result as close to the target as possible. The operations are applied in order so you should ignore order of operations and just evaluate everything in order of appearance. e.g. 1+2*6 = (1+2)*6 = 18 NOT: 2*6+1
For instance, in a simpler game involving 3 numbers and a 2 digit target:
Numbers=[2,5,9]
Target: 1
Solution: ((5)*2)-9 = 1

I have implemented a random-restart hill climbing(pg 124) algorithm that attempts to find the expression that is as close as possible to the target using:-

1) swap(n1,n2) - swaps the position of the number at index n1 with the one at index n2
2) change(s1,op) - changes the operator at s1 to op


Using the same example above but cast as local search:
Given:((5)+9)-2 (a random starting state)
Target: 1
Swap(2,3): ((5)+2)-9
Change(1,*): ((5)*2)-9
Solution: ((5)*2)-9 = 1
