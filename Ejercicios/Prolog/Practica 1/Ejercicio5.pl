sub_cadenas(_, [], []).
sub_cadenas(Subcadena, [Cadena|Resto], [Cadena|FiltradasResto]) :-
    sub_atom(Cadena, _, _, _, Subcadena),
    sub_cadenas(Subcadena, Resto, FiltradasResto).
sub_cadenas(Subcadena, [_|Resto], Filtradas) :-
    sub_cadenas(Subcadena, Resto, Filtradas).
