package main

import (
	"fmt"
	"math"
)

func imprimirRombo(n int) {
	if n%2 == 0 || n < 1 {
		fmt.Println("La cantidad de asteriscos centrales del rombo debe ser un número impar positivo.")
		return
	}

	mitad := int(math.Ceil(float64(n) / 2))
	for i := 1; i <= n; i += 2 {
		for j := 0; j < mitad-i/2; j++ {
			fmt.Print(" ")
		}
		for j := 0; j < i; j++ {
			fmt.Print("*")
		}
		fmt.Println()
	}

	for i := n - 2; i > 0; i -= 2 {
		for j := 0; j < mitad-i/2; j++ {
			fmt.Print(" ")
		}
		for j := 0; j < i; j++ {
			fmt.Print("*")
		}
		fmt.Println()
	}
}

func main() {
	var cantidadElementos int
	fmt.Print("Ingrese la cantidad de asteriscos centrales del rombo: ")
	fmt.Scanln(&cantidadElementos)
	imprimirRombo(cantidadElementos)
}
