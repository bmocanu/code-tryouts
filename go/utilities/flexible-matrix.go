package utilities

type Cell struct {
	x     int
	y     int
	value int
}

type FlexibleIntMatrix struct {
	cellMap   map[int]*Cell
	cellCount int
}

func (matrix *FlexibleIntMatrix) Init() {
	matrix.cellMap = make(map[int]*Cell)
}

func (matrix *FlexibleIntMatrix) Set(x int, y int, value int) {
	var targetCell = matrix.getCell(x, y)
	if targetCell == nil {
		targetCell = new(Cell)
		matrix.cellCount++
		matrix.cellMap[CantorPairingValue(x, y)] = targetCell
	}

	targetCell.value = value
}

func (matrix *FlexibleIntMatrix) Get(x int, y int) int {
	var existingCell = matrix.getCell(x, y)
	if existingCell != nil {
		return existingCell.value
	}
	return 0
}

func (matrix *FlexibleIntMatrix) Size() int {
	return matrix.cellCount
}

func (matrix *FlexibleIntMatrix) getCell(x int, y int) *Cell {
	var cell, cellFound = matrix.cellMap[CantorPairingValue(x, y)]
	if cellFound {
		return cell
	}
	return nil
}
