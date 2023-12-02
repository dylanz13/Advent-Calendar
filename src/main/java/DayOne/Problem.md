#### FROM: https://adventofcode.com/2023/day/1
## --- Day 1: Trebuchet?! ---

### Part 1:
On each line, the calibration value can be found by combining the first digit and the last digit (in that order) 
to form a single two-digit number.

For example:
<ul>
<li>1abc2</li>
<li>pqr3stu8vwx</li>
<li>a1b2c3d4e5f</li>
<li>treb7uchet</li>
</ul>

In this example, the calibration values of these four lines are 12, 38, 15, and 77. 
Adding these together produces 142.

Consider your entire calibration document. What is the sum of all of the calibration values?

### Part 2:
Your calculation isn't quite right. It looks like some of the digits are actually spelled out with letters: 
one, two, three, four, five, six, seven, eight, and nine also count as valid "digits".

Equipped with this new information, you now need to find the real first and last digit on each line. For example:

<ul>
<li>two1nine</li>
<li>eightwothree</li>
<li>abcone2threexyz</li>
<li>xtwone3four</li>
<li>4nineeightseven2</li>
<li>zoneight234</li>
<li>7pqrstsixteen</li>
</ul>
In this example, the calibration values are 29, 83, 13, 24, 42, 14, and 76. Adding these together produces 281.

What is the sum of all of the calibration values?
