let n_esimo n lista =
    let indices = [0..(n - 1)]  // Crea una lista de índices desde 0 hasta n-1
    let result = List.map (fun i ->
        match List.tryItem i lista with
        | Some(x) -> x
        | None -> 0) indices // Se asume 0 como valor predeterminado
    if n <= List.length lista then result.[n - 1].ToString()
    else "false"

// Ejemplos de uso
printfn "%s" (n_esimo 2 [1; 2; 3; 4; 5]) 
printfn "%s" (n_esimo 3 [1; 2; 3; 4; 5]) 
printfn "%s" (n_esimo 6 [1; 2; 3; 4; 5]) 
