conectado(i,a).
conectado(i,b).
conectado(a,b).
conectado(a,c).
conectado(b,f).
conectado(b,c).
conectado(c,f).

conectados(X,Y):- conectado(X,Y).
conectados(X,Y):- conectado(Y,X).


ruta(Ini,Fin,Ruta):- ruta2(Ini,Fin,[],Ruta).

ruta2(Fin,Fin,_,[Fin]).
ruta2(Ini,Fin,Visitados,[Ini|Resto]):-
    conectados(Ini,Alguien),
    %%conectado(Ini,Alguien),
    not(member(Alguien,Visitados)),
    ruta2(Alguien,Fin,[Ini|Visitados],Resto).





