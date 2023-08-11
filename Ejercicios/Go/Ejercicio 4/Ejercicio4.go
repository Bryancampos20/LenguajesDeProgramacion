package main

import "fmt"

type Calzado struct {
	Modelo string
	Precio float64
	Talla  int
	Stock  int 
}

func venderZapato(zapato *Calzado) {
	if zapato.Stock > 0 {
		zapato.Stock--
		fmt.Println("Venta realizada:", zapato.Modelo, "- Talla:", zapato.Talla)
	} else {
		fmt.Println("No hay stock disponible para:", zapato.Modelo, "- Talla:", zapato.Talla)
	}
}

func main() {

	inventario := []Calzado{
		// Modelo, Precio, Talla, Stock
		{"Nike", 50000, 42, 5},
		{"Adidas", 60000, 39, 3},
		{"Puma", 45000, 37, 0},
		{"Reebok", 55000, 44, 7},
		
	}

	// Realizar ventas de zapatos
	venderZapato(&inventario[0])
	venderZapato(&inventario[1])
	venderZapato(&inventario[2])
	venderZapato(&inventario[3])
	venderZapato(&inventario[0])
	venderZapato(&inventario[3])
	venderZapato(&inventario[0])
	venderZapato(&inventario[3])

	// Imprimir el inventario después de las ventas
	fmt.Println("\nInventario actual:")
	for _, zapato := range inventario {
		fmt.Printf("Modelo: %s - Talla: %d - Stock: %d\n", zapato.Modelo, zapato.Talla, zapato.Stock)
	}
}
