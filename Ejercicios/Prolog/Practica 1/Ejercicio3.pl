aplanar([], []).
aplanar([X|Resto], L2) :- 
    is_list(X),   % Verifica si X es una lista.
    aplanar(X, XPlano),   % Aplana la lista X.
    aplanar(Resto, RestoPlano),   % Aplana el resto de la lista.
    append(XPlano, RestoPlano, L2).   % Concatena las listas aplanadas.
aplanar([X|Resto], [X|RestoPlano]) :- 
    \+ is_list(X),   % Si X no es una lista, lo conservamos.
    aplanar(Resto, RestoPlano).
