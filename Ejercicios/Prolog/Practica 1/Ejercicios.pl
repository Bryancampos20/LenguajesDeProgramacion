%--------------- Ejercicio 1 ------------------

sumlist([], 0).
sumlist([X|Resto], S) :- sumlist(Resto, SResto), S is X + SResto.

%--------------- Ejercicio 2 ------------------

subconj(_, []).
subconj(S, [X|S1]) :- member(X, S), subconj(S, S1).

%--------------- Ejercicio 3 ------------------

aplanar([], []).
aplanar([X|Resto], L2) :- 
    is_list(X),   % Verifica si X es una lista.
    aplanar(X, XPlano),   % Aplana la lista X.
    aplanar(Resto, RestoPlano),   % Aplana el resto de la lista.
    append(XPlano, RestoPlano, L2).   % Concatena las listas aplanadas.
aplanar([X|Resto], [X|RestoPlano]) :- 
    \+ is_list(X),   % Si X no es una lista, lo conservamos.
    aplanar(Resto, RestoPlano).

%--------------- Ejercicio 4 ------------------

partir([], _, [], []).
partir([X|Resto], Umbral, [X|Menores], Mayores) :-
    X =< Umbral,
    partir(Resto, Umbral, Menores, Mayores).
partir([X|Resto], Umbral, Menores, [X|Mayores]) :-
    X > Umbral,
    partir(Resto, Umbral, Menores, Mayores).

%--------------- Ejercicio 5 ------------------

sub_cadenas(_, [], []).
sub_cadenas(Subcadena, [Cadena|Resto], [Cadena|FiltradasResto]) :-
    sub_atom(Cadena, _, _, _, Subcadena),
    sub_cadenas(Subcadena, Resto, FiltradasResto).
sub_cadenas(Subcadena, [_|Resto], Filtradas) :-
    sub_cadenas(Subcadena, Resto, Filtradas).
