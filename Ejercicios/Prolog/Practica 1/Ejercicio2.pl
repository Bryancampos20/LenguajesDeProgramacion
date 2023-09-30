subconj(_, []).
subconj(S, [X|S1]) :- member(X, S), subconj(S, S1).