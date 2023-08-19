package main

import (
	"fmt"
	"sort"
)

type producto struct {
	nombre   string
	cantidad int
	precio   int
}
type listaProductos []producto

var lProductos listaProductos

const existenciaMinima int = 10 

func (l *listaProductos) agregarProducto(nombre string, cantidad int, precio int) {
	encontrado := false
	for i, p := range *l {
		if p.nombre == nombre {
			(*l)[i].cantidad += cantidad
			if p.precio != precio {
				(*l)[i].precio = precio
			}
			encontrado = true
			break
		}
	}

	if !encontrado {
		*l = append(*l, producto{nombre: nombre, cantidad: cantidad, precio: precio})
	}
}


func (l listaProductos) buscarProducto(nombre string) (*producto, int) {
	for i, p := range l {
		if p.nombre == nombre {
			return &l[i], 0
		}
	}
	return nil, 1 
}

func (l listaProductos) venderProducto(nombre string, cant int) {
	prod, errCode := l.buscarProducto(nombre)

	if errCode == 1 {
		fmt.Println("Producto no encontrado")
		return
	}

	if prod.cantidad < cant {
		fmt.Println("No hay suficiente existencia para vender la cantidad solicitada")
		return
	}

	prod.cantidad -= cant

	if prod.cantidad <= 0 {
		fmt.Printf("Se agotó la existencia del producto %s. Eliminando de la lista.\n", nombre)
		l.eliminarProducto(nombre)
	}
}

func (l *listaProductos) eliminarProducto(nombre string) {
	for i, p := range *l {
		if p.nombre == nombre {
			*l = append((*l)[:i], (*l)[i+1:]...)
			break
		}
	}
}

func (l *listaProductos) modificarPrecio(nombre string, nuevoPrecio int) {
	prod, errCode := l.buscarProducto(nombre)

	if errCode == 1 {
		fmt.Println("Producto no encontrado")
		return
	}

	prod.precio = nuevoPrecio
}


func llenarDatos() {
	lProductos.agregarProducto("arroz", 15, 2500)
	lProductos.agregarProducto("frijoles", 4, 2000)
	lProductos.agregarProducto("leche", 8, 1200)
	lProductos.agregarProducto("café", 12, 4500)


}

func (l listaProductos) listarProductosMinimos() listaProductos {
	newSlice := make(listaProductos, 0)

	for _, p := range l {
		if p.cantidad <= existenciaMinima {
			newSlice = append(newSlice, p)
		}
	}

	return newSlice
}

func (l *listaProductos) aumentarInventarioDeMinimos(listaMinimos listaProductos) {
	for _, p := range listaMinimos {
		cantidadFaltante := existenciaMinima - p.cantidad

		if cantidadFaltante > 0 {
			fmt.Printf("Agregando %d unidades de %s al inventario.\n", cantidadFaltante, p.nombre)
			l.agregarProducto(p.nombre, cantidadFaltante, p.precio)
		}
	}
}

// Función para ordenar la lista de productos según el campo especificado
func (l listaProductos) ordenarPorCampo(campo string) {
	switch campo {
	case "nombre":
		sort.SliceStable(l, func(i, j int) bool {
			return l[i].nombre < l[j].nombre
		})
	case "cantidad":
		sort.SliceStable(l, func(i, j int) bool {
			return l[i].cantidad < l[j].cantidad
		})
	case "precio":
		sort.SliceStable(l, func(i, j int) bool {
			return l[i].precio < l[j].precio
		})
	}
}


func main() {
	llenarDatos()
	fmt.Println("Lista de productos antes de modificar precios:")
	fmt.Println(lProductos)

	// Modificar precio de un producto
	lProductos.modificarPrecio("arroz", 2800)

	fmt.Println("Lista de productos después de modificar precios:")
	fmt.Println(lProductos)

	// Vender productos
	lProductos.venderProducto("arroz", 10)
	lProductos.venderProducto("frijoles", 2)

	fmt.Println("Lista de productos después de vender:")
	fmt.Println(lProductos)

	pminimos := lProductos.listarProductosMinimos()
	fmt.Println("Productos con existencia mínima:")
	fmt.Println(pminimos)

	// Aumentar inventario de productos con mínimas existencias
	lProductos.aumentarInventarioDeMinimos(pminimos)

	fmt.Println("Lista de productos después de aumentar inventario:")
	fmt.Println(lProductos)

	// Ordenar la lista de productos por nombre
	lProductos.ordenarPorCampo("nombre")
	fmt.Println("Lista de productos ordenados por nombre:")
	fmt.Println(lProductos)

	// Ordenar la lista de productos por cantidad
	lProductos.ordenarPorCampo("cantidad")
	fmt.Println("Lista de productos ordenados por cantidad:")
	fmt.Println(lProductos)

	// Ordenar la lista de productos por precio
	lProductos.ordenarPorCampo("precio")
	fmt.Println("Lista de productos ordenados por precio:")
	fmt.Println(lProductos)
}
