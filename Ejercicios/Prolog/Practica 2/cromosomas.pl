persona(carlos, alfaro, [1, 0, 1, 1, 0, 1, 0, 0, 1, 1]).
persona(pedro, ramirez, [0, 1, 1, 0, 1, 0, 1, 1, 0, 0]).
persona(marta, saguero, [1, 1, 0, 0, 1, 0, 0, 1, 1, 1]).
persona(pedro, camcho, [0, 1, 0, 0, 1, 1, 1, 0, 0, 1]).
persona(ana, castro, [1, 0, 1, 1, 0, 0, 1, 1, 0, 0]).
persona(luis, martinez, [0, 1, 1, 0, 0, 1, 0, 1, 1, 1]).
persona(barbara, fernandez, [1, 0, 0, 1, 0, 0, 1, 0, 0, 1]).
persona(pedro, santos, [0, 1, 0, 1, 1, 1, 0, 1, 1, 0]).
persona(alejandro, torres, [1, 1, 1, 0, 0, 0, 1, 0, 0, 1]).
persona(miguel, ortiz, [0, 0, 1, 1, 1, 1, 0, 0, 1, 1]).

persona_mas_similar(Sample, Persona, Porcentaje) :-
    persona(Persona, _, _), % Inicializamos Persona y Porcentaje
    similitud_porcentaje(Sample, Persona, Porcentaje), % Calcula la similitud con la primera persona en la base
    find_persona_similar(Sample, Persona, Porcentaje).

find_persona_similar(_, _, OtraSimilitud) :-
    persona(_, _, _),
    similitud_porcentaje(_, _, OtraSimilitud), % Intenta encontrar otra persona en la base
    OtraSimilitud > _ , % No planeamos usar el valor de OtraSimilitud en este contexto
    !,
    find_persona_similar(_, _, OtraSimilitud). 
find_persona_similar(_, _, _).

similitud_porcentaje(Sample, Persona, Porcentaje) :-
    persona(Persona, _, CromosomaPersona),
    calcula_distancia_hamming(Sample, CromosomaPersona, Distancia),
    length(Sample, Longitud),
    Porcentaje is 100 * (1 - (Distancia / Longitud)).

calcula_distancia_hamming([], [], 0).
calcula_distancia_hamming([H1|T1], [H2|T2], Distancia) :-
    calcula_distancia_hamming(T1, T2, DistanciaRestante),
    (H1 = H2 -> Distancia is DistanciaRestante ; Distancia is DistanciaRestante + 1).

persona_mas_similar_destacada(Sample, PersonaMasSimilar, PorcentajeMasAlto) :-
    findall([Persona, Porcentaje], similitud_porcentaje(Sample, Persona, Porcentaje), Resultados),
    max_porcentaje(Resultados, [PersonaMasSimilar, PorcentajeMasAlto]).

max_porcentaje([], [_, 0.0]).
max_porcentaje([[Persona, Porcentaje]|T], Max) :-
    max_porcentaje(T, [OtraPersona, OtraPorcentaje]),
    (Porcentaje >= OtraPorcentaje -> Max = [Persona, Porcentaje] ; Max = [OtraPersona, OtraPorcentaje]).

