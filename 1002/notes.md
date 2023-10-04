# Streams

What is a stream?

A stream is just a collection of things, similar to other classes in the Collections API.

Difference: we can chain operations together, functionally.

Chained operations:

stream()
map
filter
sorted

We need to introduce lambda functions.

Lambda functions are anonymous functions, i.e., functions without a name.

x -> x * x // squares x.

We can use lambdas inside of stream operations.

E.g., ArrayList<Integer> ls = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
Stream<Integer> res = ls.stream().map(x -> x * x);

Terminal operations are not further "chainable"; they consolidate into a value or nothing at all.

Terminal operations:

collect
forEach
reduce

Streams are LAZY operations; they are not computed until requested.

E.g., 

ArrayList<Integer> fls = new ArrayList<>(List.of(40, 50, 100, 200));
Stream<Integer> sfls = fls.stream().map(x -> Fibonacci.fib(x));

// Until we reference an element of sfls, the stream won't execute a fibonacci iteration.
// Thank god, because this will take an eternity (quite literally...) 2^40, 2^50, 2^100??????


