type Maze = (int * int list) list
let graphMaze : Maze = [
                                    (1,[7]); 
                                    (2,[3;8]);
                                    (3,[2;4;9]);
                                    (4,[3;10]); 
                                    (5,[6;11]); 
                                    (6,[5]); 
                                    (7,[1;13]); 
                                    (8,[2;9]);
                                    (9,[3;8]); 
                                    (10,[4;16]);
                                    (11,[5;17]); 
                                    (12,[18]);
                                    (13,[7;14]);
                                    (14,[13;15;20]);
                                    (15,[14;21]);
                                    (16,[10;22]); 
                                    (17,[11;23]);
                                    (18,[12;24]); 
                                    (19,[25]); 
                                    (20,[14;26]);
                                    (21,[15;22]);
                                    (22,[16;21]);
                                    (23,[17;29]); 
                                    (24,[18;30]); 
                                    (25,[19;31]);
                                    (26,[20;27]);
                                    (27,[26;28]);
                                    (28,[27;29;34]);
                                    (29,[23;28]); 
                                    (30,[24;36]); 
                                    (31,[25;32]);
                                    (32,[31;33]);
                                    (33,[32;34]);
                                    (34,[28;33;35]);
                                    (35,[34;36]);
                                    (36,[35;30]);
                        ]
//Los casos de inicio y fin son 2 y 32 respectivamente.
//El camino esperado del laberinto debe ser 2,3,4,10,16,22,21,15,14,20,26,27,28,34,33,32
//La función encontró todas las rutas posibles usando DFS
let findAllPathsDFS (graph: Maze) start endCase =
    let rec dfs path currentCase =
        if currentCase = endCase then
            [List.rev (currentCase::path)]
        else
            match List.tryFind (fun (case, neighbors) -> case = currentCase) graph with
            | Some (_, neighbors) ->
                let validNeighbors = List.filter (fun c -> not (List.contains c path)) neighbors
                List.collect (dfs (currentCase::path)) validNeighbors 
            | None -> []

    dfs [] start

//Función para imprimir todas las rutas encontradas
let printPaths paths =
    paths |> List.iter (fun path ->
        printfn "Path Encontrado: %A" path
    )

//Llama a la función con los casos de inicio y fin
let allPaths = findAllPathsDFS graphMaze 2 32

printPaths allPaths

//Función para encontrar el camino más corto usando BFS
let findShortestPathBFS (graph: Maze) start endCase =
    let rec bfs queue visited =
        match queue with
        | [] -> None
        | (currentCase, path) :: rest when currentCase = endCase -> Some (List.rev (currentCase::path))
        | (currentCase, path) :: rest ->
            //Obtiene vecinos del caso actual que no han sido visitados
            match List.tryFind (fun (case, _) -> case = currentCase) graph with
            | Some (_, neighbors) ->
                let unvisitedNeighbors =
                    neighbors
                    |> List.filter (fun c -> not (List.contains c visited))
                    |> List.map (fun c -> (c, currentCase::path))
                let newQueue = rest @ unvisitedNeighbors
                bfs newQueue (currentCase :: visited)
            | None -> None 

    bfs [(start, [])] []

// Llame a la función con los casos de inicio y fin
match findShortestPathBFS graphMaze 2 32 with
| Some shortestPath -> printfn "Path Corto: %A" shortestPath
| None -> printfn "No path encontrado"

(*
let noWall: Maze =[
                        (1,[2;7]);
                        (2,[1;3;8]);
                        (3,[2;4;9]);
                        (4,[3;5;10]);
                        (5,[4;6;11]);
                        (6,[5;12]);
                        (7,[1;8;13]);
                        (8,[2;7;9]);
                        (9,[3;8;10]);
                        (10,[4;9;11]);
                        (11,[5;10;12]);
                        (12,[6;11;18]);
                        (13,[7;14;19]);
                        (14,[13;15;20]);
                        (15,[14;16;21]);
                        (16,[15;17;22]);
                        (17,[16;18;23]);
                        (18,[12;17;24]);
                        (19,[13;20;25]);
                        (20,[14;19;21]);
                        (21,[15;20;22]);
                        (22,[16;21;23]);
                        (23,[17;22;24]);
                        (24,[18;23;30]);
                        (25,[19;26;31]);
                        (26,[25;27;32]);
                        (27,[26;28;33]);
                        (28,[27;29;34]);
                        (29,[28;30;35]);
                        (30,[24;29;36]);
                        (31,[25;32]);
                        (32,[26;31;33]);
                        (33,[27;32;34]);
                        (34,[28;33;35]);
                        (35,[29;34;36]);
                        (36,[30;35]);
]

// Encontré todo el camino sin paredes.
let allPathsNoWall = findAllPathsDFS noWall 2 32

// Imprimir los caminos encontrados.
printPaths allPathsNoWall

// Encontré el camino más corto sin paredes.
match findShortestPathBFS noWall 2 32 with
| Some shortestPath -> printfn "Camino mas corto: %A" shortestPath
| None -> printfn "Path no encontrado"*)


