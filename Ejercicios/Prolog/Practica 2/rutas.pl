% Definición de conexiones con pesos
conectado(i, a, 2).
conectado(i, b, 3).
conectado(i, d, 5).
conectado(a, b, 1).
conectado(a, c, 4).
conectado(b, f, 2).
conectado(b, c, 3).
conectado(c, f, 5).
conectado(d, e, 4).
conectado(e, f, 3).

ruta_mas_corta(Ini, Fin, Ruta, Peso) :-
    ruta2(Ini, Fin, [], Ruta, 0, Peso).

ruta2(Fin, Fin, _, [Fin], Peso, Peso).

ruta2(Inicio, Fin, Visitados, [Inicio | Resto], PesoActual, PesoTotal) :-
    conectado(Inicio, Alguien, Peso),
    not(member(Alguien, Visitados)),
    NuevoPesoActual is PesoActual + Peso,
    ruta2(Alguien, Fin, [Inicio | Visitados], Resto, NuevoPesoActual, PesoTotal).

ruta_corta(Inicio, Fin, Ruta, Peso) :-
    findall([R, P], ruta_mas_corta(Inicio, Fin, R, P), Rutas),
    peso_min(Rutas, [Ruta, Peso]).

peso_min([[Ruta, Peso]], [Ruta, Peso]).
peso_min([[_, P1] | Resto], [R2, P2]) :-
    peso_min(Resto, [R2, P2]),
    P1 >= P2.
peso_min([[R1, P1] | Resto], [R1, P1]) :-
    peso_min(Resto, [_, P2]),
    P1 < P2.