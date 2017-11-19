# Regarding the Song-Challenge

Since the objective was to refactor the code - and the code could only be refactored in the presence of passing tests - I hopefully did the right thing and wrote the tests first.

Please note:

## 1
I was slightly confused about how to end the first line of each verse:

*1. Verse*
> There was an old lady who swallowed a fly.

ends with a dot (.) ,

*Middle Verses*
> There was an old lady who swallowed a spider;

end with a semicolon (;) ,

*Last Verse*
> There was an old lady who swallowed a horse...

ends with three dots (...) .

So that is how I programmed it to behave...

## 2
The song can be made configurable by setting 
~~~
List<String> animals
~~~
and
~~~
Map<String, String> rhymes
~~~
properties through their respective setters.

## 3
Since I thought testing the main-method of Song would be bad style, I took the liberty to test 
~~~
String song = song.sing();
~~~

## 4
There was no easy way to test, if the second line rhymes with the first one (i.e. 'fly' and 'die' rhyme), so it is not covered by any tests.
