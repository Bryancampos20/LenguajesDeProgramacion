let rec desplazar direccion n lista =
    let rec joinWithSpace acc = function
        | [] -> acc
        | [x] -> acc + string x
        | x::xs -> joinWithSpace (acc + string x + " ") xs

    let resultado =
        match direccion with
        | "izq" when n > 0 -> 
            if n >= List.length lista then
                List.map (fun _ -> 0) lista // Lista resultante llena de ceros
            else
                let parte1, parte2 = List.splitAt n lista
                parte2 @ (List.map (fun _ -> 0) parte1) // Concatenar parte2 con ceros en lugar de parte1
        | "der" when n > 0 ->
            if n >= List.length lista then
                List.map (fun _ -> 0) lista // Lista resultante llena de ceros
            else
                let parte1, parte2 = List.splitAt (List.length lista - n) lista
                (List.map (fun _ -> 0) parte2) @ parte1 // Concatenar ceros con parte1 en lugar de parte2
        | _ -> lista // Si la dirección no es válida, retornar la lista original

    sprintf "[%s]" (joinWithSpace "" resultado)

// Ejemplos de uso
let resultado1 = desplazar "izq" 3 [1; 2; 3; 4; 5]
let resultado2 = desplazar "der" 2 [1; 2; 3; 4; 5]
let resultado3 = desplazar "izq" 6 [1; 2; 3; 4; 5]

printfn "%s" resultado1 // Imprime: "[4;5;0;0;0]"
printfn "%s" resultado2 // Imprime: "[0;0;1;2;3]"
printfn "%s" resultado3 // Imprime: "[0;0;0;0;0]"
