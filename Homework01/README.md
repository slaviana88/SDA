# The royal programmer - WW1 version

The war against Serbia was dynamic and face-paced (unlike
many of the other fronts in the same time). To make the task
of bookkeping where every soldier is currently on the front
and what's his status, tzar Ferdinand has ordered to you,
the royal programmer, to write a small program that tracks
in what battle unit ever soldier is.

Since the program will be mainly used by people who've never
seen a computer, program work with text. For example,
this one:

```
brigade1 = [1, 2, 3, 4, 5]
brigade2 = [6, 7, 8, 9, 10, 11]
division1 = []
brigade1 attached to division1 # division1 == [1, 2, 3, 4, 5]
brigade2 attached to division1 # division1 == [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
soldiers 4..10 from division1 died heroically  # division1 == [1, 2, 3, 11], brigade1 == [1, 2, 3], brigade2 == [11]
brigade3 = [15, 16, 23]
brigade3 attached to division1 after soldier 3 # division1 == [1, 2, 3, 15, 16, 23, 11]
show division1

Output: [1, 2, 15, 16, 23, 3, 11]
```

For the whole condition of homework - [Royal Programmer](https://github.com/nikoladimitroff/DSA-Demo-Library/blob/master/homeworks/hw1-2015.md).