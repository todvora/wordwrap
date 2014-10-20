## Problem description
Create a function that takes two parameters: a string, and an integer that represents maximum line length. 
The function should return the string with linebreaks inserted at the right positions, like a word processor,
to ensure that no line is longer than the maximum line length.

## Python original implementation
In python is this function implemented by [textwrap module](https://docs.python.org/2/library/textwrap.html). 
 
## Python -> Java
This task was originally solved during Python [SalzPUG](http://www.meetup.com/SalzPUG/) meeting (see [github repo](https://github.com/SalzPUG/wordwrap)). 
I wanted to try different approach and implement solution in my favorite Java. 

## Tests 
Test are the same as in SalzPUG python version, only rewritten to JUnit. You can run all the tests by calling maven goal test:
```mvn test```. 
