sumlist([], 0).
sumlist([X|Resto], S) :- sumlist(Resto, SResto), S is X + SResto.
