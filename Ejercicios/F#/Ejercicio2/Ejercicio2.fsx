let filtraPorSubcadena (subcadena: string) (lista: string list) =
    List.filter (fun (str: string) -> str.Contains(subcadena)) lista

let subcadena = "la"
let listaDeCadenas = ["la casa"; "el perro"; "pintando la cerca"]

let resultado = filtraPorSubcadena subcadena listaDeCadenas

printfn "%A" resultado
